package com.higgincui.algorithm;

import java.util.*;

/**
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 *
 * 该二叉树层序遍历的结果是
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * @author cuixinjie
 * @date 2022/4/18 下午5:50
 *
 * 参考：https://www.bilibili.com/video/BV1bJ411H7AZ?spm_id_from=333.337.search-card.all.click
 */
public class 二叉树的层序遍历 {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>>  ll = new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return ll;
        }
        Queue<TreeNode> queue  = new LinkedList<TreeNode>();

        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
//为什么不在循环里面使用queue.size，因为每次循环一次，queue.size()就会-1，导致遍历不全
//            for(int i=0;i<queue.size();i++) {
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if (null != cur.left) {
                    queue.offer(cur.left);
                }
                if (null != cur.right) {
                    queue.offer(cur.right);
                }
                list.add(cur.val);
            }
            ll.add(list);
        }

        return ll;
    }


}
