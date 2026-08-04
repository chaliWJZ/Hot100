package org.example.BinaryTree.DFS.No235;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution235 solution = new Solution235();
        // root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left; // p = 2
        TreeNode q = root.right; // q = 8
        TreeNode res = solution.lowestCommonAncestor(root, p, q);
        System.out.println(res != null ? res.val : "null");
    }
}
