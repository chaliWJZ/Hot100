package org.example.BinaryTree.BFS.No199;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution199 {

    // --- 解法一 ---
// 这个 妙！！  只需要 记录  每一层的 	最后一个 节点 就行！！
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        
        while (!deque.isEmpty()) {
            
            int size = deque.size();
            
            for (int i = 0; i < size; i++) {
                
                TreeNode node = deque.pollFirst();
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    deque.offerLast(node.right);
                }	
                
                     // 如何表示 当前层的最后一个节点？  i==size-1 就行了
                        //将当前层的  最后一个节点 放入  结果列表res
                if (i==size-1) {  
                    res.add(node.val);
                
                }
                
            }
        }
        return res;
    }
}