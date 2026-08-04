package org.example.BinaryTree.DFS.No114;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution114 {

    // --- 解法一 ---
/**

      采用的是 迭代的方式，，没有采用 “递归”的解法。。。
      
  主要思路：
  
  外面是一个while循环。。。root根节点，作为一个移动指针，一直向右边移动！！当 左节点为空的时候，root一直向右移动。。。。当 left左节点不为空的时候，就要进行以下 3步操作：
  
  1. 先找到 root左子树的 最右边的那个节点
  2. 找到之后，，然后 将原来的root右子树，接到 root左子树的最右边那个节点
  3. 最后 将root左子树插入到 原来root右子树的地方
  
  之后，root肯定还是要 继续 指向右节点right 。。

**/

	public void flatten(TreeNode root) {
    
		// 外面要套一层 while循环，这个root节点，好比是一个 "移动"指针，一直是 移动 到root的 right 右节点！！...  一直重复上边的过程，直到 新的节点的 ，，右子树为空 null
    	while (root != null) { 
        
        //如果root它的左子树为 null，直接考虑 下一个节点，也就是root的右节点right 。
        if (root.left == null) {
            root = root.right;
        } 
        		// 如果root的左子树 不为空null 的时候 
        else {
            
            // 1.先找 root左子树最右边的那个节点
    // 先声明一个 pre 临时移动指针，初始指向 root的left左节点。。在while 循环里面，一直向右边找
            TreeNode pre = root.left;
            while (pre.right != null) {
                pre = pre.right;
            } 
            
            //2.当找到 root左子树最右边的那个节点之后，，将原来的root的右子树 接到  root左子树的最右边节点，的右边 。
            pre.right = root.right;
               
  //将 原来的root左子树 ，插入到 root 右子树的地方，记得给 root的左节点left置为null，题目要求
            root.right = root.left;
            root.left = null;

            // 做完上边的操作之和，肯定也要考虑 root下一个节点，也就是root的右节点 right
            // 一直while循环，向右 移动。。
            root = root.right;
        }
    }
}
}