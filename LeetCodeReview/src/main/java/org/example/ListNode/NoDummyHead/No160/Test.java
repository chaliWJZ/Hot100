package org.example.ListNode.NoDummyHead.No160;

import java.util.*;
import org.example.CodeTemplate.ListNode;

public class Test {
    public static void main(String[] args) {
        Solution160 solution = new Solution160();
        // head = [3,2,0,-4], pos = 1
        ListNode head = new ListNode(3);
        ListNode cur = head;
        cur.next = new ListNode(2); cur = cur.next;
        cur.next = new ListNode(0); cur = cur.next;
        cur.next = new ListNode(-4); cur = cur.next;

        int pos = 1;
        ListNode res = solution.getIntersectionNode(head, head);
        ListNode p = res;
        while(p!=null){ System.out.print(p.val+" "); p=p.next; }
        System.out.println();
    }
}
