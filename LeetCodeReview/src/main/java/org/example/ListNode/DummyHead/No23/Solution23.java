package org.example.ListNode.DummyHead.No23;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution23 {

    // --- 解法一 ---
// 因为  多个链表合并到 一个链表中，所以引入  “虚拟”头节点，方便 合并后的链表(第三个链表)，不断插入 新节点。
// 这里用到了 PriorityQueue 优先级队列 ，内置方便排序 比较。

    public ListNode mergeKLists(ListNode[] lists) {

         // 这个是 合并出来的链表(第三个链表)，用于不断插入 新节点。。。
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

				//  创建一个堆，其实  	PriorityQueue 优先级队列就是一个 堆。	
                        //  其实要传入一个Comparator比较器 接口
                          // 但是这里 用到了 lambda表达式,前面减去 后面的话，就代表升序 。
        PriorityQueue<ListNode>  queue = new PriorityQueue<>((a,b)->a.val-b.val);

             // 实际上只是 先把k个链表的每个 头节点都放入了 堆中而已，里面会进行 升序排序 。 
        for (ListNode node : lists) { 
   // 这里有个前提，就是  PriorityQueue 优先级队列 不能存入 null值。所以要先 if判断
            if (node != null) queue.offer(node);
        }

     //  将k个链表 的头结点，放入「堆」。然后每次都从「堆」中挑出最小值，并将 最小值的头节点的   下一个节点 添加进「堆」。 这样一直循环添加，比较。。。
        while (!queue.isEmpty()) {
            
            ListNode head = queue.poll();
            cur.next = head;
            cur = cur.next;
            
      			   // 记得要用 if ！！！！！ 而不是 while 
                // 因为如果是 while的话，每一次 选择一个最小值的头节点之后，会把该链表的剩余所有节点都放入 「堆」，这样子 会让 「堆」 越来越大。而 每次 poll的时候只是 poll 出去一个。。。。         
            if(head.next != null) 
                queue.offer(head.next);
            
        }
        
        // 本道题 引入了 “虚拟” 头节点 。 所以最后返回的就是 dummyHead的next
        return dummyHead.next;
    }
}