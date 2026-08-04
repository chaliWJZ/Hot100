package org.example.CommonArray.No209;

import java.util.*;
public class Solution209 {

    // --- 解法一 ---
// 就是使用 “滑动窗口”的思想去做 这道题
// 定义两个while循环，外层循环的，right 右边界一直向右移动
//  当满足题目条件的时候， sum>= target，就执行while内层循环，left左边界 一直向右收缩，窗口缩小，在里面不断比较 result ，记录 最小的长度

    public int minSubArrayLen(int target, int[] nums) {
        
  // 因为要对 最终结果result 不断比较 和 更新，求数组长度的最小值。所以初始值一般是 Integer.MAX_VALUE 
            int result = Integer.MAX_VALUE;

        // 子数组的数值之和
            int sum =0;

        	 // 滑动窗口的右指针 right
        	int right=0;
            // 滑动窗口的左指针 left 
            int left=0;
              
        		// 右指针 right 没有到数组末尾，就一直 while 循环下去
           while(right<nums.length){
               
		 // 先向右扩展窗口，所以只需要移动right指针，每次移动都要累加，当前所指元素的值 
                sum+=nums[right];
               
              // 当满足 题目条件 的时候，就要开始对 左指针 left 向右移动，开始缩小窗口 
                while(sum>=target){
  						    
   //这道题是 求最“短”。当满足条件，就要在 内层while循环 更新结果 result 的操作 
                    //  求子数组的长度，记得 +1
          		 result = Math.min(result,right-left+1);
                           
         //这里体现出“滑动窗口”的精髓之处，左指针 left 不断向右移动，开始缩小窗口，也就是要把之前添加过的求和元素，把它移除！！！
                 sum-=nums[left];
				 left++;
                }
		
        // 切记要对 右指针right++ ，因为 右边指针的话只会不断的向右移动
                right++;

            }
        
			  // 如果result没有被赋值的话，就返回0，说明 没有符合条件 的子数组 
            return result==Integer.MAX_VALUE?0:result;
            
    }
}