package org.example.BinaryTree.BFS.No429;

import java.util.*;
public class Solution429 {

    // --- 解法一 ---
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

   public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();

        if (root == null) {
            return res;
        }

        deque.offerLast(root);

        while (!deque.isEmpty()) {

            int size = deque.size();

            List<Integer> list = new ArrayList<>();

           for (int i = 0; i < size; i++) {
                
                Node treeNode = deque.pollFirst();
                list.add(treeNode.val);    
                
                // 不要怕，主要就是如何让自己的  多个孩子节点 挨个入队。。 增强for循环就行  
                if (treeNode.children != null) {
                    for (Node node: treeNode.children) {
                        deque.offerLast(node);
                    }

                }

            }

            res.add(list);

        }

        return res;

    }
}