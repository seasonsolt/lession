package jvm;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest implements Runnable {
    public static int i, j;

    Integer a;
    AtomicInteger aa;

    public volatile long b = 1;

    public void run() {
        System.out.println("b=" + b);
        this.b = 2;
    }

    public static void main(String[] args) {
        VolatileTest t = new VolatileTest();
        new A(t).start();
        new B(t).start();
    }


    static class A extends Thread {
        VolatileTest t;

        public A(VolatileTest t) {
            this.t = t;
        }

        public void run() {
            try {
                Thread.sleep(10);
//   if (VolatileTest.a == 1) {
//    System.out.println("i see 1");
//   } else {
//    System.out.println("i see 2");
//   }

                while (t.b < 100) {
                    System.out.println("I see " + t.b);
                }
                System.out.println("I see " + t.b);
            } catch (InterruptedException e) {

            }
        }
    }


    static class B extends Thread {
        VolatileTest t;

        public B(VolatileTest t) {
            this.t = t;
        }

        public void run() {
//  VolatileTest.a = 2;
            try {
                while(t.b < 1000) {
                    Thread.sleep(500);
                    t.b++;
                }
            } catch (InterruptedException e) {
            }
        }
    }

}
