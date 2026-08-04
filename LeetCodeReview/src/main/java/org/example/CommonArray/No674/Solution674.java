package org.example.CommonArray.No674;

import java.util.*;
public class Solution674 {

    // --- 解法一 ---
//这道题 多加了条件，是"连续"的子序列，，，比 最长递增子序列(非连续) 简单一些。。。

// 使用动态规划去做，。。。这里的话 ，只需要定义一个 for 循环！！去遍历计算就行了，因为 当前的dp[i]只是和 前一个 dp[i-1] 有关系。。。。！！！

    public int findLengthOfLCIS(int[] nums) {

        // dp[i]是指， 以下标i为结尾的  最长递增子序列的长度是 dp[i] 。。
        int[] dp = new int[nums.length];

        	//  因为是需要不断比较找到最大值的答案，所以定义 max
         int max = Integer.MIN_VALUE; // 特殊之处 1 
        
        // 初始化 dp数组，每一个以i下标结尾的，因为对应的dp[i] 最长递增子序列长度 至少都是 1
        for(int i =0;i<nums.length;i++)	{
            	dp[i]=1;
            	max=1; // 特殊之处 2
        }

     //for遍历计算的 顺序，当然是从前往后遍历→ ！！而且只需要一个for循环就行了
    //因为这道题是 “连续”  的递增子序列，所以 dp[i] 只跟前一个状态dp[i-1]有关，只需要比较最大值就行了。。。
    // 之前的 那道题是 "非连续"的，所以还要定义一个 内循环，把 j= 0到 i-1的每一个dp[j] 和 当前的dp[i] 进行比较 。。。。。
        for (int i = 1; i < dp.length; i++) {
       			
        // 必须在某个条件下，才需要用递推公式。
// 所以 只有 大于的情况 nums[i] > nums[i-1] ，是递增的，才用递推公式更新 dp[i] 。因为是 大于，所以 肯定可以 dp[i-1]+1 ，然后和 当前下标dp[i] 取最大值就可以了。
                if (nums[i] > nums[i-1]) 
                    dp[i] = Math.max(dp[i-1]+1,dp[i]);

            //每次都记得 和 max 比较大小，然后要更新
   				max = Math.max(max,dp[i]);  // 特殊之处 3 
        }

        return max;  // 特殊之处 4 
 
    }
}