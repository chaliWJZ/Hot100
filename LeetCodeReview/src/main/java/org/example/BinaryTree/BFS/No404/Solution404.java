package org.example.BinaryTree.BFS.No404;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution404 {

    // --- 解法一 ---

   // 题解中是用 前序的迭代方法。。我这里用的是 "层序" 的迭代遍历，，，其实是 一样的逻辑!!
    public int sumOfLeftLeaves(TreeNode root) {

        Deque<TreeNode> deque = new ArrayDeque<>();
        int sum = 0;

        if (root == null)
            return 0;

        deque.offerLast(root);

        while (!deque.isEmpty()) {

            int size = deque.size();

            while(size-->0){

                TreeNode treeNode = deque.pollFirst();
                
     //  主要还是对 左叶子节点  如何判断，如何书写代码。
// 其实就是 某个节点的左节点非空。然后这个左节点的 左、右节点 也都为空。那么它就是 --> 左叶子节点
  if (treeNode.left != null && treeNode.left.left == null && treeNode.left.right == null) 				
                    sum += treeNode.left.val;
                
                if (treeNode.left!=null)
                    deque.offerLast(treeNode.left);

                if (treeNode.right != null) 
                    deque.offerLast(treeNode.right);
                
            }

        }
        return sum;
    }
}