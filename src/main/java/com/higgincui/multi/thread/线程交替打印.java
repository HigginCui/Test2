package com.higgincui.multi.thread;

/**
 * @author cuixinjie
 * @date 2022/4/18 上午12:58
 */
public class 线程交替打印 {

    public static void main(String[] args) {
        new Thread(new DataThread(0), "Thread1").start();
        new Thread(new DataThread(1), "Thread2").start();
    }
}


class DataThread implements Runnable {

    public static int data = 0;

    public static Object lock = new Object();
    public int n;

    public DataThread(int n) {
        this.n = n;

    }

    public void run() {
        while (data < 100) {
            synchronized (lock) {
                if (data % 2 == n) {
                    System.out.println(Thread.currentThread().getName() + "---获取数据---" + data);
                    data++;
                    lock.notify();
                }else{
                    try {
                        lock.wait();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
}