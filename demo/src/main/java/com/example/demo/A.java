package com.example.demo;


import com.example.demo.demos.web.People;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
public class A  {



    // 链表
     public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }

    }

    //二叉树
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) { this.val = val; }

    }





    // “非连续”的子序列 ，所以判断条件稍微复杂一点


    //


    private static List<String> result = new ArrayList<>(); // 记录结果

    public static List<String> restoreIpAddresses(String s) {

        // 这里的  startIndex 就是切割线，初始化是0
        // 比如说 "11123" ，startIndex=0 的话，就是 "1|1123"

        // 这里还要传入一个 pointNum 参数，代表往原始字符串s 添加的 点号. 数量，主要作为递归出口的判断
        backtracking(s, 0, 0);

        return result;

    }

    public static void backtracking(String s, int startIndex, int pointNum) {

        // 点号 数量为 3 时，分隔结束，递归出口。说明已经分成了四个字串了，已经是 ip地址格式
        if (pointNum == 3) {

            // 只需要再判断 第四段，剩下的子串是否合法，如果合法就放进 result 中
            if (isValid(s, startIndex, s.length() - 1)) {
                // 这里的话比较特殊，因为String 类型是不可变的，所以这里直接加 s就可以，
                result.add(s);
            }
            return;
        }


        for (int i = startIndex; i < s.length(); i++) {

            // 通过 [startIndex,i] 这个区间，就能获取到 s的子串，然后判断 是否合法
            if (isValid(s, startIndex, i)) {

                // 注意！！！这里的话，对于符合 需要对 原始字符串 s 每次都更新 ！！添加 点号.  	                                和之前的那种temp.add()不太一样 ！！！！

                //在原始字符串s 的i下标对应 的后面，插入一个逗点，主要通过substring(),注入传入的下标！！
                // 其实还是很好理解的，先要截取 i之前的 所有字符串s ，然后加上 点号.  然后再拼接上 i 下标到剩下的 length()-1 的截取字符串s
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;

                backtracking(s, i + 2, pointNum); //插入点号. 后 ！！因为原始字符串s 多了个字符串，所以下一个子串的起始位置为 i + 2 。。这点也很特殊 ！！
                pointNum--;         // 回溯，点号数量 -1
                s = s.substring(0, i + 1) + s.substring(i + 2);    // 回溯删掉点号.  ，这里记得 后面的截取 s字符串，也要从 i+2 开始，毕竟有之前的点号 .

            }


        }

    }


    // 判断字符串 s 在  左闭右闭区间[start, end] 所组成的数字是否合法
    public static boolean isValid(String s, int start, int end) {

        if (start > end) {
            return false;
        }

        if (s.charAt(start) == '0' && start!= end) { // 1、开头是0 的数字不合法
            return false;
        }


        int num = 0;
        // 因为是闭区间，所以要 <=
        for (int i = start; i <= end; i++) {

            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 2、遇到非数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 3、如果大于 255 了不合法
                return false;
            }

        }

        return true;

    }





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

        restoreIpAddresses("25525511135");

    }
}




