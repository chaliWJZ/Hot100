package org.example.BinaryTree.DFS.No257;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution257 solution = new Solution257();
        // root = [1,2,3,null,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(solution.binaryTreePaths(root));
    }
}
