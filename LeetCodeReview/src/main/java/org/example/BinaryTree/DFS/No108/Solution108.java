package org.example.BinaryTree.DFS.No108;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution108 {

    // --- 解法一 ---
/**

  主要就是每次递归的时候，都要先去 找到 有序数组的中间下标index，也就是 根节点root 
  然后 在 它的最左侧下标 到index-1，是它的左子树。。
  它的 index+1，到最右侧下标，是它的 右子树。。。。
  不断递归下去 。。。就创建完成了 二叉搜索树。。。

 */

    public TreeNode sortedArrayToBST(int[] nums) {
		
        // 要去调用下面的一个 "次"函数，负责 递归创建 二叉搜索树。。。
        return fun(nums,0,nums.length);
    }

    public TreeNode fun(int[] nums,int start,int end) {
		
        if(start>=end)
            return null;

        // 因为是  “构造”类型的二叉树 ，所以是---> 前序  
        
        // 先找到中间下标mid，也就是 根节点 root 				// 中
        int mid = (start+end)/2;                		
        TreeNode root = new TreeNode(nums[mid]);  // 创建 该root节点。。
        
        root.left = fun(nums,start,mid);  // 左：创建左 子树
        root.right = fun(nums,mid+1,end); // 右：创建右 子树
        return root;

    }
}