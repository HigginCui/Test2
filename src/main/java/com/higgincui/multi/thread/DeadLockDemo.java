package com.higgincui.multi.thread;

/**
 * @author cuixinjie
 * @date 2022/4/18 上午12:44
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        new Thread(new DeadLockThread(true)).start();
        new Thread(new DeadLockThread(false)).start();
    }

}

class DeadLockThread implements Runnable{

    public static Object lockA = new Object();
    public static Object lockB = new Object();


    public boolean flag =false;

    public DeadLockThread(boolean flag){
        this.flag = flag;
    }

    public void run(){
        System.out.println(Thread.currentThread()+"开始流程");
        if(flag){
            synchronized (lockA) {
                try {
                    Thread.sleep(100);
                }catch (Exception e){

                }
                synchronized (lockB){

                }
            }
        }else{
            synchronized (lockB) {
                try {
                    Thread.sleep(100);
                }catch (Exception e){

                }
                synchronized (lockA){

                }
            }
        }
        System.out.println(Thread.currentThread()+"结束流程");
    }
}