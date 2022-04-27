package com.higgincui.algorithm;

import java.util.*;
/**
 * @author cuixinjie
 * @date 2022/4/14 上午2:52
 */
public class 从上往下打印二叉树 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(null!=root){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            //查看队列首个元素，不会移除首个元素，如果队列是空的就返回null
            TreeNode node = queue.peek();
            list.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            //将首个元素从队列中弹出，如果队列是空的，就返回null
            queue.poll();
        }
        return list;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
