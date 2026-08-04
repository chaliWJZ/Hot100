package org.example.BinaryTree.DFS.No572;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution572 {

    // --- 解法一 ---
// 大致思路： 
// 要判断一个 树subRoot 是不是 树root 的子树，

// 满足下面3个情况之一就行：
 //  当 前两棵树相等
//   树subRoot 是 树root的 左子树 
//   树subRoot 是 树root的 右子树   

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        //  多个 递归出口：
        
        // 当root和subRoot 这两棵树都为null 空树的时候，也是相等的，返回true
        if(root == null && subRoot == null) 
            return true;
        
        // 那么剩下的就是 root和subRoot 其中某一棵树 为空的情况：
        // 这里的 subRoot为null的时候，root不为空null ，那么就是 subRoot这个空树 肯定是 root的子树 
        if(subRoot == null) 
            return true;
        
   // 这里的 root 为null空树，subRoot不为空树 的时候，，那么就是 subRoot这个空树肯定不是 s的子树 
        if(root==null)
            return false;   

        // 因为我们把以上情况都排除之后，剩下就是 subRoot 和 root这两棵树 都不为空null 的情况，并且相同的情况：
       //  因为是 “判断”类型的 二叉树  ，  采用的是 ---> 后序遍历 

    //这里的 "递归"调用，只需要判断 subRoot 是不是 root的左子树 或 右子树 的 子树 就行了。。。
        // 还要记得调用 下面的 isSametree()方法，判断是不是 root 和subRoot 这两棵树相等
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot) || isSametree(root,subRoot);
    }

    // 这个 函数，主要是判断 这两颗树 是不是 相同的。。。。
    public boolean isSametree(TreeNode root, TreeNode subRoot) {
        
        // 两棵树 都为空，那么 它们这两棵树肯定相同
        if(root == null && subRoot == null) 
            return true;
        
         // 两棵树 其中一个为null，另外一颗树 不为null，那么 它们这两棵树肯定 不相同
        if(root == null || subRoot == null) 
            return false;
        
          // 两棵树 都不为null，它们的 val不相同，那么 它们这两棵树肯定 也不相同
        if(root.val != subRoot.val)
            return false;

  // 因为我们把以上情况都排除之后，剩下的就是 两棵树的当前节点 都不为空null，且val数值相同的情况。
        //  因为是 “判断”类型的 二叉树  ，  采用的是 ---> 后序遍历  
        
      // 递归地比较两棵树的 左子树和右子树  ，如果都相同 则整棵树 相同，返回true
        return isSametree(root.left,subRoot.left) && isSametree(root.right,subRoot.right);
    }
}