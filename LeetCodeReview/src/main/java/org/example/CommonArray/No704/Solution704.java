package org.example.CommonArray.No704;

import java.util.*;
public class Solution704 {

    // --- 解法一 ---
// "二分查找"的前提是 ----> 有序 

    public int search(int[] nums, int target) {
         
        int left = 0 , right = nums.length-1;
        	 
        //因为是 “左闭右闭” 原则 , 所以是  带等号的 <=
        while(left <= right){

             int mid = (left + right)/2;
            //说明找到了，直接 return 
            if(nums[mid]==target)
                return mid;

            if(target<nums[mid])
     //  当这个target 元素小于mid的元素，说明target在左半边，right 下标要更新成  mid-1 了
                right = mid - 1;
            
            else 
     // 当这个target 元素大于 mid的元素，说明target在右半边， left 下标 要更新成 mid +1 了
                left = mid + 1;

        }
        
        // 执行完 while 循环，也没找到，直接 return -1 。
        return -1;

    }
}