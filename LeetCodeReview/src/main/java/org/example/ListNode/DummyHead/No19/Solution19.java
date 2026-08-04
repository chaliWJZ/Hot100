package org.example.ListNode.DummyHead.No19;

import java.util.*;
import org.example.CodeTemplate.ListNode;
public class Solution19 {

    // --- 解法一 ---
//  本题目 也是因为考虑 "删除" 真实的头节点 比较麻烦。。所以为了方便 统一操作，我们引入”虚拟“头节点  dummyHead ！！！！

/** 
主要思想：
	因为要删除一个 节点，肯定要知道它的前一个节点。。如何确定 倒数第n个节点的 前一个节点呢？
	要定义两个指针，快慢指针。。初始化 它们 都指向 "虚拟头节点" ，然后先让 fast 向前移动 n+1 步，
	然后 慢指针slow和 快指针fast 再一起依次 移动，，，当 fast指向的 节点为 null的时候，slow所指向的节点，就是 倒数第n个节点的 前一个节点。。。。就可以 开始拉链，删除 节点 了。。。
**/

    public ListNode removeNthFromEnd(ListNode head, int n) {
    
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 要定义 快慢指针，它们初始 都是指向  "虚拟" 头结点dummyHead
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
       
  // for 循环，先让 fast快指针 单独移动 n+1 步，这个 结论很关键 ！！！
        for(int i=0;i<=n;i++){
        
            fast = fast.next;
        }

        //  快慢指针，那么两个指针 都同时移动一步 
        // 当 快指针fast 指向，链表的末尾，也就是 空节点null ，此时就要退出循环。
      // 说明：slow所指向的节点，就是 倒数第n个节点的 前一个节点。。。。就可以 开始拉链，删除 节点 了。。。
        while(fast!=null){
          
            fast = fast.next;
            slow = slow.next;

        }

      // 慢指针slow  现在已经指向  待删节点 的  前一个 节点了，这样删起来就很方便了！！！！
        // 这样就将待删除节点删除了
        slow.next = slow.next.next;

        // 题目如果引入了 ”虚拟“头节点， 最后的返回值 一般都是  dummyHead的next
        return dummyHead.next;

    }
}