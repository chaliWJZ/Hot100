package org.example.BinaryTree.BFS.No222;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution222 {

    // --- 解法一 ---

    public int countNodes(TreeNode root) {

        if (root==null)
            return 0;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);

        //  其实就是改一下 这里罢了。。。用一个 计数变量 count
        int count=0;
        
        while (!deque.isEmpty()) {

            int size = deque.size();
            count += size;
            
            while(size-->0){
                
                TreeNode treeNode = deque.pollFirst();
                
                if (treeNode.left!=null)
                    deque.offerLast(treeNode.left);

                if (treeNode.right!=null)
                    deque.offerLast(treeNode.right);

            }

        }
        return count;
    }
}

// 这个做了解即可，另外展示一下 后序递归的方式。。。----->

class Solution {
  public int countNodes(TreeNode root) {
      
    if (root == null){
        return 0;
    }
      		int leftCount = 	countNodes(root.left);
      		int rightCount = countNodes(root.right);
    return leftCount + rightCount + 1;
}
}