package org.example.BinaryTree.BFS.No513;

import java.util.*;
import org.example.CodeTemplate.TreeNode;

public class Solution513 {

//  这题 最主要就是要知道， 最后一层的 第一个节点 ！！！---- >也就是 最左下角的 那个元素！！！
   public int findBottomLeftValue(TreeNode root) {

        Deque<TreeNode> deque = new ArrayDeque<>();

       // 这个res变量会不断更新赋值 ！！ 会 重新记录 每一层的第一个节点

       // 所以当内循环for 遍历到最后一层的时候，它会保存 "最终" 一层的， 第一个节点的
       // 此时再返回 res 即可！！！！！！！！
        int res =0;

        if (root == null)
            return 0;

        deque.offerLast(root);

        while (!deque.isEmpty()) {

            int size = deque.size();

            for (int i = 0; i < size; i++) {

                TreeNode treeNode = deque.pollFirst();
                // 记录 每一层的 第一个节点 ，会用于最下面 的 判断 最后一层的 第一个节点
     // 它这个值 会不断更新的，直到遍历到最后一层了，res记录的就是 最后一层的第一个节点
                if (i==0)
                    res = treeNode.val;

                if (treeNode.left!=null)
                    deque.offerLast(treeNode.left);

                if (treeNode.right != null)
                    deque.offerLast(treeNode.right);

            }

        }
                //  循环遍历完之后 。。。。。。。
                 //  直接返回res就行，因为此时的 res 记录的是 最后一层的第一个节点 ，
                                           // 也就是 最左下角的 那个元素！！！
        return res;
    }
}