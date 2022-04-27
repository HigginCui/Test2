package com.higgincui.algorithm;
import java.util.*;
/**
 * JZ23 链表中环的入口结点
 * @author cuixinjie
 * @date 2022/4/14 上午12:50
 */
public class 链表中环的入口结点 {

    //Set去重判断方式
//    public ListNode EntryNodeOfLoop(ListNode pHead) {
//        Set<ListNode> set = new HashSet<ListNode>();
//        while(pHead!=null){
//            if(set.contains(pHead)){
//                return pHead;
//            }
//            set.add(pHead);
//            pHead = pHead.next;
//        }
//        return null;
//    }

    //快慢指针方式
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                //这里慢指针可能还在环内，不一定环结点
                while(pHead != slow){
                    pHead = pHead.next;
                    slow = slow.next;
                }
                return slow;

            }
        }
        return null;
    }
}



