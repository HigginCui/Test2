package com.higgincui.sort;

/**
 * @author cuixinjie
 * @date 2022/4/20 上午1:13
 */
public class 冒泡排序 {

    public static int[] sort(int a[]) {

        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                if(a[j]<a[i]){
                    int t= a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        return a;
    }

    public static void printArr(int a[]){
        for(int num:a){
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int a[] =new int[]{3,4,2,1,5};
        printArr(sort(a));
    }


}
