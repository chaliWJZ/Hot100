package org.example.BinaryTree.DFS.No106;

import java.util.*;
import org.example.CodeTemplate.TreeNode;
public class Solution106 {

    // --- 解法一 ---
/**	
    这道题目是， 中序 + 后序的数组 ===》 构建一棵  二叉树
	首先我们可以显然知道当前  postorder[最后那个下标]，只用找出它在 inorder中序数组中的 下标位置index，也就是 要构造二叉树的root根节点，然后就可以把 左、右子树分开来了 

	中序遍历中： 我们知道 左子树：[inorder_start,index-1], 右子树：[index+1, inorder_end]
	在后序遍历：左子树起始位置为 post_start，左子树一共有(index- inorder_start-1)个，所以 左子树的下标是 [post_start, post_start + (index-1 - inorder_start)]
		右子树的终止位置为post_end - 1，因此右子树:[post_end - 1 - (inorder_end - (index+1)), post_end - 1]
**/

public     
    // 在方法的最外面，定义一个全局变量map
    // 主要是为了根据 postorder后序数组的 节点值，去 inorder中序数组 查找 下标位置index，也就是根节点
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 先用 map 保存 inorder中序数组的 每个数值，以及 对应的下标，从 0 开始。
        // 目的是，为了在 下面"递归"函数里面，每次都会根据 postorder后序数组，最后下标的 元素值。
        // 然后去map中 找到它 在中序数组 的 下标值 i，也就是 二叉树的根节点root。
        // 这个很关键！！！找到 下标值i 之后，就找到了 root的 左右子树，就可以很方便的 左、右 递归构建二叉树了。
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        // 调用下面定义的 findNode()递归函数，形参是 中序数组的起始、结束 下标 ；以及 后序数组的 起始、结束下标。
        // 传入的初始值就是 0，以及 对应的数组长度。 这里是 [ , ) 左闭右开的区间。
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    // 下面定义的 一个 “递归”函数 findNode()，形参是 中序数组的起始、结束 下标 ；以及 后序数组的 起始、结束下标。
    public TreeNode findNode(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end) {
        // 递归出口 ：
        // 当"递归"遍历数组的时候，起始下标 >= 终止下标  ，说明没有元素，返回空树 null
        if (i_start >= i_end || p_start >= p_end)
            return null;

        //  因为是 “修改，构造”类型的二叉树 。。所以采用 --->前序遍历

        // 中 ：
        // 先找  postorder后序数组 最后下标的 元素值。 然后去map中 找到它 在中序数组 的 下标值 index。也就是 二叉树的根节点root。
        int rootIndex = map.get(postorder[p_end - 1]);

        // 然后就可以 new 一个 根结点root 了，主要就是 传入 inorder中序数组下标index 对应的val值
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 记得 保存 inorder中序数组里面，左子树的节点个数。
        // 因为 要用来 确定 postorder后序数组中 需要遍历的 结束下标是多少 ，，，，很关键！！！
        int lenOfLeft = rootIndex - i_start;

        // 左 ：
        // 递归 构造左子树：   中左数组 + 后左数组
        root.left = findNode(inorder, i_start, rootIndex,  // 中左数组 的 终止下标是   rootIndex，也就是根节点root。
                postorder, p_start, p_start + lenOfLeft); // 后左数组的 终止下标，就是起始下标 p_start 必须再加上 lenOfLeft 。它 和 后右数组的 起始下标 相同

        // 右 ：
        // 递归构造 右子树：   中右数组 + 后右数组
        root.right = findNode(inorder, rootIndex + 1, i_end, // 为什么中右数组，起始下标 这里是 rootIndex +1 。是因为 rootIndex 就是根节点，不需要再从它 开始遍历
                postorder, p_start + lenOfLeft, p_end - 1); // 因为后序数组的 最后一个元素是 根节点，已经被用掉了，所以 后右数组的 终止下标是 p_end - 1

        return root;
    }
}