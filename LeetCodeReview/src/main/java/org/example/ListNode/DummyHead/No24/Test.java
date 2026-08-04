package org.example.ListNode.DummyHead.No24;

import java.util.*;
import org.example.CodeTemplate.ListNode;

public class Test {
    public static void main(String[] args) {
        Solution24 solution = new Solution24();
        // head = [1,2,3,4]
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2); cur = cur.next;
        cur.next = new ListNode(3); cur = cur.next;
        cur.next = new ListNode(4); cur = cur.next;

        ListNode res = solution.swapPairs(head);
        ListNode p = res;
        while(p!=null){ System.out.print(p.val+" "); p=p.next; }
        System.out.println();
    }
}
