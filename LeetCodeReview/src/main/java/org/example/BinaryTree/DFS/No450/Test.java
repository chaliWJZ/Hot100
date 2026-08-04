package org.example.BinaryTree.DFS.No450;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution450 solution = new Solution450();
        // root = [5,3,6,2,4,null,7], key = 3
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int key = 3;
        TreeNode res = solution.deleteNode(root, key);
        System.out.println(res != null ? res.val : "null");
    }
}
