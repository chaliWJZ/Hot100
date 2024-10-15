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


    public static int  searchInsert(int[] nums, int target) {

        int left = 0 , right = nums.length-1;

        //因为是 “左闭右闭” 原则 , 所以是  带等号的 <=

        while(left <= right){


            int mid = (left + right)/2;
            if(nums[mid]>target)
                //  high 下标要更新成  mid-1 了
                right = mid - 1;
            else if (nums[mid]<target)
                // low 下标 要更新成 mid +1 了
                left = mid + 1;
            else
                return mid;

        }
        // 必须是返回 left。只需要改动这个地方！！！具体原因如下 ：
        return left;
        /***
         *  以上while循环中，若找到了target直接返回

         *  当原数组不包含target时，考虑while循环最后一次执行的总是 left=right=mid,

         *  此时nums[mid] 左边的数全部小于target，nums[mid]右边的数全部大于target,

         *  则此时我们要返回的插入位置  分为两种情况：

         *  ①是该位置的右边一个，即nums[mid]<target时，此时执行了left=mid+1,返回left也正确
         *  ②就是这个位置，即nums[mid]>target时，此时执行了right=mid-1，返回left正确

         ***/

    }





    public static void main(String[] args) throws Exception {


        // 链表的 测试用例。。。
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(4);


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

        searchInsert(new int[]{1,3,5,6},2);

    }
}




