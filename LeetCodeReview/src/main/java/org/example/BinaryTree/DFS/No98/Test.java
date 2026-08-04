package org.example.BinaryTree.DFS.No98;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution98 solution = new Solution98();
        // root = [2,1,3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(solution.isValidBST(root));
    }
}
