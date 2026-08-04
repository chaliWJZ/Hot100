package org.example.BinaryTree.DFS.No113;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution113 {

    // --- 解法一 ---
/**

大致思路：
   使用  "回溯法“ 的 递归去做。。。。！！！来遍历二叉树，找出所有 从根节点到叶子节点的 路径，使得 这些路径上 节点值的总和 等于目标值 targetSum。
   
   通过 "前序" 遍历的方式，先处理 当前节点，将其值添加到 路径和sum 与临时路径列表temp 中，然后递归遍历 它的左、右孩子。
   当遇到 叶子节点 并且 路径和sum 满足条件时，将该路径temp 添加到 结果列表res中。最后进行 回溯  操作，撤销对 当前节点值val 添加，以便继续 探索 其他路径。

**/

     // 在方法外面，定义 两个全局变量，，，
    
	 // temp是对应每一条 路径，保存的 每个节点值val   
      List<Integer> temp = new ArrayList<>();
    // res 是结果集合，当遍历到 叶子节点的时候，并且符合条件的，才会把temp的这个集合，保存进去
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       
        // 在下面定义了个 "次"方法，用来 递归的方法。
        // 定义了个新的参数 sum ，代表 一条路径的总和
       
        // 调用“次”函数，记得传入 初始值 sum 为 0
        travesal(root, targetSum,0);
        
        return res;
        
    }

    // “次”方法，用来 先序递归遍历，找到符合条件的 路径。。。
    private void travesal(TreeNode root, int targetSum,int sum) {
        	
        // 递归出口： 当传入的是一颗空树null的时候， 或者 是遍历到了 空节点，那么就要返回了 
        if (root == null) 
            return;
      		
        // 这里是 "寻找”类型的二叉树，，，所以用的是 --->前序遍历
        // 开始 单层的递归逻辑了。。。
        
        sum+=root.val;  // 每次递归遍历的时候，就要将 当前节点的值val 累加到 路径和sum 中
        temp.add(root.val);   // 还要将 当前节点的值，添加到 临时路径列表temp 中

       // 如果当前节点是否为 叶子节点 ，并且 当前路径和sun 等于目标路径和targetSum
        // 那么，将当前临时路径列表temp的 添加到  结果列表res 中
        if (root.left == null && root.right == null &&  sum== targetSum) {  // 中
            		
            	res.add(new ArrayList<>(temp));	
     	
        }
					
         // 递归遍历 当前节点的 左、右 孩子，继续寻找 满足条件的 路径
        travesal(root.left, targetSum,sum); // 左
        travesal(root.right, targetSum,sum); // 右 
        
       // "回溯" 操作，记得要 "撤销" 之前的 添加节点值val的操作，，，，
        // 这样才能保证在遍历 其他路径 时，temp 中存储的是 正确的当前路径 节点值 		
        temp.remove(temp.size() - 1); 
        
    }
}