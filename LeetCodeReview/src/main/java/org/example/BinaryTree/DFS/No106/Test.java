package org.example.BinaryTree.DFS.No106;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution106 solution = new Solution106();
        // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};

        TreeNode res = solution.buildTree(inorder, postorder);
        System.out.println(res != null ? res.val : "null");
    }
}
