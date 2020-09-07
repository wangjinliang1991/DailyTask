package com.ai.linkedlist;

/**
 * @Description: 单链表的插入、删除、查找操作；链表中存储的是int类型的数据
 * @Author: wangjl
 * @Date: 2020/9/1
 * @Version: 1.0
 **/
public class SingleLinkedList {
    private Node head = null;
    
    public Node findByValue(int value){
        Node p = head;
        while (p!=null && p.data != value){
            p = p.next;
        }
        return p;
    }
    
    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while (p!=null && pos!=index){
            p = p.next;
            pos++;
        }
        return p;
    }
    
    //无头结点，表头部插入，这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value){
        Node newNode = new Node(value,null);
        insertToHead(newNode);
    }
    
    public void insertToHead(Node newNode){
        if (head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
    
    //顺序插入，链表尾部插入
    public void insertTail(int value){
        Node newNode = new Node(value,null);
        //空链表，可以插入新节点作为head，也可以不操作
        if (head == null){
            head = newNode;
        }else {
            Node q = head;
            while (q.next != null){
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }
    
    public void insertAfter(Node p,int value){
        Node newNode = new Node(value,null);
        insertAfter(p,newNode);
    }
    
    public void insertAfter(Node p,Node newNode){
        if (p==null) return;
        
        newNode.next = p.next;
        p.next = newNode;
    }
    
    public void insertBefore(Node p, int value){
        Node newNode = new Node(value,null);
        insertBefore(p,newNode);
    }
    
    public void insertBefore(Node p,Node newNode){
        if (p==null) return;
        
        if (head == p){
            insertToHead(newNode);
            return;
        }
        
        Node q = head;
        while (q!=null && q.next!=p){
            q = q.next;
        }
        
        if (q==null){
            return;
        }
        
        newNode.next = p;
        q.next = newNode;
    }
    
    public void deleteByNode(Node p){
        if (p==null || head==null) return;
        
        if (p==head){
            head = head.next;
            return;
        }
        
        Node q = head;
        while (q!=null && q.next!=p){
            q = q.next;
        }
        if (q==null) return;
        
        q.next = q.next.next;
    }
    
    public void deleteByValue(int value){
        if (head == null) return;
        
        Node p = head;
        Node q = null;
        while (p!=null && p.data!=value){
            q = p;
            p = p.next;
        }
        
        if (p==null) return;
        if (q==null){
            head = head.next;
        }else{
            q.next = q.next.next;
        }
    }
    
    public void printAll(){
        Node p = head;
        while (p!=null){
            System.out.print(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }
    
    //判断是否回文 
    //思路：使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次两步。慢指针前进
    //的过程中，同时修改其next指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等
    public boolean palindrome(){
        if (head==null){
            return false;
        }else {
            System.out.println("开始执行找到中间节点");
            Node p = head;
            Node q = head;
            if (p.next == null){
                System.out.println("只有一个元素");
                return true;
            }
            while (q.next != null && q.next.next!=null){
                p = p.next;
                q = q.next.next;//快指针
            }
            System.out.println("中间节点"+p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            if (q.next == null){
                //q已经是最末尾的节点，p一定是整个链表的中点，且节点数目为奇数
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
                System.out.println("左边第一个节点"+leftLink.data);
                System.out.println("右边第一个节点"+rightLink.data);
            }else{
                //p q 均为中点
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return getResult(leftLink,rightLink);
        }
    }
    
    private boolean getResult(Node left,Node right){
        Node l = left;
        Node r = right;
        
        boolean flag = true;
        System.out.println("left_:"+l.data);
        System.out.println("right_:"+r.data);
        while (l != null && r!=null){
            if (l.data==r.data){
                l = l.next;
                r = r.next;
                continue;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    //无头结点的链表翻转
    public Node inverseLinkList(Node p){
        Node pre = null;
        Node r = head;
        System.out.println("z---"+r.data);
        Node next = null;
        while (r!=p){
            next = r.next;
            
            r.next = pre;
            pre = r;
            r = next;
        }
        
        r.next = pre;
        //返回左半部分的中点之前的那个节点
        // 从此处开始同步向两边比较
        return r;
    }
    
    public static class Node{
        private int data;
        private Node next;
        
        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
        
        public int getData(){
            return data;
        }
        
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        int data[] = {1,2,5,3,1};
        for (int i=0;i<data.length;i++){
            list.insertTail(data[i]);
        }
        System.out.println("打印原始:");
        list.printAll();
        if (list.palindrome()){
            System.out.println("回文");
        }
    }
}
