package concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*volatile 变量 自 增 运算 测试 * *@author zzm */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        } //等待 所有 累加 线程 都 结束
        while (Thread.activeCount() > 1) Thread.yield();
        System.out.println(race);
        Map<String, String > map = new ConcurrentHashMap<String, String>();
        map.size();
        map.put("abc", "abc");
    }

}

