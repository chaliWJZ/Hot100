package org.example.BinaryTree.DFS.No105;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution105 solution = new Solution105();
        // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        TreeNode res = solution.buildTree(preorder, inorder);
        System.out.println(res != null ? res.val : "null");
    }
}
