package org.example.CommonArray.No240;

import java.util.*;
public class Solution240 {


    // --- 解法一 ---
public boolean searchMatrix(int[][] matrix, int target) {
    
    for (int i = 0; i < matrix.length; i++) {
       // 这个for循环遍历的话，其实就是 对 二维矩阵的 每一行进行遍历 。。。因为每一行都是“有序”的
        												//  所以 很适合----> 二分查找 
        int res = binarySearch(matrix[i], target);
        if (res != -1) {
            return true;
        }
    }
    return false;
}

    
//  “二分查找” 的代码 
public int binarySearch(int[] nums, int target) {
   int left = 0 , right = nums.length-1;
        	 
        //因为是 “左闭右闭” 原则 , 所以是  带等号的 <=
        
        while(left <= right){
           
            
             int mid = (left + right)/2 ;
            if(nums[mid]>target)
                // 所以 right 下标要更新成  mid-1 了
                right = mid - 1;
            else if (nums[mid]<target)
                // left 下标 要更新成 mid+1 了
                left = mid + 1;
            else
                return mid;

        }
        return -1;
}
}