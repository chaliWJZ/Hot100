package org.example.ListNode.NoDummyHead.No160;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution160 {

    // --- 解法一 ---
//  因为这里是两个链表。定义  两个 指针A 和B，初始化 分别指向 两个链表HeadA 和 HeadB

/**	
 因为要找 两个链表的交点：那么可以让 指针A遍历完 链表A再遍历headB 。 B遍历完 链表B 再遍历 链表A。它们一定会在走过 相同步数后 相遇：
	 相遇的位置要么是 相交节点，要么就都是 空节点 null，所以这样 循环两次 就能找到 相交节点。

**/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     
        ListNode A = headA;
        ListNode B = headB;

      //循环结束条件： 当 两个指针 所指向的节点 相等的话，就是找到了 相交节点，跳出 while 循环   
    
   /** 你可能会有疑惑，如果A，B 链表 没有交点，会不会无限死循环？答案是 并不会。
         因为 条件是 A ！= B，如果没有交点，A,B走过第二遍时 肯定会同时为null，也就是A，B交点为 None 的情况。（即将两链表末端的 None 看作交点），所以仍会退出循环。
    **/
         while(A != B) {

         //  A指针 一直在 链表A 移动，每次 移动一步，如果到了 链表末尾，那么就指向 链表B。。。
             // 换个链表 继续 从头遍历
                if(A != null) 
                    A =  A.next;
                 else 
                    A = headB;
                
    // B指针一直在链表B移动，每次移动一步，如果到了 链表末尾，那么就指向 链表A。。换个链表 从头遍历
                if(B != null) 
                    B = B.next;
                 else 
                    B = headA;
            
        }
        
        return A;

    }
}