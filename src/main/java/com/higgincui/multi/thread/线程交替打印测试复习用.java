package com.higgincui.multi.thread;

/**
 * @author cuixinjie
 * @date 2022/4/21 下午2:23
 */
public class 线程交替打印测试复习用 {

    public static void main(String[] args) {
        new Thread (new DemoThread(0)).start();
        new Thread (new DemoThread(1)).start();
    }
}

class DemoThread implements Runnable{

    private static int num;

    private int n;

    private static Object lock = new Object();

    public DemoThread(int n){
        this.n = n;
    }

    public void run(){
        while(num<100) {
            synchronized (lock) {
                if (num % 2 == n) {
                    try {
                        lock.wait();
                    } catch (Exception e) {

                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    lock.notifyAll();
                }
            }
        }
    }
}
