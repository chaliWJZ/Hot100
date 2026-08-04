package org.example.CommonArray.No26;

import java.util.*;
public class Solution26 {

    // --- 解法一 ---
// 注意 ！！！这道题的要求是“原地” 修改，也就是在原来的 nums 数组里面进行修改，不需要声明一个新的 数组！！！
// 数组是“有序” 的，那么重复的元素一定会 相邻--->这个是 前提条件。所以比较适合用 双指针，"快慢指针"

    public int removeDuplicates(int[] nums) {
			
        	// 快慢指针，都从 下标 0 开始 
            int slow=0;
            int fast=0;
        
            int size= nums.length;

            while(fast<size){
                
		//	比较 慢指针slow 和 快指针fast 位置的元素是否相等。。如果相等，快指针fast后移 1 位
                if(nums[fast]==nums[slow])
                    	fast++;
                
        // 如果不相等，将 fast 位置的元素复制到 slow+1 位置上，fast 后移一位，slow 后移 1 位
                else{  
                    
                    nums[slow+1]=nums[fast];
                    slow++;
                    fast++;
                    
                }
                	
            }
        
       				// 因为数组的长度是 末尾下标+1 。。。
            return slow+1;
        
    }
}