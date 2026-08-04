package org.example.ListNode.NoDummyHead.No234;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution234 {

    // --- 解法一 ---
// 1. 先找到  链表的  中间节点
// 2. 反转 后半部分的链表
// 3. 在对这前半部分的链表，以及 反转之后的后半部分链表，比较 节点是否相等

   public boolean isPalindrome(ListNode head) {
        
        // 定义 快慢指针，用于查找 链表的 中间节点
        ListNode slow = head;  
        ListNode fast = head;  
      
       // 慢指针，每次移动1步
        // 快指针，每次移动2步
       // 1.当快指针fast 或者 fast.next 为 null 时， 跳出循环 ， slow 就指向了 中间节点!!
       //     因为 节点个数 可能是 奇数or偶数，所以要这么判断
        while (fast!= null && fast.next!= null) {
            slow = slow.next;  
            fast = fast.next.next;  
        }

        // 2.反转 后半部分的链表。其实就是  反转链表 那几行代码！！
       
        ListNode pre = null;  
  		ListNode cur = slow;  // 后半部分的链表的  首节点,其实就是slow 所指向的中间节点

        while (cur!= null) {
            
            ListNode temp = cur.next;  // 暂存当前节点cur 的下一个节点next
            cur.next = pre;  // 当前指针cur 指向前一个节点，完成反转
            pre = cur;  // 前向指针pre 下移
            cur = temp;  // 当前指针cur 下移
            
        }

        // 3.比较前半部分，和 反转后的后半部分链表 ， 是否 一一相等
       
        ListNode first = head;  // 前半部分的起始节点
        ListNode second = pre;  // 反转后半部分的起始节点

       // 有个细节！！ 如果 链表长度是奇数，那么前半部分的长度 比 后半部分长度多1个
		// 所以只需要判断，后半部分的遍历节点 是否为null就行了，主要是为了防止遍历 空节点。。。
        while (second!= null) {
            // 如果对应节点的值不相等，不是回文链表，返回 false
            if (first.val!= second.val) {
                return false;
            }
            first = first.next;  // 前半部分指针移动
            second = second.next;  // 后半部分指针移动
        }

        // while循环，遍历完 都相等，是回文链表，返回 true
        return true;
    }
}