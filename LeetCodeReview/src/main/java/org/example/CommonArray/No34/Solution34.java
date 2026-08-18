package org.example.CommonArray.No34;

import java.util.*;
public class Solution34 {

    // --- 解法一 ：二分查找---
// 主要思想 ：  相比于之前的 二分查找(真正的递增有序)，本题目是 非递减，其实也就是类似 递增“有序”，也就是里面的一些  元素会重复！！
// 如果此时我们的 nums[mid] = target ,但是我们不能确定 mid 是否为该目标数的左边界，所以此时我们 不可以 直接返回 mid下标 return mid
//而是要把if判断 target 和 nums[mid]  == 和 < 一起合并，继续移动 右指针right，在左半区间 查询。它们 公用一行代码 right = mid -1
// 同理，找target目标值的 上边界，就是要把 if判断 target 和 nums[mid]  == 和 > 一起合并，在右半区间 查询。它们 公用一行代码 left = mid + 1


// 定义两个方法，也就是进行 两次 “二分查找”，，，分别找 下边界low 和上边界 。。。。
    public int[] searchRange (int[] nums, int target) {
				
         int low = lowerBound(nums,target);  	// 找 下边界 的方法 
         int upper = upperBound(nums,target);   // 找 上边界 的方法 

      //  也就是如果  upper 小于 low 的话，就说明没找到 target元素。。此时就要返回 [-1,-1]
         if (upper < low) {
             return new int[]{-1,-1};
         }
			
     //  其他情况的话，  upper > low, 就说明 target目标值存在多个，有上下边界 如果 ==，那么就只有一个元素。
        // 如果 ==，那么就只有一个元素。
         return new int[]{low,upper};
    }

    // 计算下边界
    int lowerBound(int[] nums, int target) {
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            
            int mid = (left + right)/2;

            // 这里就少掉了 target == nums[mid]的 if判断，不需要直接 return mid下标了，需要继续向左⬅️寻找 下边界
            // 只剩下 if 、 else 两种情况了

            if (target <= nums[mid])
                   // target 小于 nums[mid]的时候，此时判断条件 还要 带上 =
                //当目标值target 小于等于 nums[mid]时，继续在左区间查询
                right = mid - 1;

            else if (target > nums[mid]) 
                
                left = mid + 1;
            
        }
        
       //此时跳出while 循环的时候，left 指向的下标刚好是我们的下边界，所以return left 
        return left;
        
    }

    //  计算上边界， 和上面的求 上边界， 里面的代码 就是“相反”的改动
    int upperBound(int[] nums, int target) {
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {    
            
            int mid = (left + right)/2;
            // 这里就少掉了 target == nums[mid]的 if判断，不需要直接 return mid下标了，需要继续向右➡️寻找 上边界


            if (target >= nums[mid])
                //  大于的时候，此时要 带上 =
                //当target目标值 大于等于 nums[mid]时，继续在右区间查询
                 left = mid + 1;               
            else if (target < nums[mid]) 
                right = mid - 1;
                     
        }
    
   //此时跳出while 循环的时候，right 指向的下标刚好是我们的上边界，所以return right 
        return right;
    
    }
}