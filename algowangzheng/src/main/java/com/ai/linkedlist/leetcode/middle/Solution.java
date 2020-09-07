package com.ai.linkedlist.leetcode.middle;

/**
 * @Description: 876.链表的中间节点
 * @Author: wangjl
 * @Date: 2020/9/6
 * @Version: 1.0
 **/
public class Solution {
    /**
     *  876.链表的中间节点
     *  给定一个带有头结点head的非空单链表，返回链表的中间节点
     *  如果有两个中间节点，返回第二个中间节点
     *  
     *  示例1：
     *      输入：[1,2,3,4,5]
     *      输出：此列表中的节点3(序列化形式：[3,4,5])
     *      返回的节点值为3 （测评系统对该节点序列化表述是[3,4,5]）
     *      注意：返回了一个ListNode类型的对象ans. 这样：ans.val=3, ans.next.val=4,
     *          ans.next.next.val=5,以及ans.next.next.next=null
     *          
     *  示例2：
     *      输入：[1,2,3,4,5,6]
     *      输出：此列表中的节点4（序列化形式为：[4,5,6]）
     *      由于该列表有两个中间节点，值分别为3,4，返回第二个节点
     *  
     *  提示： 给定链表的节点数介于1和100之间
     *  
     *  思路：两个游标，快慢，
     *      1,2,3,4,5,6 fast:1 slow:1
     *      1,2,3,4,5,6 fast:3 slow:2
     *      1,2,3,4,5,6 fast:5 slow:3
     *      fast.next!=null fast.next.next=null，slow+1
     *      验证：
     *      1,2,3,4,5 fast:1 slow:1
     *      1,2,3,4,5 fast:3 slow:2
     *      1,2,3,4,5 fast:5 slow:3
     *      fast.next=null fast.next.next=null
     */
    public ListNode middleNode(ListNode head){
        // 先列出特殊情况，空，1个节点，2个节点
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        if (head.next.next==null){
            return head.next;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null){
            if (fast.next.next==null){
                return slow.next;
            }
            //快指针一次走两步，慢指针一次走一步
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
//        ListNode f = new ListNode(6);
        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;
        ListNode head = a;
        ListNode node = new Solution().middleNode(head);
        System.out.println(node.val);
    }
}
