package org.example.CommonArray.No238;

import java.util.*;
public class Solution238 {

    // --- 解法一 ---
// 用空间换时间，定义两个数组，left数组和 right数组。---》有点“前缀和”的思想
// 本题目的总体思想是 nums[i]的求解值 = nums[i]左侧的累乘 * nums[i]右侧的累乘
// 						  ans[i]  = left[i - 1] * right[i + 1]
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
		
        int[] left = new int[len];
        int[] right = new int[len];
        
        int[] ans = new int[len];
		
        //3 个 “并行”的 for循环    
        // 初始化左侧数组left[i]，从左到右遍历 ->
       	
        // 这个 的话一般就是先 下标0 赋值成nums[0]
        left[0] = nums[0];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        // 初始化右侧数组 right[i]，从右到左边遍历 <-
           // 这个 的话一般就是先 [len-1]赋值成nums[len-1]，所以遍历从下标[len-2]开始 
        right[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        // 计算结果数组。总体思想是 nums[i]的求解值 = nums[i]左侧的累乘 * nums[i]右侧的累乘
        // 不过要先考虑 nums[0] 和 nums[len-1]  这两种的边界情况
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                ans[i] = right[i + 1];
            } else if (i == len - 1) {
                ans[i] = left[i - 1];
            } else {
                ans[i] = left[i - 1] * right[i + 1];
            }
        }

        return ans;
    }
}