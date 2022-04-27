package com.higgincui.multi.thread;

import java.util.*;
import java.util.concurrent.atomic.*;

/**
 * @author cuixinjie
 * @date 2022/4/20 上午1:37
 */
public class 利用Queue编写一个阻塞队列 {

    public static void main(String[] args) {
        final MyBlockingQueue queue = new MyBlockingQueue(5);

        new Thread(new Runnable(){
            public void run(){
                for(int i=0;i<10;i++){
                    queue.put(i);
                    System.out.println("队列插入数据:"+i);
                }
            }
        }).start();

        new Thread(new Runnable(){
            public void run(){

                for(int i=0;i<10;i++){
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                    System.out.println("获取数据:"+queue.take());
                }
            }
        }).start();
    }
}
class MyBlockingQueue {
    private LinkedList<Object> queue = new LinkedList<Object>();

    private AtomicInteger count = new AtomicInteger(0);

    private int maxSize;
    private int minSize = 0;

    private final Object lock = new Object();

    public MyBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public Object take(){
        Object obj =null;
        synchronized(lock) {
            while (count.get() == minSize) {
                try {
                    lock.wait();
                }catch (Exception e){

                }
            }
            obj = queue.removeFirst();
            count.decrementAndGet();
            lock.notify();
        }
        return obj;
    }

    public void put(Object obj){
        synchronized(lock){
            while(count.get()==maxSize){
                try {
                    lock.wait();
                }catch (Exception e){

                }
            }
            queue.add(obj);
            count.incrementAndGet();
            lock.notify();
        }
    }
}

