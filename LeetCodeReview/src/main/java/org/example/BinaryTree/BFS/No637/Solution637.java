package org.example.BinaryTree.BFS.No637;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution637 {

    // --- 解法一 ---

     public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        if (root == null) {
            return res;
        }

        deque.offerLast(root);

        while (!deque.isEmpty()) {

            int size = deque.size();
			
     // sum 和 avg 是记录 当前层的  节点元素之和 以及 平均值，每次都需要 重置一下
            double sum =0;
            double avg = 0;

            for (int i = 0; i < size; i++) {

                TreeNode treeNode = deque.pollFirst();
                sum += treeNode.val;
				
     // 只需要这里 改动一下即可 ，当遍历到最后一个节点的时候，将之前的sum累计和求一下平均值
                if (i == size - 1) {

                    avg = sum / size;
                    res.add(avg);
                }

                if (treeNode.left != null) {
                    deque.offerLast(treeNode.left);

                }

                if (treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                }

            }

        }

        return res;

    }
}