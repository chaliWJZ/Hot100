package org.example.BinaryTree.DFS.No104;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution104 {

    // --- 解法一 ---
/**
大致思路： 
  当 root 节点为空时，说明高度为 0，所以返回 0，
  当 root 节点不为空时，则分别求 root的左右子树的 高度的最大值，同时加 1 表示 当前二叉树的最大深度。

**/

    public int maxDepth(TreeNode root) {
        
        // 递归出口：
        // 当这棵树为null空树 的时候，高度是 0 
        // 也就是 当前节点 为空null 
        if(root == null)
            return 0;

       // root节点 不为空null 时,
  	// 因为是 "计算“类型的二叉树 ，所以是 -----> 后序遍历 

   //  root 节点不为空时，分别求 左右子树的高度的最大值，同时加 1 表示当前节点的高度，返回该数值，
        // 一直向上传递，一直向上计算
        int left = maxDepth(root.left);  // 左 
        int right = maxDepth(root.right);  // 右
       	
		return Math.max(left, right) + 1;		//中
        
    }
}