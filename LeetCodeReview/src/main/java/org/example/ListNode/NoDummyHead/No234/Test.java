package org.example.ListNode.NoDummyHead.No234;

import java.util.*;
import org.example.CodeTemplate.ListNode;

public class Test {
    public static void main(String[] args) {
        Solution234 solution = new Solution234();
        // head = [1,2,2,1]
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2); cur = cur.next;
        cur.next = new ListNode(2); cur = cur.next;
        cur.next = new ListNode(1); cur = cur.next;

        System.out.println(solution.isPalindrome(head));
    }
}
