package com.ai.day0607;

import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/6/7
 * @Version: 1.0
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            // 0或1
            carry = sumVal / 10;

            // 小于10，为sumVal 大于10，为个位的值
            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

       ListNode l2 = new ListNode(5);
       l2.next = new ListNode(6);
       l2.next.next = new ListNode(4);

        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }
}
