package org.example.BinaryTree.DFS.No101;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution101 {

    // --- 解法一 ---
/**
判断 对称二叉树，要比较的是根节点root，它的 左子树与 右子树，是不是相互对称的。。比较的是 两棵 子树
   所以在 “递归"遍历的过程中，也是要同时遍历 两棵树。。。 	
大致的思路就是， 先比较 两棵树的外侧 。然后再比较两棵树的 内侧。。。不断的"递归" 比较。。。

// 因为 默认的主函数 提供的方法参数 只有一个TreeNode 不够，所以在下面 定义了个 “次”函数，它作为主要的 ”递归“函数 。。。而且 形参是两个。分别传入 left左节点 和 右节点right。。。

**/

    public boolean isSymmetric(TreeNode root) {
        
      // 在 主函数里面，要调用下面的 “次”函数，并且传入 root的左、右节点 作为参数，作为初始值。
        return compare(root.left, root.right);
        
    }
		
   //因为 主函数 提供的方法参数 不够，所以定义了个 “次”函数，而且 形参是两个。分别是 left和right
    private boolean compare(TreeNode left, TreeNode right) {

        //  递归出口 就是 以下 几种情况：    
        //  左右节点中，如果它们都是 空节点null，那么就是 true，是对称的  
        if (left == null && right == null) 
            return true;
        
        //  左右节点中，只要有一个 是 为空节点null ，那么就是 false，肯定不是对称的	  
        if (left == null || right == null) {
            return false;
        }

        //  因为此时只剩下的情况就是，左右节点 都不为空，并且val值不相等，那么就是 false，不对称
        if (left.val != right.val)
            return false;

       // 因为我们把以上情况都排除之后，剩下的就是 左右节点都不为空，并且 数值相同的情况。
       //  因为是 “判断”类型的 二叉树  ，  采用的是 ---> 后序遍历 

        	 //比较 外侧：先递归的比较 左节点的左孩子 和 右节点的右孩子，
        boolean compareOutside = compare(left.left, right.right); // 左
        
            //比较 内侧：再比较  左节点的右孩子 和 右节点的左孩子，
        boolean compareInside = compare(left.right, right.left);  // 右
        
            // 对这两个 变量 进行 与&&运算，必须这两棵树都是 ture，才是 对称的
        return compareOutside && compareInside;  // 中
    }
}