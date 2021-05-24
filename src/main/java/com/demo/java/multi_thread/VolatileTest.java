package com.demo.java.multi_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zjhan
 * @Date: 2021/5/24 17:38
 * @Description: 关键字volatile使用例子
 **/
public class VolatileTest {
    public volatile int inc = 0;
    public Lock lock = new ReentrantLock();

    /**
     * 因为
     */
    public void increase() {
        inc++;
    }

    public void increaseWithLock() {
        lock.lock();
        inc ++;
        lock.unlock();
    }

    /**
     * 执行结束后结果不一定是10000，因为 #increase方法不具有原子性
     * @param test
     */
    public static void multiThread(VolatileTest test) {
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
    }

    /**
     * 执行结果为10000，因为使用了锁，锁内的操作为原子操作
     * @param test
     */
    public static void multiThreadWithLock(VolatileTest test) {
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increaseWithLock();
                };
            }.start();
        }
    }

    /**
     * 执行结果为10000，因为使用了锁，锁内的操作为原子操作
     * @param test
     */
    public static void multiThreadWithSynchronized(VolatileTest test) {
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        synchronized (this) {
                            test.increaseWithLock();
                        }
                };
            }.start();
        }
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
//        multiThread(test);
//        multiThreadWithLock(test);
        multiThreadWithSynchronized(test);
        while(Thread.activeCount()>1)
            Thread.yield();
        System.out.println(test.inc);
    }
}
