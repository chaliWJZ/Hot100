package org.example.BinaryTree.BFS.No199;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution199 solution = new Solution199();
        // root = [1,2,3,null,5,null,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

    }
}
