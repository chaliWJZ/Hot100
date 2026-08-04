package org.example.ListNode.DummyHead.No24;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution24 {

    // --- 解法一 ---
//因为涉及到 "两两交换"节点，所以引入 “虚拟”头节点 这里是为了 获取某个节点的 前一个节点，方便改指向。
//  这个其实是 K个一组链表的特殊情况。。。。这里是 k=2的时候，反转区间。

   public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        // p0指针 先初始化 指向虚拟头节点。
       // 它用于下面的while循环里面，每次都指向 当前待反转的，两个节点区间，的前一个节点
        ListNode p0 = dummyHead;
        
        // 循环条件：当 p0 后面 至少还有两个节点时，才进行 "两两交换" 操作
        while (p0.next != null && p0.next.next != null) {
            
            // slow 指针指向当前待反转的第一个节点，也就是 p0 的下一个节点
            ListNode slow = p0.next;
            // fast 指针指向当前待反转的第二个节点，也就是 p0 的下下个节点
            ListNode fast = p0.next.next;

            // 让 slow 节点的 next 指针指向 fast 节点的下一个节点
            slow.next = fast.next;
            // 让 fast 节点的 next 指针指向 slow 节点，完成两个节点的反转
            fast.next = slow;  
            // 让 p0 节点的 next 指针指向 fast 节点，将反转后的节点区间，连接回原链表
            p0.next = fast;

            // 记得将 p0 指针移动到 slow 节点的位置！！
    // 因为 slow 节点现在是反转后区间的最后一个节点，其实就是 接下来 待反转区间的 前一个节点 ！！
            p0 = slow;
        }

        return dummyHead.next;
    }
}