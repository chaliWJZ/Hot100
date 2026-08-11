package org.example.CommonArray.No35;

import java.util.*;
public class Solution35 {

    // --- 解法一 ---
// "二分查找"的前提是 ----> 有序 
// 这道题 建立在“二分查找”的基础上的 

    public int searchInsert(int[] nums, int target) {
         
        int left = 0 , right = nums.length-1;
        	 
        //因为是 “左闭右闭” 原则 , 所以是  带等号的 <=
        
        while(left <= right){

             int mid = (left + right)/2 ;
           if(nums[mid]==target)
                return mid;

            if(target<nums[mid])
     //  当这个target 元素小于mid的元素，说明target在左半边，right 下标要更新成  mid-1 了
                right = mid - 1;
            
            else 
     // 当这个target 元素大于 mid的元素，说明target在右半边， left 下标 要更新成 mid +1 了
                left = mid + 1;

        }	 	
         				// 主要是这行代码，很重要 ！！！
        		return left;
        
 /***
        为什么未找到时返回 left（或 right + 1）就是插入位置：
 
        循环退出时一定有 left > right，且恒有 left == right + 1（左闭右闭区间 [left, right] 已为空）。
        退出前的最后一次迭代一定满足 left == right == mid，此时只有两种情况：
 
        情况一：nums[mid] > target → 执行 right = mid - 1 后退出。
            说明 target 比当前 mid 元素小，应插在 mid 的位置（即该位置元素整体后移）。
            所以返回 right + 1 = (mid - 1) + 1 = mid，也与插入位置一致。
 
        情况二：nums[mid] < target → 执行 left = mid + 1 后退出。
            说明 target 比当前 mid 元素大，应插在 mid + 1 的位置。
            此时退出时 left == mid + 1，正好等于插入位置；
            所以返回 left下标
 
        因为循环退出时恒有 left == right + 1，所以返回 left 和返回 right + 1 完全等价。
        ***/

    }
}