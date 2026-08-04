package org.example.BinaryTree.DFS.No226;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution226 solution = new Solution226();
        // root = [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode res = solution.invertTree(root);
        System.out.println(res != null ? res.val : "null");
    }
}
