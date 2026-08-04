package org.example.BinaryTree.DFS.No110;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution110 {

    // --- 解法一 ---
/**

 */

    public boolean isBalanced(TreeNode root) {

     // 递归出口 是 多个：   
        
    // 当 root 是一棵 空树null，就是 true， 肯定是 平衡二叉树  
    if (root == null) {
        return true;
    }

   // 当 root 不为空树null，并且它的 左右两个子树的高度差的绝对值 超过1，就是 false， 不是 平衡二叉树  
    // 这里 就要 调用下面定义的 “次”方法 getTreeDepth()， 去求 左、右子树的高度
    int leftDepth = getTreeDepth(root.left);
    int rightDepth = getTreeDepth(root.right);
    if (Math.abs(leftDepth - rightDepth) > 1) {
        return false;
    }

   // 那么剩下的情况就是 root不为空树null， 然后它的 左、右子树 的高度差，小于等于1的情况：
        //  因为是 "判断”类型的 二叉树 ，所以选择 ---> 后序 

       boolean leftFlag = isBalanced(root.left);   // 左
       boolean  rightFlag = isBalanced(root.right);  // 右 
        
       //左右两个子树都是一棵平衡二叉树的话，那么 这整个二叉树 才是平衡的 
    return leftFlag && rightFlag;  // 中
 
}

   // “次”方法，求二叉树的 深度。。。这个 递归方法实现的 比较基础
 public int getTreeDepth(TreeNode root) {

      // 递归出口：
        // 当这棵树为null空树 的时候，高度是 0 
        // 也就是 当前节点 为空null 
        if(root == null)
            return 0;

       // root节点 不为空null 时,
  	// 因为是 "计算“类型的二叉树 ，所以是 -----> 后序遍历 

   //  root 节点不为空时，分别求 左右子树的高度的最大值，同时加 1 表示当前节点的高度，返回该数值，
        // 一直向上传递，一直向上计算
        int left = getTreeDepth(root.left);  // 左 
        int right = getTreeDepth(root.right);  //右
       	
		return Math.max(left, right) + 1;		//中
}
}