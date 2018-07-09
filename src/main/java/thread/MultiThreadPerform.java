package thread;

import serial.SnowflakeIdWorker;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 性能测试类
 */
public class MultiThreadPerform {
    //线程执行服务
    ExecutorService executorService;
    int threadCounts;
    CountDownLatch latch;



    //构造函数
    public MultiThreadPerform(int threadCounts, CountDownLatch latch) {
        this.threadCounts = threadCounts;
        this.executorService = Executors.newFixedThreadPool(threadCounts);
        this.latch = latch;
    }

    //启动函数
    public void run(Runnable run){

        long start = System.currentTimeMillis();
        for (int i = 0; i < threadCounts; i++) {
            System.out.println(i);
            executorService.execute(run);
        }
        try{
            latch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start));
    }
}


/**
 * 生成100个序列号
 */
class GenerateSerail implements Runnable {
    int threadCount;
    CyclicBarrier cb;
    SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);
    CountDownLatch latch;
    Map<Long, Integer> map;

    public GenerateSerail(int threadCount, CountDownLatch latch,
                          Map<Long, Integer> map){
        this.threadCount = threadCount;
        this.latch = latch;
        this.map = map;
        cb = new CyclicBarrier(threadCount);
    }

    public void run() {
        try{
            int cbcount = cb.await();
            System.out.println("cb count =" + cbcount);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + ":");
        for (int i = 0; i < 1000000; i++) {
            Long id = snowflakeIdWorker.nextId();
            map.put(id, 1);
        }
        latch.countDown();
    }
}

class test{
    public static void main(String[] args) {
        int threadCount = 10;
        CountDownLatch latch = new CountDownLatch(threadCount);
//        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0, 0);
        Map<Long, Integer> serialMap = new ConcurrentHashMap<Long, Integer>();

        MultiThreadPerform perform = new MultiThreadPerform(threadCount, latch);
        perform.run(new GenerateSerail(threadCount, latch, serialMap));

        System.out.println("map size=" + serialMap.size());

    }
}

