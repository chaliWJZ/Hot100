package org.example.ListNode.DummyHead.No19;

import java.util.*;
import org.example.CodeTemplate.ListNode;

public class Test {
    public static void main(String[] args) {
        Solution19 solution = new Solution19();
        // head = [1,2,3,4,5], n = 2
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2); cur = cur.next;
        cur.next = new ListNode(3); cur = cur.next;
        cur.next = new ListNode(4); cur = cur.next;
        cur.next = new ListNode(5); cur = cur.next;

        int n = 2;
        ListNode res = solution.removeNthFromEnd(head, n);
        ListNode p = res;
        while(p!=null){ System.out.print(p.val+" "); p=p.next; }
        System.out.println();
    }
}
