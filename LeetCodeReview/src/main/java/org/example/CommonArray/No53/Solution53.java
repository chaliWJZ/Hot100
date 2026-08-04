package org.example.CommonArray.No53;

import java.util.*;
public class Solution53 {

    // --- 解法一 ---
//   这道题 我采用的是 dp动态规划去做 。。。一维 dp数组[] 就行
//   子数组是 --->“连续”的 ，所以就只要 定义一个 for循环去遍历计算 dp就行了。。

    public int maxSubArray(int[] nums) {
            
      //dp[i]是指，表示在nums中以下标 i 为结尾 的最大子数组长度是dp[i]  
        int[] dp = new int[nums.length];
        
        int max = nums[0];  //因为这道题的话，求的是最大子数组和，不一定是 数组的最后一个下标为结尾的，所以要逐个比较遍历 dp[i]数组 和 max，得出最终的答案。。
        // 这里 max初始值是 nums数组的第一个元素nums[0] 

        // 初始化dp数组，dp[0]默认就是一个nums元素
        dp[0] = nums[0];

        // 遍历顺序。很容易想到，dp[i]是依赖与 前面的状态i-1，那么就是从左往右 →
        for (int i = 1; i < nums.length; i++) {
            
            // 递推公式，就是  和前面状态dp[i-1]加上当前遍历的 数组元素nums[i]，再和 当前的nums[i] 的元素比较。。。哪个更大，再赋值计算给 dp[i]当前的格子
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            
            // 记得 每次算出来的 dp[i]格子值，要和 max比较大小，然后继续更新 
            max = Math.max(max,dp[i]); //特殊之处
            
        }

          // 这里也是返回max，而不是 dp[]数组的最末尾的下标
      // 因为不一定以最末尾的 数组的它的dp格子值dp[nums.length]，才是最大的。。。 
        return max; // 特殊之处 
    }
}