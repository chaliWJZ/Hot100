package org.example.BinaryTree.DFS.No450;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution450 {

    // --- 解法一 ---
/**

递归的逻辑  ：
	如果 key 大于 当前节点值，肯定是去 二叉搜索树的 右子树中删除；
	如果 key 小于 当前节点值，肯定是去 二叉搜索树的 左子树中删除；
	
	如果 key 就是 当前节点，又要分为 以下三种情况：
		当前节点 没有 左孩子：其右子顶替其位置 ==》也就是 删除了该节点；
		当前节点 没有 右孩子：其左子顶替其位置 ==》也就是 删除了该节点；
		当前节点 左右孩子都有：其左子树 转移到 其右子树的最左节点的 左子树上，然后右子树顶替其位置 ==》也就是 删除了该节点。

**/

    public TreeNode deleteNode(TreeNode root, int key) {
           
        // 递归出口： 就当 传入的 root 为空树null，遍历到了null空节点的时候，就说明不需要删除节点了。返回null就行。
        if (root == null) 
            return null;

        // 因为是 删除，也就是 因为是 “修改”类型的二叉树 ，所以用-----> 前序 
        
        // 如果 key 就是 当前节点，那么就可以开始 "删除” 节点了	  //  中 
        if (root.val == key) {			
          
      //   当前节点 没有 左孩子：其右子顶替其位置 ==》也就是 删除了该节点；
        // 这里的“删除”节点,在代码中的体现，就是直接 return 返回 它的 左、右子树就行！！
            if (root.left == null)  
                return root.right;   
            
         //   当前节点 没有 右孩子：其左子顶替其位置 ==》也就是 删除了该节点； 
            else if (root.right == null) 
                return root.left;
            
               // 剩下的就只有 左、右子树 都不为空的情况
            else{
			       //定义一个 临时移动指针 t ，用于去找 root.right右子树中的最左边的那个节点 
                    TreeNode t = root.right;

                //注意，while的终止条件必须是 t.left不为空，这里你画个草稿纸就知道了
                    while (t.left != null)   
                        t = t.left;   
                
                //找到 root.right右子树中的最左边的那个节点之后，要进行 连接了 
                    t.left = root.left;

                    return root.right;
            }
            
        } 
        
         // 如果 key 小于 当前节点值，肯定是去 二叉搜索树的 右子树中删除；
        else if (key<root.val)  
            root.left = deleteNode(root.left, key);   // 左 
        
       // 如果 key 大于 当前节点值，肯定是去 二叉搜索树的 右子树中删除；
        else 
            root.right = deleteNode(root.right, key); // 右
        
        return root;
    }
}