package org.example.BinaryTree.DFS.No98;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution98 {


    // --- 解法一 ---
public boolean isValidBST(TreeNode root) {

            List<Integer> res = new ArrayList<>();
                
      // 因为是 二叉搜索树，所以它的  中序遍历 是递增的，这个“特点”一定要记住！！！！！！
        //  所以 先调用“次”函数inorder()，使用 中序遍历的方式，往list集合添加元素。
            inorder(root,res);

               // 然后再通过下面的 for循环，遍历 list集合 ，来看看是否 是递增的↑
            //  如果出现 前面元素大于 后面元素，就不是 而二叉搜索树，返回false  
            for(int i = 0; i < res.size() - 1; i++){
                if(res.get(i) >= res.get(i+1))
                    return false;	
            }
            
            
            return true;
        }

    
        //  “次”函数 inorder() 。通过中序遍历 二叉搜索树，往list集合添加元素 
        public void inorder(TreeNode node,List<Integer> res){

            if(node == null)
                return;
            
            inorder(node.left,res);
            res.add(node.val);
            inorder(node.right,res);
        }
}
