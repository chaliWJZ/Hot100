package org.example.ListNode.DummyHead.No92;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution92 {

    // --- 解法一 ---
//这道题 最原本的 反转链表I 题目，不一样。那个只需要反转 整个链表 就行了，所以不需要考虑 "头节点"的特殊性质。。。
// 这道题 是   反转某个"区间" ！！需要 知道反转"区间"的 前一个节点是什么，才能 更加方便，所以 为了统一 方便操作，用了 "虚拟头节点"dummyHead  ！！
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
               
        ListNode dummyHead = new ListNode(0);
        dummyHead.next =head;
        
        // 初始化指针p0 指向 dummyHead
        ListNode p0 = dummyHead;
      
        // 将 p0 移动到 指定反转区间的，前一个节点！！！这个很关键！！
        // 因为还要对 区间反转的链表进行 首尾连接。。。所以需要用到p0！！
        for (int i = 0; i < left-1; i++)
            p0 = p0.next;

        //这里的话，就和 之前的 原本的 "反转链表"I 的代码一样了。。。
        // 使用 快慢指针，fast 和 slow
        ListNode slow = null, fast = p0.next;
        
        // 对指定区间的节点进行反转操作，只不过限定反转的节点个数了。。
        for (int i = 0; i < right - left + 1; i++) {
            
              // 必须先用 temp 临时指针先保存 fast快指针 的后继节点 fast.next
            // 然后再将 fast 快指针断链，指向 slow 慢指针
            ListNode temp = fast.next;
            fast.next = slow; 
            
               // 两个指针都要后移一个节点
            // 必须 slow 慢指针先移动，然后 fast 快指针再移动
            slow = fast;
            fast = temp;
            
        }
		      //  因为 这个"区间" 反转完 之后，要对它 重新加入 链表中 。。
       // 那么 p0的next 这个节点 其实 就是 这个"区间"的 首节点。 p0的next的next要指向 快指针 fast ，fast 其实已经指向了 这个区间末尾的 下一个节点了。
        	//最后才是对 p0的next 去指向  这个"区间"的 第一个 尾节点， 完成 反转了。
        p0.next.next = fast;
        p0.next = slow;

        return dummyHead.next;
    }
}