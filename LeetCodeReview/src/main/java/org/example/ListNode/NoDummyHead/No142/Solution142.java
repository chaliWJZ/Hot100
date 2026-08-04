package org.example.ListNode.NoDummyHead.No142;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution142 {

    // --- 解法一 ---
/**
		
使用 快慢指针 判断是否为 环形，并且去找到   "环"的入口节点。。。。  fast每次走2步，slow每次走1步
	因为 快指针fast 走得快，所以它们 肯定会 第1次相遇。然后将 快指针fast重新指向头节点。
         第2次和慢指针slow 相交的点，就是环形开始处	

**/

    public ListNode detectCycle(ListNode head) {
        
	// 定义快慢指针，初始化 都直接指向 head头节点 就行 
            ListNode slow = head;
            ListNode fast = head;

        //   // 1.如何判断有无环：因为 快指针fast是 每次走2步，所以要考虑链表是奇数还是 偶数个节点 。就是看 快指针 fast.next 有没有走到 null 或者 fast.next 是否为null  
        while (fast != null && fast.next != null) {
            
               //  快指针走 2步，慢指针 1步 
            slow = slow.next;
            fast = fast.next.next;

          			// 快慢指针 第一次 “相遇”
            if (slow == fast) {
                
                //2.找出 那个 "环"的 入口。  从这里 开始查找了 
        //  让 fast快指针 回到 头节点！！这个很关键！！移动步数 变成1 步，和 慢指针 一样速度
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
          // 因为这里是 第二次 “相遇” 了，这里返回谁都一样 。。。就说明找到了  "环"的入口节点
                return slow;
            }
        }

        //如果上面的那个 while 循环直接跳出来了，那么就说明fast快指针到了 链表的末尾，那么就说明没有 环 。那么就直接 返回 null 
        return null;
    }
}