package com.higgincui.algorithm;

/**
 * 讲的挺好的：https://www.bilibili.com/video/BV1ka4y1H7ZQ?spm_id_from=333.337.search-card.all.click
 *
 * @author cuixinjie
 * @date 2022/4/18 下午11:11
 */
public class 连续子数组的最大和 {



    public int FindGreatestSumOfSubArray(int[] array) {
        //暴力解法
//        int sum=0;
//        int max = array[0];
//        for(int i=0;i<array.length;i++){
//            sum =0;
//            for(int j=i;j<array.length;j++){
//                sum+=array[j];
//                max= Math.max(max,sum);
//            }
//        }
//        return max;

        //动态规划
        //构造一个数组dp[i]，对应array[i]以i为结尾的连续子数组的最大和
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for(int i=1;i<array.length;i++){
            if(dp[i-1]>0){
                dp[i] =dp[i-1]+array[i];
            }else{
                dp[i] = array[i];
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
}
