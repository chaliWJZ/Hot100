package org.example.CommonArray.No33;

import java.util.*;
public class Solution33 {

    // --- 解法一 ---
// 这道题 的话，就是有点不一样，因为 数组并不是完全有序的，只是 两边 是有序的。
//主要思想：先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段，接下来再判断 target 是在 mid 的左边还是右边，从而来调整左右边界 left 和 right 。。
//举个例子 nums = [4,5,6,7,8,9,0,1,2]  ，target =5 ，nums[mid]对应元素 8 大于 nums[left]元素 4 ，所以在左半段。然后 target 是5 小于 8，那么继续缩小范围，去left 和 mid-1的区间查找 

    public int search(int[] nums, int target) {
        
    	int left = 0, right = nums.length - 1, mid = 0;
        
    while (left <= right) {
        
        	mid = (left+right)/2;
        if (nums[mid] == target) {
            return mid;
        }

        // 先根据 nums[mid] 与nums[left]的关系判断 mid 是在 左段还是右段
        	  // 如果  mid 对应的元素值 大于  left 的值，就说明 mid 在左半段 
        if (nums[mid] >= nums[left]) {
            
              // 再判断 target是在 mid的左边还是右边，从而调整左右边界left和right
             //  注意，这里面的 话 target 严格 小于< ，因为要不断调整 left 和 right
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        } 
        
        //  说明在右段，思路类似
        else {
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

  			  return -1;
}
}