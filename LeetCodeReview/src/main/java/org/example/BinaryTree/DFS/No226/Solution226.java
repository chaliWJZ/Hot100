package org.example.BinaryTree.DFS.No226;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution226 {

    // --- 解法一 ---
// 主要思路 ：
// 其实就是交换一下 左、右节点left和right，然后再 "递归"的交换左节点，右节点

       public TreeNode invertTree(TreeNode root) {
		
           // 终止条件：当遍历的节点为 null空节点，就要return 返回。
            if(root ==null)
                return null;

         //  这个是 “修改”类型的 二叉树 ，所以采用 --->前序：中-左-右 。。逻辑代码 写在 最前面
          // 其实和 之前的那种 交换两个值一样的逻辑。这里是交换节点的代码，不仅仅是 val值交换了
            TreeNode temp = root.left;  // 中
            root.left = root.right;
            root.right = temp;

         root.left =invertTree(root.left); // 左
        root.right =invertTree(root.right);  // 右

        return root;

    }
}