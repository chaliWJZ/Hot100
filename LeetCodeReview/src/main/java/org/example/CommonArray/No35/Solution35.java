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
        可以返回 right + 1，也可以返回 left 的原因： 
        因为循环的最后一步一定是left==right，如果导致这个循环打破只有两个原因，要么是right = mid - 1导致left>right，说明我们要插入的元素位置应该是小于mid元素。这种情况也就导致了right的最终下标相对我们要插入的元素位置是左移的，所以最后的位置应该是right + 1； 
        要么是left=mid +1，导致的 left >right，说明我们要插入的元素位置应该是大于mid元素的。这就说明left的最终位置是相对插入元素右移了一位，因为本身插入的元素就应该右移，所以只需要返回left即可
           
           ***/

    }
}