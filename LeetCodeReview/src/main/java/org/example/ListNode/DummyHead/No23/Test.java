package org.example.ListNode.DummyHead.No23;

import java.util.*;
import org.example.CodeTemplate.ListNode;

public class Test {
    public static void main(String[] args) {
        Solution23 solution = new Solution23();
        // lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4); head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3); head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{head1, head2, head3};
        ListNode res = solution.mergeKLists(lists);
        ListNode p = res;
        while(p!=null){ System.out.print(p.val+" "); p=p.next; }
        System.out.println();
    }
}
