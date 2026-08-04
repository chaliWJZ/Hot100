package org.example.ListNode.NoDummyHead.No141;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution141 {

    // --- 解法一 ---
/**
   定义 快慢指针, 一般就是 fast快指针 走2步，slow慢指针 只走1步
	如果fast最终遇到空指针，说明链表中没有环；
	如果fast最终和slow相遇，那肯定是fast超过了slow指针，超过好几圈，说明链表中含有环。

**/
    public boolean hasCycle(ListNode head) {

      	  ListNode slow = head;
      	  ListNode fast = head;
        
  //   如何判断 有无环：因为 快指针fast是 每次走2步，所以要考虑链表是 奇数 还是 偶数个节点 。
 //  就是看 快指针 fast.next 有没有走到 null 或者 fast.next 是否为null  
        while(fast!=null&&fast.next!=null){

    // 快慢指针,一般就是 fast快指针 走2步，slow慢指针 只走1步
            slow = slow.next;
            fast = fast.next.next;  

            // 那如果判断 有“环”呢  ？ 快慢指针 == 相等的话，就是 “环”内偶遇，就有环了 
            if(slow == fast){
                return true;
            }

        }
        
        // while循环遍历完了， 也没有 return返回 true，就说明没有 “环”，就是 false 
            return false;
        
    }
}