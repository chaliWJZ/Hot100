package org.example.BinaryTree.DFS.No235;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution235 {

    // --- 解法一 ---
/**

大致思路 ：

若 root 是 p,q 的 最近公共祖先 ，则只可能为以下情况之一：

	p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
	p = root ，且 q 在 root 的左或右子树中；
	q = root ，且 p 在 root 的左或右子树中；

**/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
 // 递归出口: 就是考虑遍历到空节点null的时候,当传入的二叉树为 null空树的时候，公共父节点就是 null
        if(root == null)
            return null;

    // 因为是 "查找"类型的二叉树。所以用--->前序遍历 
        
        // 当 root节点非空的时候，，，
     // 当 root节点 等于 q或者 p的时候。那么说明 剩下的q或者p肯定是在 root的左子树和右子树，
        // 所以此时 直接返回 root 就行。root就是 q 和 p的最近公告祖先  
        if(root == p || root == q)            // 中 ：
            return root;	

// 当root 根节点不是  p和q中的任意一个节点。。那么就继续 分别往 左子树、右子树找p和q的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);   //左 
        TreeNode right = lowestCommonAncestor(root.right, p, q);   //右

        //左子树和右子树 都没找到 它们的 公共祖先 ，那就返回 null
        if(left == null && right == null) {
            return null;
        }
        
        //左子树 没找到 它们的 公共祖先，就返回右子树的结果
        if (left == null) {
            return right;
        }
        //右子树 没找到 它们的 公共祖先，就返回左子树的结果
        if (right == null) {
            return left;
        }
        
        //左、右子树都找到p和q了的公共祖先了，那就说明 p和q分别在左、右两个子树上，所以此时的最近公共祖先就是 root根节点
        return root;

    }
}