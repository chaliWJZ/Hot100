package org.example.ListNode.DummyHead.No25;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution25 {

    // --- 解法一 ---
//  这道题是 每个"k长度"的区间，一直 反转
// 而且如果最后的剩余节点不足 k个，那么就不反转。。。。

// 所以要先统计出 链表的总长度，然后每次k个反转之后，总长度记得减去 k ，算出剩余节点个数 

// 但是这道题 是   反转"区间" ！！需要 知道反转"区间"的 前一个节点是什么，才能方便连接，所以 为了统一方便操作，用了 "虚拟头节点" ！！
    public ListNode reverseKGroup(ListNode head, int k) {

        int n = 0;
        ListNode cur = head;
        
        	//  先用一个while循环，遍历一遍 链表，每次++，得出链表长度 
        while (cur!= null) {
            n++;  
            cur = cur.next;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
         // 初始化指针 p0 指向 dummyHead
        ListNode p0 = dummyHead;
        
        ListNode slow = null;
        ListNode fast = head;
        		
        // 就是在这里多了个外层的的while循环，每次要判断一下 剩余的节点个数 大于等于k吗，是的话才会反转这段区间的链表。。。
        while (n >= k) {
            
                n -= k;  // 所以每次反转的时候，链表总长度n 要减去这段链表的 k个节点数 ！！
            				
                // 内层for循环就是最最平常的  "反转链表" 的代码。
            // 两个指针，快慢指针。以及一个 temp临时指针
            for (int i = 0; i < k; i++) {  
                ListNode temp = fast.next;
                fast.next = slow;  
                slow = fast;
                fast = temp;
            }

          	// 因为每次 反转完，p0又要指向 下一个"区间" 的前一个节点，其实就是p0.next，所以要先用临时指针保存一下，因为 p0.next之后要拉链了。
            ListNode temp2 = p0.next;

             //  因为 这个"区间" 反转完毕之后，要对它 重新加入 链表中 。。
       // 那么 p0的next 这个节点 其实 就是 这个"区间"的 首节点， p0的next的next要指向 快指针 fast ，fast 其实已经指向了 这个区间末尾的 下一个节点了。
      //最后才是对 p0的next 去指向  这个"区间"的  尾节点,其实现在是 慢指针 slow 指向着。完成 反转了。
            p0.next.next = fast;
            p0.next = slow;
            
            p0 = temp2;  //  记得移动p0！！ 因为 还要 给 下一个 k长度的区间 继续反转。。。
            
        }

        return dummyHead.next;
    }
}