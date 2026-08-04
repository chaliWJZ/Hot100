package org.example.BinaryTree.BFS.No107;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution107 {

    // --- 解法一 ---
/**

 */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        if (root == null) {
            return res;
        }

        deque.offerLast(root);

        while (!deque.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int size = deque.size();

             for (int i = 0; i < size; i++) {

                TreeNode treeNode = deque.pollFirst();
                list.add(treeNode.val);

                if (treeNode.left != null) {
                    deque.offerLast(treeNode.left);

                }

                if (treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                }
            }

            res.add(list);

        }
		
        // 就是 多了 这个 ”反转“的语句 
        Collections.reverse(res);
        return res;

    }
}