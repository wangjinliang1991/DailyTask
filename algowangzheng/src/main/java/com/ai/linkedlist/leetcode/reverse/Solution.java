package com.ai.linkedlist.leetcode.reverse;

/**
 * @Description: 反转链表
 * @Author: wangjl
 * @Date: 2020/9/2
 * @Version: 1.0
 **/
public class Solution {
    /**
     * 反转一个单链表  你可以迭代或递归地反转链表。
     * 示例：
     *      输入: 1->2->3->4->5->NULL
     *      输出: 5->4->3->2->1->NULL
     * 方法：
     *     迭代，遍历列表时，将当前节点的next指针改为指向前一个元素
     *     由于节点没有引用其上一个节点，因此必须事先存储前一个元素
     *     在更改引用之前，还要另一个指针来存储下一个节点，最后返回新的头引用
     *     
     *  另外一种思路：prev其实可以看做是newNode，将oldNode也就是curr一步步迁移到newNode
     *    往链表头部添加元素，天然具有倒序的特点
     */
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            //首先保存curr.next节点，之后要改变curr.next的指向了，将其指向prev
            ListNode nextTemp = curr.next;
            curr.next = prev;
            //之后prev和curr都向前进一步
            prev = curr;
            curr = nextTemp;
        }
        //循环结束，prev指针指向了头结点
        return prev;
    }

    /**
     * 递归法
     *     假设列表为：n1->..->n(k-1)->nk->n(k+1)->...->nm->null
     *     如果从节点n(k+1)到nm已经反转，而我们正处于nk  
     *     n1->..->n(k-1)->nk->n(k+1)<-...<-nm
     *     希望n(k+1)的下一个节点指向nk
     *     所以 nk.next.next = nk
     *     注意n1的下一个必须指向null，否则，链表可能产生循环，
     *     如果使用大小为2的链表测试代码，可捕获该错误
     */
    public ListNode reverseList2(ListNode head){
        if (head == null || head.next==null){
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        /*
            代码里的链表和逻辑的链表的区别：
                代码中必须要有head，head指向哪里，表示从哪里开始，如果链表头修改，必须head修改指向
                逻辑中直接就是a->b->c，没有head约束
         */
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
        ListNode node = new Solution().reverseList(head);
        System.out.println(node.val);
    }
}
