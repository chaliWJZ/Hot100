package org.example.CommonArray.No74;

import java.util.*;
public class Solution74 {

    // --- 解法一 ---
/** 主要思路：
		题目的描述，说明每一行都是递增的，适合用 二分查找。。。
		遍历每一行，每一行进行1次二分查找。找到的话就直接 return true。			
**/

   public boolean searchMatrix(int[][] matrix, int target) {

  // 这个for循环遍历的话，其实就是 对 二维矩阵的 每一行进行遍历 。。。因为每一行都是“有序”的
       // 二维数组[][]的每一行，就是 一个数组[]，所以可以作为参数，直接传入 下面的函数
        //  所以 很适合----> 二分查找 
    for (int i = 0; i < matrix.length; i++) {
       	   
        int res = binarySearch(matrix[i], target);
        
        	// 如果返回值不是 -1，就说明在矩阵的某一行 找到 target元素了
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
    
    //没找到的话，就返回 -1
        return -1;
}
}