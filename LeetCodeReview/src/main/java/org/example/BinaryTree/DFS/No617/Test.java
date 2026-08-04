package org.example.BinaryTree.DFS.No617;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution617 solution = new Solution617();
        // root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode res = solution.mergeTrees(root1, root2);
        System.out.println(res != null ? res.val : "null");
    }
}
