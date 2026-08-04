package org.example.ListNode.DummyHead.No2;

import java.util.*;
import org.example.CodeTemplate.ListNode;

public class Test {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // l1 = [2,4,3], l2 = [5,6,4]
        ListNode head = new ListNode(2);
        ListNode cur = head;
        cur.next = new ListNode(4); cur = cur.next;
        cur.next = new ListNode(3); cur = cur.next;

        ListNode res = solution.addTwoNumbers(head, head);
        ListNode p = res;
        while(p!=null){ System.out.print(p.val+" "); p=p.next; }
        System.out.println();
    }
}
