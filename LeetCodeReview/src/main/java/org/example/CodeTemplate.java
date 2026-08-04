package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CodeTemplate {


    // 链表
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }

    }

    //二叉树
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) { this.val = val; }

    }


    // “非连续”的子序列 ，所以判断条件稍微复杂一点






    public static void main(String[] args) throws Exception {


        // 链表的 测试用例。。。
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);


        // 以及它的 打印遍历
        ListNode current = head;
        while (current!= null) {
            System.out.println(current.val);
            current = current.next;
        }






        // 二叉树的 测试用例。。。
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);


        // 栈和队列的 测试用例
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> queue = new ArrayDeque<>();

        // list和 set的测试用例
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        // map的测试用例
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 2);
        map.put(3, 2);
        map.put(1, 2);
        map.put(1, 2);
        map.put(1, 2);

        System.out.println(map.entrySet());

        // 一维数组 的测试用例
        int[] num1 = new int[]{1,2,3,4,6};
        int[] num2 = new int[]{1,2,3,4,6};

        // 二维数组 的测试用例
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        // 字符串的测试用例
        String s = "666";

        int num=0;
        num ='2'-'0';
        System.out.println(num);



    }
}
