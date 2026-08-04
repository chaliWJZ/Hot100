package org.example.ListNode.DummyHead.No148;

import java.util.*;
import org.example.CodeTemplate.ListNode;

public class Test {
    public static void main(String[] args) {
        Solution148 solution = new Solution148();
        ListNode head = new ListNode(1); head.next = new ListNode(2);
        System.out.println(solution.sortList(head));
    }
}
