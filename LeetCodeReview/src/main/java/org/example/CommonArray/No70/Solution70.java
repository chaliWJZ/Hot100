package org.example.CommonArray.No70;

import java.util.*;
public class Solution70 {

    // --- 解法一 ---
//  采用动态规划来做，当前的 楼梯阶数 i的走法，依赖于 前面阶数楼梯i-1的走法个数。。。。 

    public int climbStairs(int n) {
        
			 // 采用 一维dp[] 就行
        // 因为是 第0阶,,,,到 第 n 阶 ，所以是求 n+1 个楼梯台阶，所以 dp[]数组长度是 n+1
            int[] dp = new int[n+1]; // dp[i] 代表的是，爬到第i阶 楼梯 有 dp[i]种 走法
          			
        // 初始化 dp数组，dp[0], 代表的是 第0层楼梯的走法是 0种方法。
        //   dp[1]代表的 第一层的台阶， 只有一种方法走上去，也就是 跨一次台阶 就行。。。
            dp[0]=1;
            dp[1]=1;
				
        		   	// for循环遍历计算dp[]数组，i从2 开始 遍历就行。
            for(int i=2;i<=n;i++){
							
                // 递推公式，dp[i]的状态是 dp[i-1] ， dp[i-1]  两者相加的和
                dp[i] = dp[i-1]+dp[i-2];  

            }
                return dp[n];
    }
}