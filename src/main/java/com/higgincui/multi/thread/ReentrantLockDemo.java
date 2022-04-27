package com.higgincui.multi.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cuixinjie
 * @date 2022/4/27 下午1:44
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLockDemo01 t = new ReentrantLockDemo01();

        new Thread(t).start();
        new Thread(t).start();

        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }
        System.out.println(ReentrantLockDemo01.num);
    }

}


class ReentrantLockDemo01 implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int num =0;

    public void run() {
        for(int i=0;i<100;i++){
            lock.lock();
            try {
                num++;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}