package com.higgincui.algorithm;

/**
 * @author cuixinjie
 * @date 2022/4/16 下午5:21
 */
public class 删除链表中重复的结点 {


    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,3,4,4,5};
        ListNode l = new ListNode(-1);
        ListNode temp = l ;
        for(int i=0;i<arr.length;i++){
            temp.next= new ListNode(arr[i]);
            temp = temp.next;
        }

        l = l.next;
        System.out.println(l);

        System.out.println(deleteDuplication(l));
    }


    public  static ListNode deleteDuplication(ListNode pHead) {

        ListNode temp = new ListNode(-1);
        ListNode tail = temp;
        while(pHead!=null){
            if(pHead.next ==null || pHead.next.val != pHead.val){
                tail.next = pHead;
                tail = pHead;
            }
            if(pHead.next!=null && pHead.val == pHead.next.val){
               pHead = pHead.next;
            }
            pHead = pHead.next;
        }
        tail.next =null;

        return temp.next;
    }
}
