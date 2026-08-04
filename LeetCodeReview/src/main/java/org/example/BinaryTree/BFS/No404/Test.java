package org.example.BinaryTree.BFS.No404;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution404 solution = new Solution404();
        // root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solution.sumOfLeftLeaves(root));
    }
}
