package com.higgincui.multi.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cuixinjie
 * @date 2022/4/27 下午4:09
 */
public class ConditionDemo implements Runnable{

    public static ReentrantLock lock =new ReentrantLock();

    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"开始运行...");
            condition.await();
            System.out.println(Thread.currentThread().getName()+"继续运行...");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws Exception{
        ConditionDemo t = new ConditionDemo();

        Thread t1 = new Thread(t,"线程1");
        t1.start();

        //主线程获取锁
        lock.lock();
        try{
            Thread.sleep(1000);
            System.out.println("main线程唤醒condition线程");
            condition.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }
}
