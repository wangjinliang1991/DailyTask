package com.ai.linkedlist.leetcode.cycle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 给定一个链表，判断链表中是否有环, leetcode141
 * @Author: wangjl
 * @Date: 2020/9/3
 * @Version: 1.0
 **/
public class Solution {
    /**
     * 给定一个链表，判断链表中是否有环
     * 
     * 为了表示给定链表中的环，我们使用整数 pos 
     * 来表示链表尾连接到链表中的位置（索引从 0 开始）。 
     * 如果 pos 是 -1，则在该链表中没有环。
     * 
     * 思路： 环意思就是尾部的next指向不是null，而是链表内部的节点
     *        因此，先找到尾部，再找到下个节点，遍历得到节点的位置
     * 
     * 哈希表思路：通过检查一个节点此前是否被访问过，来判断链表是否为环形链表
     *            具体：遍历所有节点并在哈希表存储每个节点的引用(或内存地址)，如果当前节点为
     *                  空节点null，则该链表不是环形链表，且已遍历完该链表；如果当前节点的
     *                  引用已存在哈希表中，那么返回true
     */
    public boolean hasCycle(ListNode head){
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null){
            if (nodesSeen.contains(head)){
                return true;
            }else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 解法2：快慢指针
     *      通过使用不同速度的快慢指针遍历链表，空间复杂度可降为O(1)（只用了两个节点）。慢指针每次移动一步，快指针每次移动2步
     *      如果链表不存在环，最终快指针会最先到达尾部，返回false；如果环形链表，把快慢指针想象为两个环形赛道上跑步的
     *      运动员（分别称为慢跑者和快跑者），快跑者最终一定会追上慢跑者，为什么？
     */
    public boolean hasCycle2(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=fast){
            // 快跑者跑到了终点，说明不是环形
            if (fast==null || fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        ListNode head = a;
        head.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        boolean b1 = new Solution().hasCycle2(head);
        System.out.println(b1);
    }
}
