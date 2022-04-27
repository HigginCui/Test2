package com.higgincui.base;

/**
 * @author cuixinjie
 * @date 2022/4/27 下午4:43
 */
public class 值传递 {

    public static void main(String[] args) {

        int a= 99;
        fun1(a);
        System.out.println("基本数据类型int，当前实参的值为："+a);

        Integer b= 99;
        fun2(b);
        System.out.println("包装数据类型Integer，当前实参的值为："+b);

        String c = "99";
        fun3(c);
        System.out.println("字符串类型String，当前实参的值为："+c);
    }

    public static void fun1(int a){
        a =100;
        System.out.println("基本数据类型int，当前形参的值为："+a);
    }

    public static void fun2(Integer b){
        b =100;
        System.out.println("包装数据类型Integer，当前形参的值为："+b);
    }

    public static void fun3(String c){
        c ="100";
        System.out.println("字符串类型String，当前形参的值为："+c);
    }
}
