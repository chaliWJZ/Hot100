package org.example.CommonArray.No300;

import java.util.*;
public class Solution300 {

    // --- 解法一 ---
// 这道题的话，子序列是指 "不连续"的 。。。
// 所以在用动态规划dp ，有点特殊的地方！就是还要多定义一个 for内循环，因为它依赖和 前面多个dp[]，不断比较。。

// 这里的答案不是 返回 dp数组的末尾下标[nums.length] ，而是定义一个 max第三者遍历，在遍历计算dp数组的时候，，需要不断更新比较的 ！！！

    public int lengthOfLIS(int[] nums) {
        
       // dp[i]是指， 以下标i为结尾的  最长递增子序列的长度是 dp[i]。。。
      //因为只有这么定义 dp[i]的 "含义" ！！才方便后面的 for遍历dp[]数组时候，递增比较的时候， 可以比较 nums[j] 和 nums[i] 的大小，边界很明确
        int[] dp = new int[nums.length];
        
      // 因为在下面的 for循环遍历计算dp[]的时候，是需要不断比较找到最大值的答案，所以定义 max   
        int max = Integer.MIN_VALUE;  // "子序列" 类型的dp，特殊之处 的地方

        // 初始化 dp数组，每一个以i下标结尾的，因为对应的dp[i] 最长递增子序列长度 至少都是 1
        for(int i =0;i<nums.length;i++){
            dp[i]=1;
          	max =1; // 初始化dp的时候，也是比较 特殊的地方，还需要给 max赋值。。
        }

      //遍历顺序，当然是从前往后遍历→。这里少有的一维dp数组，还要用 双层for循环来遍历。主要原因是，这里是 "不连续"的递增子序列，也就是 挑选的两个元素中间，可以 空开的。所以就必须再弄一个内层for 循环，j每次都从0开始遍历到i-1，把前面的每一个下标 都和 当前的下标i对应的dp数组  比较一下，求最大值。
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                		
                // 必须在某个if 条件下！！才需要用 递推公式。
// j是在前面，下标i是在j的后面，所以 只有 大于的情况 nums[i] > nums[j] ，子序列才是递增的，才用递推公式更新 dp[i] 。因为是 大于，所以 肯定可以 dp[j]+1 ，再和 当前下标dp[i] 取最大值就可以了。
                if (nums[i] > nums[j]) 
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
              
                // 记得 每次都要拿 当前的格子dp[i] 和 max 比较，然后更新最大值 ！！
				max = Math.max(max,dp[i]);   // 也是特殊的地方。。。
        } 
            
        }
        
      // 为什么这里那么特殊？？不是去直接返回 dp[nums.length-1] ,而是for循环比较大小 返回 max
            
       // 因为dp[i]是指， 以下标i为结尾的  最长递增子序列的长度是 dp[i]，所以 其实并不是说        i=nums.length最后一个下标结尾的 最长递增子序列的长度 就是最大值，也可能是 前面某个下标结尾的  才是最大值  。。。。
            	
        return max; 
        
    }
}