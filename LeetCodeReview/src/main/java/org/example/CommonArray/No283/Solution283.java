package org.example.CommonArray.No283;

import java.util.*;
public class Solution283 {

    // --- 解法一 ---
//   利用快慢指针的方式，通过一次遍历将非零元素 “紧凑” 地放置在数组前部，然后再将剩余位置填充为零。
/**	 fast快指针每次都会向后移动，只有当fast快指针指向的 元素不为零，就将 fast 指针所指向的这个非零元素 赋值给 slow 指针，然后 slow++ 才会向后移动。。。。
	  当fast快指针移动到了 数组末尾，那么数组的前半部分，slow指针之前的元素，都是非零的了。
	  然后从slow的位置开始，把它后面的下标位置 赋值0就行。
	**/

       public void moveZeroes(int[] nums) {

            int slow = 0;
            int fast=0;
            
            while (fast<nums.length){

                if (nums[fast] != 0)
                    nums[slow++] = nums[fast];

                fast++;
                
            }

            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }   
           
        }
}