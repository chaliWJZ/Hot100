package org.example.BinaryTree.BFS.No513;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution513 solution = new Solution513();
        // [1,2,3,4,null,5,6,null,null,7]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        System.out.println(solution.findBottomLeftValue(root));
    }
}
