package org.example.BinaryTree.DFS.No543;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution543 {

    // --- 解法一 ---
/**

大致思路： 
	 要求出二叉树的直径(任意两个节点之间最长路径的 长度)，
     对于二叉树，里面的 每一个结点，都要记录 以此结点为根root 的直径情况：
     也就是每个节点的 左子树高度+右子树高度的和，要和 最终结果值max 不断地比较，然后更新 max，，，
       这样就能求出 二叉树的直径了。。。

**/

    //  定义一个 成员变量，  用于记录最终结果，  定义在最外面,这个写法 其实也很“常见”。。。
    // max 这个变量。。。会在 “次”递归函数find()，里面不断被 更新 ！！！
    int max =0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        // 调用下面的 "次"函数 ，主要就是 求每个节点为root的时候，它的左、右子树的高度。。。
        find(root);
        
        return max;
    }

    //  “次”函数，用于 递归。。。。主要就是 求每个节点为root的时候，它的左、右子树的高度，记得 把它们相加。。。 相加之后的 值，然后不断和 max 进行比较更新，就可以求出 整个二叉树的 直径了 。。。
    int find(TreeNode root){
           
           // 递归出口：
        // 当这棵树为null空树 的时候，高度是 0 
        // 也就是 当前节点 为空null 
        if (root==null) 
            return 0;
               
          // root节点 不为空null 时,
  	// 因为是 "计算“类型的二叉树 ，求高度，所以是 -----> 后序遍历 

        int left = find(root.left);  // 左 ：计算左子树的高度 
        int right = find(root.right);  // 右 ：计算右子树的高度
        
   // 要每次都要进行比较，对每个节点的 左、右子树的高度之和 与 最终结果max 比较，哪个更大，然后更新
        max = Math.max(max,left+right);
        
        return Math.max(left,right)+1;  // 中  ：
    }
}