package org.example.BinaryTree.BFS.No111;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution111 {

    // --- 解法一 ---

//  深度的话，是指 从根节点 到叶子节点的距离，所以 是从上到下的  ↓
	 
   public int minDepth(TreeNode root) {

        Deque<TreeNode> deque = new ArrayDeque<>();
        int minCount = 0;

        if (root == null) {
            return 0;
        }

        deque.offerLast(root);

        while (!deque.isEmpty()) {

            int size = deque.size();
            // 虽然  统计 的是 最小 深度 。但 还是得  不断 对 minCount++ 
            minCount++;

          for (int i = 0; i < size; i++) {

                TreeNode node = deque.pollFirst();
                
 // 因为 题目中 说了， 最小深度 是指，从 根节点 到  "最近" 的 叶子节点 
      // 所以 每次 对  出队的节点 检查，只要 它 是 叶子 节点 ，那么 它就是  最近的 叶子节点。此时 就直接return 返回 minCount 最小深度了。不需要再 遍历 了
                if (node.left==null&node.right==null)
                    return minCount;

                if (node.left != null) {
                    deque.offerLast(node.left);
                }

                if (node.right != null) {
                    deque.offerLast(node.right);
                }

            }

        }

        return minCount;

    }
}