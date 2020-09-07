package com.ai.linkedlist.leetcode.remove;

import java.util.List;

/**
 * @Description: 19.删除链表的倒数第N个节点
 * @Author: wangjl
 * @Date: 2020/9/6
 * @Version: 1.0
 **/
public class Solution {
    /**
     *  19.删除链表的倒数第N个节点
     *  给定一个链表，删除链表的倒数第N个节点，并且返回链表的头结点
     *  
     *  示例：
     *      给定一个链表：1->2->3->4->5 和n=2
     *      当删除了倒数第2个节点后，链表变成 1->2->3->5
     *  说明：给定的n保证是有效的
     *  进阶：
     *      能否尝试使用一趟扫描实现？
     *      
     *  解法1：两次遍历算法
     *      思路：该问题可简化为：删除从列表开头数起的第(L-n+1)个节点，其中L是
     *          链表的长度，只要找到列表的长度L，该问题就很容易解决
     *      具体：先添加一个哑节点作为辅助，该节点位于列表头部。哑节点用来简化某些极端情况，如
     *          列表只包含一个节点，或需要删除列表的头部。第一次遍历，找到列表的长度L。之后，设置一个
     *          指向哑节点的指针，并移动它遍历列表，直到到达(L-n)个节点哪里。把第(L-n)个节点的next
     *          指针重新链接到第(L-n+2)个节点，完成该算法
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        // 哑节点作为链表的新的头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        // 指针first，遍历得到链表的length
        ListNode first = head;
        while (first !=null){
            length++;
            first = first.next;
        }
        // 寻找l-n个节点的位置，first指针改从dummy开始
        length -=n;
        first = dummy;
        while (length>0){
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    /**
     *  解法2：一次遍历
     *      算法：优化上述算法，使用两个指针而不是一个指针。第一个指针从列表头向前移动n+1步，
     *          第二个指针从列表头开始，现在，这两个指针被n割节点分开，通过同时移动两个指针向前
     *          保持这个恒定的间隔，直到第一个指针到达最后一个节点，此时，第二个指针将指向从
     *          最后一个节点数起的第n个节点，重新链接第二个指针所引用的节点的next指针指向该节点的
     *          下下个节点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        //advances first pointer so that the gap between first and second is n nodes apart
        // 从dummy开始算，终点是n+1
        for (int i=1;i<=n+1;i++){
            first = first.next;
        }
        // move first to the end, maintaining the gap
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        //1->2->3->4->5 和n=2
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode head = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
//        ListNode listNode = new Solution().removeNthFromEnd(head, 2);
        ListNode listNode = new Solution().removeNthFromEnd2(head, 2);
        System.out.println(listNode.val+", "+listNode.next.val+", "+
                listNode.next.next.val+", "+listNode.next.next.next.val);
    }
}
