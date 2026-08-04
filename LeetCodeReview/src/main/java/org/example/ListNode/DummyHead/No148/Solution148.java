package org.example.ListNode.DummyHead.No148;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution148 {

    // --- 解法一 ---
// 1.这道题，要使用 "归并”排序 思想（从上到下 ↓ ） ， 这里就是需要 用到 ---> 递归了。。。
 // 2.要先找到 链表的 "中间"节点。。需要通过快慢指针slow和fast 去找。慢指针每次走一步，fast每次都两步，快指针走到末尾， 此时的slow就指向了 "中间"节点 。。。

// 3.当递归到 最底层，就要开始 合并两个已排好序的链表(其实就是 只含有一个节点的 链表)，变成一个新的有序链表。。其实就是 合并两个有序链表 的代码，一模一样

    public ListNode sortList(ListNode head) {
            
     // 因为用到了----> 递归。所以 递归出口：
        // 当一开始传入的是 空链表null，所以 直接返回head
      // 当不断向下递归的时候，当遇到的 链表节点 只有一个的时候，其实就是 head.next是null，其实就是有序的，直接返回head 就行
         if(head==null || head.next==null) 
             return head;

        ListNode slow = head; //慢指针
        ListNode fast = head.next; //快指针

        // 通过快慢指针，找到 链表的 "中间"节点
        while(fast!=null && fast.next!=null){ 
            
            slow = slow.next; //慢指针走一步
            fast = fast.next.next; //快指针走两步
       
        }
        
        ListNode rightHead = slow.next; //链表右半部分的头节点
        slow.next = null; //记得要从 中间节点，截断 链表！！！
        
        ListNode left = sortList(head); //递归，左半段 链表
        ListNode right = sortList(rightHead); //递归，右半段 链表

     // 递归到最底层的时候，也就是  都是 只有一个节点。。
   // 再开始调用“归并排序”merge( )方法，传入 两个链表。。。合并已排序的左半链表 和右半链表    
        return merge(left,right);	    
    }  

    public  ListNode merge(ListNode list1, ListNode list2) {
         
     // 声明一个 虚拟头节点dummyHead，这个是 用于创建 第三个链表，用于不断拉链，插入 新节点 。。
         // cur指针，指向 第三个链表 的 "虚拟头节点"
        ListNode dummyHead = new ListNode(0);
		ListNode cur  = dummyHead;

         // 两个移动指针a和b，分别遍历 list1链表 和 list2链表
     	ListNode a = list1;
        ListNode b = list2;

        while (a != null && b != null) {
			
			// 如果a 移动指针 指向的 list1链表的节点元素，小于 b移动指针指向的 list2链表节点，那么就 cur的next 就指向 a指针的 节点
            // 然后记得 cur指针 和 a 指针，一起都向后移动一位 
            if (a.val < b.val) {
                cur.next = a;
                cur = cur.next;
                a = a.next;

            } 
            	// 否则的话，就是 cur的next指向a 指针的节点
            	// cur和 b一起 向后移动。
            else {
                cur.next = b;
                cur = cur.next;
                b = b.next;
            }

        }
                
         // 当 a移动指针或者 b移动指针走到了 自己遍历的链表末尾的话。
         // 那么  结果指针cur 就直接指向另外一个 移动指针剩下的链表部分就行!!!~~~ 
            if (a == null)
                cur.next = b;
         
            else
                 cur.next = a;      
      
         return dummyHead.next;
     }
}