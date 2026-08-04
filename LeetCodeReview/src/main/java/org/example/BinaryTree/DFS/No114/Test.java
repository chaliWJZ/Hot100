package org.example.BinaryTree.DFS.No114;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution114 solution = new Solution114();
        // root = [1,2,5,3,4,null,6]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        solution.flatten(root);
    }
}
