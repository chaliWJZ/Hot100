package org.example.ListNode.NoDummyHead.No138;

import java.util.*;
public class Solution138 {

    static class Node {
        int val;
        Node next;
        Node random;
        Node(int val) { this.val = val; }
    }

    // --- 解法一 ---
/**
	这道题目的意思就是，对 原链表链表(包含next和random指针) 进行深拷贝。
	也就是创建一个新的链表，新链表的节点值 和 原链表 相同，并且新链表 的每个节点的next和random 指针关系，也和原链表 一致。
		
**/

/** 
	如果采用 一轮while循环，比如 原链表 是 A->B->C，A的random指向 C节点。。。
当遍历 原链表的A节点 时候，创建一个 新节点A，指向next。当要给它设置 random指针所指向的 节点C，此时，我们还没有遍历到 原链表的 C节点，还没有被创建出来。也就没办法正确地将 A 的 random 指针指向 C。
	
    所以采用 两次 while循环+ 哈希表map的方式，来完成链表的深拷贝：
   
	第一轮遍历：创建原节点和 新节点的映射关系，将原链表的每个节点和其对应的新节点存入哈希表中。
	第二轮遍历：根据哈希表中的映射关系，构建新链表的 next 和 random 指针。
	返回新链表的头节点。
**/

    public Node copyRandomList(Node head) {

        Node cur = head;
        // 初始化 哈希表 dic
        Map<Node, Node> map = new HashMap<>();
        
        // 1.复制各节点，先建立 “原节点 -> 新节点” 的 Map 映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        
        //再遍历一轮，所以cur又要指回原链表的头节点
        cur = head;

        // 2.构建新链表的 next 和 random 指向
        while (cur != null) {
            
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        
        }
        
        // 3. 返回新链表的头节点
        return map.get(head);
    }
}