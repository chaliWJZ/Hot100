package org.example.BinaryTree.DFS.No100;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution100 {

    // --- 解法一 ---
/**
大致思路：

1.当两棵树的当前节点都为 null 时返回 true
2.当其中一个为 null 另一个不为 null 时返回 false
3.当两个都不为空但是值不相等时，返回 false

 */
		
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // 递归出口有多个，有以下几种情况：
        
        // 如果两棵树的 当前节点 都为空null，说明这部分结构相同，返回true
        if (p == null && q == null) 
            return true;
        
      // 如果其中一棵树的 当前节点 为空null，另一棵 不为空，说明结构不同，返回false
        if (p == null || q == null) 
            return false;

    // 因为此时只剩下的情况就是，两棵树的当前节点 都不为空，并且值不相等 那么就是 false    
        if (p.val != q.val) 
            return false;

     // 因为我们把以上情况都排除之后，剩下的就是 两棵树的当前节点 都不为空null，且数值相同的情况。
        //  因为是 “判断”类型的 二叉树  ，  采用的是 ---> 后序遍历 

      // 递归地比较两棵树的 左子树和右子树  ，如果都相同 则整棵树 相同，返回true
        boolean compareLeft = isSameTree(p.left, q.left);
        boolean compareRight = isSameTree(p.right, q.right);
            
        return compareLeft && compareRight;
    }
}