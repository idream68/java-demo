package com.demo.java.multi_thread;

/**
 * @Author: zjhan
 * @Date: 2021/6/8 17:43
 * @Description:
 **/
public class ThreadStop extends Thread {
    @Override
    public void run() {
        int i = 1;
        while (i < Integer.MAX_VALUE) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
                i++;
            } catch (Exception e) {
                break;
            }
        }
        System.out.println("print all");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStop s = new ThreadStop();
        s.start();
        Thread.sleep(10*1000);
//        使用interrupt()方法，最后的print all会打印出来
        s.interrupt();

//        使用stop()方法，最后的print all不会打印出来
//        s.stop();
//
//        System.out.println(s.isInterrupted());
//        System.out.println(s.isInterrupted());
//        true,false


//        System.out.println(Thread.interrupted());
//        System.out.println(Thread.interrupted());
//        false,false


//        Thread.currentThread().interrupt();
//        System.out.println(Thread.interrupted());
//        System.out.println(Thread.interrupted());
//        true,false
    }
}
