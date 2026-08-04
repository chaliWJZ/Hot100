package org.example.ListNode.DummyHead.No21;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution21 {

    // --- 解法一 ---
// 因为涉及到了 两个链表合并为第三个链表，为了方便 第三个链表(第三个链表)， 不断插入新节点。所以引入“虚拟”头节点dummyHead ！！！

/**

主要思想： 
 
  声明 两个 移动指针a和b，分别遍历 list1链表 和 list2链表。 
  在声明一个 指针 cur，指向 合并后的第三个链表。
  
  在一个循环里面，每次都比较 两个链表 当前节点的值，将 较小值的节点 依次连接到 新链表(第三个链表)：
	   若 list1.val < list2.val，将 list1 节点连接到 cur 节点之后，然后 a 指针向后移动一位。
       若 list1.val >= l2.val，将 list2 节点连接到 cur 节点之后，然后 b 指针向后移动一位。
    每次连接完一个节点后，cur 指针向后移动一位，继续构建新链表。
    
  当其中一个链表遍历完后（即 l1 或 l2 为空），将另一个链表剩余的部分直接连接到 cur 节点之后。
  
**/

     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

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