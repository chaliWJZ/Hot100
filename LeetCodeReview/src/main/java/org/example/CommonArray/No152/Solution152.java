package org.example.CommonArray.No152;

import java.util.*;
public class Solution152 {

    // --- 解法一 ---
//   很明显，是需要用 dp动态规划来做。
//   这里的话，因为 数组中既有 正数，也有负数，0，所以 如果是 负数的最小值 乘上 负数，那么就会变成最大值。那么就是需要，声明两个dp数组，分别 代表 以nums[i]为下标的 子数组的乘积最大值 和 乘积最小值
//   然后是需要定义一个 res 全局变量，不断地 更新比较 

    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        
        // res 用于存储最终结果，初始化为 nums[0]
        int res = nums[0];
        
        // f[i] 表示以 nums[i] 结尾的子数组的乘积最大值
        int[] f = new int[n + 1];
        
        // g[i] 表示以 nums[i] 结尾的子数组的乘积最小值
        int[] g = new int[n + 1];
        
        // 初始化dp数组。 f[0] 和 g[0] 为 nums[0]
        f[0] = nums[0];
        g[0] = nums[0];

        for (int i = 1; i < n; i++) {
            
            // 计算以 nums[i] 结尾的子数组的乘积最大值
      
    // nums[i]>=0的时候， 比较大小 nums[i] 本身、f[i - 1] * nums[i]（延续前面的最大乘积）
   // nums[i]<0的时候,比较大小 nums[i] 本身、g[i - 1] * nums[i]（延续前面的最小乘积，因为乘以一个负数可能变为最大）
            f[i] = Math.max(nums[i], Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]));
            
            // 计算以 nums[i] 结尾的子数组的乘积最小值
    //nums[i]>=0的时候，比较大小 nums[i] 本身、g[i - 1] * nums[i]（延续前面的最小乘积）
    //nums[i]<0的时候,比较大小 nums[i] 本身、f[i - 1] * nums[i]（延续前面的最大乘积，因为乘以一个负数可能变为最小）
            g[i] = Math.min(nums[i], Math.min(g[i - 1] * nums[i], f[i - 1] * nums[i]));
            // 更新最终结果 res，取当前最大值和已有的 res 中的较大值
            res = Math.max(res, f[i]);
            
        }

        return res;
    }
}