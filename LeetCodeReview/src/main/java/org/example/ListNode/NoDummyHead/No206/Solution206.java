package org.example.ListNode.NoDummyHead.No206;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution206 {

    // --- 解法一 ---
/** 

主要思路：创建两个指针，快慢指针。slow 初始化为 null，fast 初始化为链表的头节点 head。
	slow 指针用于构建反转后的链表，fast 指针用于 循环遍历 原始链表。
    还要声明一个临时指针 temp，用于在 fast指针，执行断链操作前保存 fast 指针的后继节点next。
    
    每次断链之后，记得  slow和 fast都要向前 分别移动到下一个 节点。

**/

    public ListNode reverseList(ListNode head) {
        
        // slow 指针 是慢指针, fast 是快指针
        // 初始化必须 慢指针slow 指向 null，快指针fast指向 head头节点
        ListNode slow = null;
        ListNode fast = head;
        
        // 要声明 临时指针 temp，因为要断链，所以在断链之前要保存当前 fast 指针的后继节点 fast.next 
        
        ListNode temp;

        // 循环结束的条件是当快指针 fast 不为 null 的时候
        while (fast != null) {
            
            // 必须先用 temp 临时指针先保存 fast快指针 的后继节点 fast.next
            // 然后再将 fast 快指针断链，指向 slow 慢指针
            temp = fast.next;
            fast.next = slow;

            // 两个指针都要后移一个节点
            // 必须 slow 慢指针先移动，然后 fast 快指针再移动
            slow = fast;
            fast = temp;
        }
        
        // 必须返回 slow 指针。。因为 此时的fast快指针已经指向了null，因为跳出while循环了
        return slow;
    }
}