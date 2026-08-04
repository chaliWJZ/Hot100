package org.example.BinaryTree.DFS.No108;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution108 solution = new Solution108();
        // nums = [-10,-3,0,5,9]
        int[] nums = new int[]{-10,-3,0,5,9};

        TreeNode res = solution.sortedArrayToBST(nums);
        System.out.println(res != null ? res.val : "null");
    }
}
