package com.higgincui.algorithm;

import java.util.*;
/**
 * @author cuixinjie
 * @date 2022/4/18 下午10:32
 */
public class 字符串最后一个单词的长度 {

    public static int lastStrLength(String str){

        if(null==str || str.length()==0){
            return 0;
        }
        String[] arr = str.split(" ");

        return arr[arr.length-1].length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(lastStrLength(str));
    }
}
