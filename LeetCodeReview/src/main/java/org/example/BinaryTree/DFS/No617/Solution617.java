package org.example.BinaryTree.DFS.No617;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution617 {


    // --- 解法一 ---
public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        //  递归出口  有多个：
     // 递归 出口，只要 遇到 root1 或者 root 2 中 某个节点为空的话，那么就返回另外一个树的 节点					
                if (root1 == null) return root2;
                if (root2 == null) return root1;
        
// 当递归出口的情况排除后，只剩下 root1和root2 遍历节点 都非空的情况，就可以正常书写 "递归"逻辑
 // 因为是 因为是 “修改”类型的二叉树 ，采用的是  --->前序 遍历         
        		//中 ：
                TreeNode root = new TreeNode(root1.val + root2.val);
                 
        // 左： 当然都是  两棵树的 左子树 
                root.left = mergeTrees(root1.left, root2.left);
       // 右： 当然都是  两棵树的 左子树 
                root.right = mergeTrees(root1.right, root2.right);

                return root;

    }
}