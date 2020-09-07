package com.ai.linkedlist.leetcode.merge;

import java.util.List;

/**
 * @Description: 合并两个有序链表 LeetCode21
 * @Author: wangjl
 * @Date: 2020/9/6
 * @Version: 1.0
 **/
public class Solution {
    /**
     *  合并两个有序链表
     *  将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的
     *  所有节点组成的
     *  示例：
     *      输入：1->2->4,  1->3->4
     *      输出: 1->1->2->3->4->4
     *  思路：直觉上感觉很像冒泡排序，h1跟l2上的所有比较
     *  
     *  解法1：递归解法
     */
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    
    // 迭代法，非常有趣，设置个莫须有的head，可以将l1和l2串起来，形成新的链表
    public ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        ListNode dummyHead  =new ListNode(0);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1==null?l2:l1;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        //1->2->4,  1->3->4
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        ListNode l1 = a;
        a.next = b;
        b.next = c;
        ListNode e = new ListNode(1);
        ListNode d = new ListNode(3);
        ListNode f = new ListNode(4);
        ListNode l2 = e;
        e.next = d;
        d.next = f;
//        ListNode listNode = new Solution().mergeTwoLists(l1, l2);
        ListNode listNode = new Solution().mergeTwoLists2(l1, l2);
        System.out.println(listNode.val+" ,"+listNode.next.val+" ,"+listNode.next.next.val);
    }
}
