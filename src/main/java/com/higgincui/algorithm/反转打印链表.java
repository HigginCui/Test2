package com.higgincui.algorithm;

import java.util.*;
/**
 * @author cuixinjie
 * @date 2022/4/14 上午12:27
 */
public class 反转打印链表 {

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ln1.next=ln2;
        ln2.next=ln3;
        ln3.next=ln4;
        System.out.println(printListFromTailToHead(ln1));
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> l1 = new ArrayList();
        while(listNode!=null){
            l1.add(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> l2 = new ArrayList();

        for(int i=l1.size()-1;i>=0;i--){
            l2.add(l1.get(i));
        }

        return l2;
    }
}

