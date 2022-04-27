package com.higgincui.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cuixinjie
 * @date 2022/4/18 下午10:13
 */
public class 二叉树的最近公共祖先 {


    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here

        return fun(root,o1,o2).val;
    }

    public TreeNode fun(TreeNode root,int o1,int o2){
        //退出条件
        if(root==null || root.val ==o1 || root.val==o2){
            return root;
        }
        TreeNode left = fun(root.left,o1,o2);
        TreeNode right = fun(root.right,o1,o2);
        //递归角度：如果左节点不为空，那么一定是在右子树上
        if(left == null){
            return right;
        }
        if(right ==null){
            return left;
        }
        //左右字数不为空就返回当前节点
        return root;
    }



    public static boolean isCompleteTree (TreeNode root) {
        // write code here
        if(null==root){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        if(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(i<size-1 && cur==null){
                    return false;
                }
                if(null!=cur){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4}};
        System.out.println(maxValue(arr));

    }

    public static int maxValue (int[][] grid) {
        // write code here

        int[][] maxSum = new int[grid.length][grid[0].length];
        maxSum[0][0] = grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i==0 && j==0){
                    maxSum[i][j] = grid[0][0];
                }else if(i==0 && j!=0){
                    maxSum[i][j] = grid[i][j-1]+grid[i][j];
                }else if(j==0 && i!=0){
                    maxSum[i][j] = grid[i-1][j]+grid[i][j];
                }else{
                    maxSum[i][j] =Math.max(maxSum[i-1][j],maxSum[i][j-1])+grid[i][j];
                }
            }
        }
        return maxSum[grid.length-1][grid[0].length-1];

    }

}
