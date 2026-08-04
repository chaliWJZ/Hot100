package org.example.ListNode.DummyHead.No2;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution2 {

    // --- 解法一 ---
// 因为涉及到了 两个链表合并为第三个链表，为了方便插入 新的节点，所以 引入了 “虚拟” 头节点。。。

// 这道题，其实就是分别 顺序遍历 两个链表的对应节点，从前向后→
//   每次求和，记得如果 相加和 大于等于10，最终保留的节点值是 个位数，也就是 对10取模% 的结果 ！！
//   进位 如果 和 大于等于10，还要考虑 1进位问题
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        ListNode a = l1;
        ListNode b = l2;

          // 考虑 进位 问题！！！
        // 两个数相加的和 超过10了，就会有 进位,也就是 1
        int addOne = 0;
        
        while (a!= null && b!= null) { 
       
     // 因为还要考虑 前面的节点相加的 进位问题！！！所以还要再加上 addOne可能会传过来 进位1     
            int sum = a.val  + b.val + addOne; 
   // 此时的 两个节点相加 有进位的情况 比如9+9+1=19。 进位是1          
            addOne = sum >= 10? 1 : 0; 
            
 // 如果9+9+1等于19，那么其实最后存入的是9，所以 就是要对 10取模%           
            cur.next = new ListNode(sum%10); 
            cur = cur.next;  

            a = a.next;
            b = b.next;
        }

        // 【特殊情况】
        // 这里还要和 addOne相加，就是怕遇到 9->9->9->9 这种链表。。那么即便 有个链表 走到了 末尾，每次去遍历 另一个剩下的链表节点，和 addOne 会一直相加10，进位 1 ，持续不断。。
        
        // 所以要先处理链表 a 有剩余节点的情况，那么还要继续 相加，一般来说就是 和0 相加。。   
        while (a!= null) {
            
            int sum = a.val + addOne; 
            addOne = sum >= 10? 1 : 0; 
            cur.next = new ListNode(sum % 10);
            cur = cur.next;                                            

            a = a.next;
        }

        // 处理链表 b 有剩余节点的情况
        while (b!= null) {
            
            int sum = b.val + addOne; 
            addOne = sum >= 10? 1 : 0; 
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            b = b.next;
        }

        // 处理最后可能存在的进位 ！！  这个也很关键
        // 其实就是 addOne为1 ， 把 val值为1的节点，插入链表
        if (addOne!= 0) {
            cur.next = new ListNode(addOne);
        }

        return dummyHead.next;
    }
}