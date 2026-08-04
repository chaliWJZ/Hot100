package org.example.BinaryTree.DFS.No230;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution230 {

    // --- 解法一 ---
/**

这道题 也是用到了 二叉搜索树的 中序遍历结果是单调自增的特性。先把结果保存到 list集合里面 。
然后第k个的话，就可以直接根据 list的get()方法，传入k-1 ，就能获取到了。。。

 */
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        
          // 传入的是 k-1
        return list.get(k-1);
        
    }
		
    // “次”函数，用于 中序递归遍历。。二叉树 。。。
    public void inorder(TreeNode root,List<Integer> list) {
        
            if (root == null)   
                return;
        
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
            
    }
}