package org.example.ListNode.DummyHead.No92;

import java.util.*;
import org.example.CodeTemplate.ListNode;

public class Test {
    public static void main(String[] args) {
        Solution92 solution = new Solution92();
        // head = [1,2,3,4,5], left = 2, right = 4
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2); cur = cur.next;
        cur.next = new ListNode(3); cur = cur.next;
        cur.next = new ListNode(4); cur = cur.next;
        cur.next = new ListNode(5); cur = cur.next;

        int left = 2;
        int right = 4;
        ListNode res = solution.reverseBetween(head, left, right);
        ListNode p = res;
        while(p!=null){ System.out.print(p.val+" "); p=p.next; }
        System.out.println();
    }
}
