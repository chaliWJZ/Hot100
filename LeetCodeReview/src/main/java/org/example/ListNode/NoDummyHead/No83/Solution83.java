package org.example.ListNode.NoDummyHead.No83;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution83 {

    // --- 解法一 ---
// 初始化 cur指针，指向头部 head

/**  
	当 cur.val 和 cur.next.val 相等时说明需要去重，则将 cur 的下一个指针指向下一个的下一个，这样就能达到去重复的效果
	如果不相等则 cur 移动到下一个位置继续循环

**/

    public ListNode deleteDuplicates(ListNode head) {
        
        // 定义一个指针 cur 指向链表的头节点，用于遍历链表
        ListNode cur = head;

        if(head==null)
            return head;
        
        while(cur.next != null) {
            
            // 比较当前节点 cur 的值和它的下一个节点 cur.next 的值
            if(cur.val == cur.next.val) {
                
                // 如果当前节点的值和下一个节点的值相等，说明存在 ===》 重复元素
                // 此时将 cur的next 指向 cur的下下个节点，相当于跳过了重复的节点
                // 这样就完成了===》重复节点   的删除操作
                cur.next = cur.next.next;
            }

             // 如果当前节点的值和下一个节点的值不相等，说明没有重复元素
                // 将 cur 指针向后移动一位，继续遍历链表
            else {
               
                cur = cur.next;
            }
        }

        return head;
    }
}