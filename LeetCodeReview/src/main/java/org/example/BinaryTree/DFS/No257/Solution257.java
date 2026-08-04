package org.example.BinaryTree.DFS.No257;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution257 {

    // --- 解法一 ---
/**
主要思路： 
	它初始化 结果列表res，以及一个 路径字符串path
	采用先序 "递归" 地访问每个节点，如果不是叶子节点，则继续 递归遍历其 左右子节点。
	当遇到 叶子节点 时，将从 root根节点到该叶子节点的路径path的字符串 添加到结果列表res 中。
	
 */

  // 这道题 因为自带的主函数 的形参不够用。。所以又在下面定义了个 “次”函数，它作为递归函数。
//  然后在 主函数里面调用下面的  “次”递归函数，记得传入 list集合，以及 初始化参数 path = ""，空字符串
    public List<String> binaryTreePaths(TreeNode root) {
        
        // res是一个 引用数据类型，会在 下面的paths()递归函数里面，不断更新变化的。。。。
        List<String> res = new ArrayList<>();
        
        paths(root,res,"");

        return res;
    }

    public void paths(TreeNode root,List<String> res,String path) {
     
        // 递归出口： 遍历到空节点null的时候，那么就 return 
        if (root==null)
            return;

        // 那么剩下的情况就是， 节点非空 null 。。。。
        // 因为本题 属于  "查找"类型的 二叉树，所以适合用  ----->前序
        
        // 只有当 遍历到 叶子节点， 才 添加一次  结果路径字符串paht  到 res集合  
       if (root.left==null &&root.right==null)      //   中 
                res.add(path+root.val);
                
      // 记得！！ 递归函数的  path形参，每次递归用了一些 小小的 逻辑 ，字符串拼接 
        paths(root.left,res,path+root.val+"->");		// 左
        paths(root.right,res,path+root.val+"->");		// 右
       
    }
}