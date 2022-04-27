package com.higgincui.algorithm;

/**
 * 大家都知道斐波那契数列，现在要求输入一个正整数 n ，请你输出斐波那契数列的第 n 项。
 * 数据范围：1≤n≤40
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n) ，本题也有时间复杂度 O(logn) 的解法
 *
 * 输入描述：
 * 一个正整数n
 * 返回值描述：
 * 输出一个正整数。
 * 示例1
 * 输入：
 * 4
 * 返回值：
 * 3
 * 说明：
 * 根据斐波那契数列的定义可知，fib(1)=1,fib(2)=1,fib(3)=fib(3-1)+fib(3-2)=2,fib(4)=fib(4-1)+fib(4-2)=3，所以答案为3。
 * @author cuixinjie
 * @date 2022/4/15 上午12:17
 */
public class 斐波那契数列 {

    public static void main(String[] args) {
        System.out.println(Fibonacci(4));
        System.out.println(Fibonacci(5));
        System.out.println(Fibonacci(6));
        System.out.println(Fibonacci(7));
    }



    /**
     * 递归
     * 空间复杂度 O(2^n)
     * 时间复杂度 O(n)
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if(n<=1){
            return n;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /**
     * 队列解法
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param n
     * @return
     */
    public static int Fibonacci1(int n) {
        int[] arr = new int[40];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i<n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }

    /**
     * 优化存储
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param n
     * @return
     */
    public static int Fibonacci2(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        int x=1;
        int y=1;
        int z =0;
        for(int i=2;i<n;i++){
            z=x+y;
            x=y;
            y=z;
        }
        return z;
    }
}
