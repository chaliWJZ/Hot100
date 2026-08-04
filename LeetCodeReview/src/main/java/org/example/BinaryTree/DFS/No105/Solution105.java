package org.example.BinaryTree.DFS.No105;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution105 {

    // --- 解法一 ---
/**
  这道题目是， 前序 + 后序的数组 ===》 构建一棵  二叉树
	首先我们可以显然知道当前  preorder[第一个下标]，只用找出它在 inorder中序数组中的 下标位置index，也就是 要构造二叉树的root根节点，然后就可以把 左、右子树分开来了 
	
	中序遍历中： 我们知道 左子树：[inorder_start,index-1], 右子树：[index+1, inorder_end]
	在前序遍历：左子树的起始位置 为 pre_start+1,左子树一共有(index-1 - inorder_start)个，因此左子树：[pre_start+1, pre_start+1 + (index-1 - inorder_start)]
		右子树的起始位置 为 左子树终止位置+1，终止位置为 pre_end，因此右子树：[ pre_start+1 + (index-1 - inorder_start) + 1, pre_end]

 */

public     // 在方法的最外面，定义一个全局变量map
    // 主要是为了根据 preorder前序数组的 节点值，去 inorder中序数组 查找 下标位置index，也就是根节点root
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 先用 map 保存 inorder中序数组的 每个数值，以及 对应的下标，从 0 开始。
        // 目的是，为了在 下面"递归"函数里面，每次都会根据 preorder前序数组，第一个下标的 元素值。
        // 然后去map中 找到它 在中序数组 的 下标值 i，也就是 二叉树的根节点root。
        // 这个很关键！！！找到 下标值i 之后，就找到了 root的 左右子树，就可以很方便的 左、右 递归构建二叉树了。
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // 调用下面定义的 findNode()递归函数，形参是 中序数组的起始、结束 下标 ；以及 前序数组的 起始、结束下标。
        // 传入的初始值就是 0，以及 对应的数组长度。 这里是 [ , ) 左闭右开的区间。
        return findNode(inorder, 0, inorder.length, preorder, 0, preorder.length);
    }

    public TreeNode findNode(int[] inorder, int i_start, int i_end, int[] preorder, int p_start, int p_end) {
        // 递归出口 ：
        // 当"递归"遍历数组的时候，起始下标 >= 终止下标  ，说明没有元素，返回空树 null
        if (i_start >= i_end || p_start >= p_end) {
            return null;
        }

        // 中 ：
        // 先找  preorder前序数组 第一个下标的 元素值。 然后去map中 找到它 在中序数组 的 下标值 index。也就是 二叉树的根节点root。
        int rootIndex = map.get(preorder[p_start]);
        // 然后就可以 new 一个 根结点root 了，主要就是 传入 inorder中序数组下标index 对应的val值
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 保存中序数组 左子树的节点个数，用来确定前序数组中 需要遍历的 结束下标
        int lenOfLeft = rootIndex - i_start;

        // 左：
        // 递归 构造左子树：   中左数组 + 前左数组
        root.left = findNode(inorder, i_start, rootIndex, // 中左数组 的 终止下标是   rootIndex，也就是根节点。
                preorder, p_start + 1, p_start + 1 + lenOfLeft); // 前左数组的 起始下标 肯定是除了第一个根节点的下一个 下标，那么就是 p_start + 1 。那么前左数组的 终止下标，就是起始 p_start + 1 必须再加上 lenOfLeft。它 和 前右数组的 起始下标，是一样的

        // 右：
        // 递归 构造右子树：  中右数组 + 前右数组
        root.right = findNode(inorder, rootIndex + 1, i_end, // 为什么中右数组，起始下标 这里是 rootIndex +1 。是因为 rootIndex 就是根节点，不需要再从它 开始遍历
                preorder, p_start + 1 + lenOfLeft, p_end); // 前右数组的 终止下标就是 末尾了，

        return root;
    }
}