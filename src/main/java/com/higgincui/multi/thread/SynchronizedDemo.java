package com.higgincui.multi.thread;

/**
 * @author cuixinjie
 * @date 2022/4/18 上午12:25
 */
public class SynchronizedDemo {

    public static void  main(String[] args){
        SaleThread st = new SaleThread();
        Thread t1 = new Thread(st,"线程1");
        Thread t2 = new Thread(st,"线程2");
        Thread t3 = new Thread(st,"线程3");
        Thread t4 = new Thread(st,"线程4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("main线程------------");
    }
}

class SaleThread implements Runnable{

    private int tickets = 100;

    public synchronized void run() {
        while(tickets>0){
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "--卖出的票号码为:" + tickets--);
        }
    }
}