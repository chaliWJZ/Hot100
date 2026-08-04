package org.example.ListNode.DummyHead.No203;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution203 {

    // --- 解法一 ---
// 因为涉及到 “移除”节点，所以引入 "虚拟头节点”dummyHead，主要目的就是，方便对 头节点的操作！！！
// 因为 对于 原链表的 真实头节点 来说，它没有 前一个节点。。

// 定义一个 移动指针cur，循环遍历，通过 判断 cur.next 是不是 指定val值的节点，就断链，删除该节点。

    public ListNode removeElements(ListNode head, int val) {
        
        // 声明一个虚拟头节点，这个（0）是随便取的
        // 虚假头节点的 next 要指向 真正的头节点，进行连接 ----- > 这个是通用写法 ，2行代码
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 声明一个 移动指针cur，它 循环遍历链表 不断后移，起始位置 当然是从 虚假头节点开始！
        ListNode cur = dummyHead;

       // 如果引入 虚拟头节点 后，while一般要判断移动指针 cur的next 不为 null，判断 链表不为空才执行 循环
        while (cur.next != null) {
            
  // 为什么是判断移动指针cur的next 而不是 cur ，主要是因为 删除某个节点，都要 先找到它的前面节点
            if (cur.next.val == val) {
                
                // 删除指定节点的写法，简单的 "断链"，这个是通用写法！！！！
                // 就是要让 cur.next 指向 cur.next 的 next
                cur.next = cur.next.next;
                
            } else {
                // 否则，因此 cur 向后移动一个位置
                cur = cur.next;
            }
        }
        
        // 如果链表题目的代码里引入了 "虚假头节点" ！！ 最后的返回值一般是 dummyHead.next ，因为这个才是  真正的头节点  ！！！！
        return dummyHead.next;
    }
}