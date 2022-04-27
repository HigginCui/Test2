package com.higgincui.algorithm;

/**
 * @author cuixinjie
 * @date 2022/4/18 下午8:13
 *
 * 二叉搜索树的最近公共祖先
 * https://blog.nowcoder.net/n/1ba95e56ca924db5aeb176bfbacf86ca?f=comment
 *
 * 若p,q都比当前结点的值小，说明最近公共祖先结点在当前结点的左子树上，继续检查左子树；
 * 若p,q都比当前结点的值大，说明最近公共祖先结点在当前结点的右子树上，继续检查右子树；
 * 若p,q中一个比当前结点的值大，另一个比当前结点的值小，则当前结点为最近公共祖先结点
 *
 */
public class 二叉搜索树的最近公共祖先 {

    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        TreeNode  cur = root;
        while(true){
            if(p<cur.val && q< cur.val){
                cur = cur.left;
            }else if(p>cur.val && q>cur.val){
                cur = cur.right;
            }else{
                return cur.val;
            }
        }
    }
}
