package redis.redisPool;

import org.junit.Ignore;
import org.junit.Test;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.*;

public class JedisPoolTest {

    @Ignore
    @Test
    public void testQueue() throws InterruptedException {
        final LinkedBlockingDeque<String> link = new LinkedBlockingDeque<String>();
        int count = 100;
        final CountDownLatch latch = new CountDownLatch(count);
        final CyclicBarrier cb = new CyclicBarrier(count);

        ExecutorService service = Executors.newFixedThreadPool(10);

        for(int i=0;i<30;i++) {
            new Thread() {
                public void run() {
                    try {
                        cb.await();
                        Thread.sleep(((int)Math.random()*100));
                        link.push("123");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    latch.countDown();
                }

            }.start();
        }
        for(int i=0;i<70;i++) {
            new Thread() {
                public void run() {
                    try {
                        cb.await();
                        long start = System.currentTimeMillis();
                        String str =link.poll();
                        if(str == null) {
                            str =  link.poll(50, TimeUnit.MILLISECONDS);
                        }
                        long end = System.currentTimeMillis();
                        System.out.println("Thread:"+ Thread.currentThread().getName());
                        System.out.println("["+str+"] during:"+ (end - start));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                }

            }.start();
        }

        latch.await();
        System.out.println("count down latch");

    }

    @Test
    public void testQueue1() throws InterruptedException {
        LinkedBlockingDeque<String> link = new LinkedBlockingDeque<String>();
        link.push("element");
        long start = System.currentTimeMillis();
        String str = link.poll(15, TimeUnit.MILLISECONDS);
        long end = System.currentTimeMillis();
        System.out.println("["+str+"] during:"+ (end - start));

        JedisPool pool = new JedisPool();
        pool.close();
    }

}
