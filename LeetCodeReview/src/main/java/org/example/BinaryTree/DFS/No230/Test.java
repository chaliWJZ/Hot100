package org.example.BinaryTree.DFS.No230;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution230 solution = new Solution230();
        // root = [3,1,4,null,2], k = 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;
        System.out.println(solution.kthSmallest(root, k));
    }
}
