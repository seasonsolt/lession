package thread;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 16:40 2019-02-25
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
import jvm.Synchronized;
import org.apache.commons.lang3.time.DateUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试volatile不能保证对变量的操作是原子性
 *
 * @author zyt
 * @create 2018-04-15 12:53
 **/
public class VolatileDemo2 extends Thread{
    public volatile int inc = 0;
//    public int fix = 1;


    public void increase() {
        synchronized(this) {
            inc++;
        }
    }

    public static void main(String[] args) {
//        process1();
//        VolatileDemo2 test = new VolatileDemo2();
//       test.process2();
//        process3();

        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b);
        System.out.println(c == 128);
        System.out.println(c.equals(d));
    }

}

