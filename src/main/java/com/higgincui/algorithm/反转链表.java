package com.higgincui.algorithm;

import java.util.*;
/**
 * @author cuixinjie
 * @date 2022/4/15 上午1:21
 */
public class 反转链表 {


    /**
     * 利用栈的先进后出原则
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        //第一步，先把所有链表的数据压入栈
        while(null!=head){
            stack.push(head);
            head = head.next;
        }
        if(stack.isEmpty()){
            return null;
        }
        //弹出第一个栈的链表节点
        ListNode node = stack.pop();
        //原来链表节点的尾节点为新的链表头节点，在这里做一次保存
        ListNode newHead = node;
        while (!stack.isEmpty()){
            //链表后移
            node.next = stack.pop();
            node = node.next;
        }
        //最后链表的尾结点指向空
        node.next=null;
        return newHead;
    }

    /**
     * 基于3个指针移动，不断修改链表节点的指针
     * @param head
     * @return
     */
    public static ListNode ReverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (null!=cur){
            ListNode curNext = cur.next;
            cur.next=pre;
            pre = cur;
            cur =curNext;
        }
        return pre;
    }
}
