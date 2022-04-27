package com.higgincui.multi.thread;

/**
 * @author cuixinjie
 * @date 2022/4/27 上午12:50
 */
public class SynchronizedSourceCode {

    public void test001(){
        synchronized (this){
            System.out.println("hahaha");
        }
    }
}
