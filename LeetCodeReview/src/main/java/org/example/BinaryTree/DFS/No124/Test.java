package org.example.BinaryTree.DFS.No124;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution124 solution = new Solution124();
        // root = [1,2,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(solution.maxPathSum(root));
    }
}
