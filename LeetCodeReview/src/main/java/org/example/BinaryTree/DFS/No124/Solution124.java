package org.example.BinaryTree.DFS.No124;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution124 {

    // --- 解法一 ---
/** 
    大致思路：
	  在向下"递归"遍历↓ 的时候，先计算 当前节点的 左、右子树的最大路径和，分别是  leftmax 和 rightmax
	  然后每次都要 更新全局变量res 最大路径和，也就是res和(leftmax+rightmax+root.val当前节点)  进行比较，，不断更新最终的res值。。。。
  然后 "递归"向上↑返回的时候, 只能返回 较大的一边 leftmax还是 rightmax，记得再加上 root.val。

**/

    // 定义一个 全局变量 max，因为 找最大值的话，都是 把 max 定义成 Integer的最小值，然后在过程中不断比较，更新 max 的值
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        
         // 调用下面的"次"函数，它负责 "递归" 计算的。。。。
        find(root);
        
        return max;
        
    }

    public int find(TreeNode root) {
        
    // 递归出口: 遍历到空节点的时候，就是 传入的是一颗空树null ，那么此时返回的最大路径和就是0
        if (root == null) {
            return 0;
        }

        //  因为是 "计算"类型的二叉树 ，所以是 ---> 后序

    /**
    Q：为什么这里面的 还要Math.max(0,find()) 和 0 进行比较， 左、右孩子贡献 为什么要大于等于0？
    A: 因为计算 从某一节点出发的 路径和，计算公式:当前节点值root.val + 左孩子贡献 + 右孩子贡献，
        而左、右孩子贡献 是「可选的」，也就是说当某一边贡献小于0的时候，也就是 负数 ，其实是不需要去选择 左边 或右边 的路径，只需要返回 0，就代表 不选择 某一边的路径。。。当两边路径都是 负数的时候，完全可以两条路径 都不，也就是都选择 0。那么就只需要 0+0+ root.val  = root.val ，当前节点root的值就可以作为从该节点root 出发的最大路径和 
   				↓
   				↓    
   **/
         
        int leftMax  = Math.max(0, find(root.left));         // 左：左孩子贡献
        int rightMax = Math.max(0, find(root.right));        // 右：右孩子贡献
        
        // 这个 max 肯定是要一直更新的，三者的要相加 ！！！ 	=====》 主要是为了计算最终的答案				  (当前节点值root.val + 左孩子贡献 + 右孩子贡献)					
        max = Math.max(max, root.val + leftMax + rightMax); // 中：

 // 每次计算完，记得 向上"递归"返回，当前节点root 的总贡献。。。<---选择某个更大贡献的 子树 再加+ 															当前节点 root.val 
        return root.val + Math.max(leftMax, rightMax);      
    }
}