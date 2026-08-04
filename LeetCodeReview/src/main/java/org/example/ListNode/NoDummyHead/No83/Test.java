package org.example.ListNode.NoDummyHead.No83;

import java.util.*;
import org.example.CodeTemplate.ListNode;

public class Test {
    public static void main(String[] args) {
        Solution83 solution = new Solution83();
        // head = [1,1,2]
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(1); cur = cur.next;
        cur.next = new ListNode(2); cur = cur.next;

        ListNode res = solution.deleteDuplicates(head);
        ListNode p = res;
        while(p!=null){ System.out.print(p.val+" "); p=p.next; }
        System.out.println();
    }
}
