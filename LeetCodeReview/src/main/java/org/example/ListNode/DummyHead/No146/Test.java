package org.example.ListNode.DummyHead.No146;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution146 solution = new Solution146();
        Solution146.LRUCache lruCache = solution.new LRUCache(2);
        int key = 1;
        lruCache.put(key, 1);
        System.out.println(lruCache.get(key));
    }
}
