package jvm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;


public class Synchronized {
//    Integer i = 3;
    AtomicInteger i  = new AtomicInteger(3);
    ReentrantLock lock = new ReentrantLock(false);
    public void test(){
        i.addAndGet(3);
        lock.newCondition();
    }

}
