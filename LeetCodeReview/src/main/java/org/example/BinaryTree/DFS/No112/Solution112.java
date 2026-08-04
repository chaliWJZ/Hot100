package org.example.BinaryTree.DFS.No112;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution112 {

    // --- 解法一 ---
/**

主要思路： 
	它初始化 结果列表res，并且初始化一个 sum求和参数，。。
	采用先序 "递归" 地访问每个节点，如果不是叶子节点，则继续 递归遍历 其 左右子节点，不断累加 sum。
	当遇到 叶子节点 时，将从 root根节点到该叶子节点的路径之和sum 添加到结果列表res 中。
	
	最后再判断， res集合里面，有没有 等于 targetSum的 路径和，有的话才是 返回true 
 */

  //这道题比较特殊，因为自带的主函数 的形参不够用。。所以又在下面定义了个 “次”函数，它作为递归函数。
//  然后在 主函数里面调用下面的 “次”递归函数，记得传入 list集合，以及初始化参数 的sum =0，
    public boolean hasPathSum(TreeNode root, int targetSum) {

  // 让res 集合 保存 每一条路径上的 之和sum，其实就是作为 每一个元素。
        List<Integer> res = new ArrayList<>();
        pathSum(root,0,res);

          // 最后再看看里面的元素 是否包含 targetSum。包含的话就是 true，否则就是 false 	
      //  最后就是还要 调用一下这个 contains()函数 ，是否包含 targetSum
        return res.contains(targetSum);
       
    }

    public void pathSum(TreeNode root,int sum,List<Integer> res) {	
        
        // 递归出口： 遍历到空节点null的时候，那么就 return 
        if (root==null)
            return; 
            		
         // 那么剩下的情况就是， 节点非空 null 。。。。
        // 因为本题 属于  "查找"类型的 二叉树，所以适合用  ----->前序

        //  每次遍历到 叶子节点，那么就必须要 往这个 res里添加 这一条路径上的总和sum 了
       // 所以 res集合里面 保存的都是 每一条路径之和sum 
        if (root.left==null&&root.right==null)    // 中 
            res.add(sum + root.val);
        			
      // 记得！！递归函数的 sum形参，每次递归用了一些 小小的 逻辑 ，一直向下 累加
        pathSum(root.left,sum+root.val,res);		// 左
        pathSum(root.right,sum+root.val,res);    // 右
    }
}