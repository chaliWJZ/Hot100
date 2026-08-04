package org.example.CommonArray.No509;

import java.util.*;
public class Solution509 {

    // --- 解法一 ---
// 这道题 的话，可以使用 dp动态规划，只不过是少见的 。。。。题目中就直接给了 递归公式。。。。

public int fib(int n) {

    		   // 这个主要是为了防止传入 n =0的时候，数组越界。。。
          if (n == 0) return 0;  

    			// 采用一维的 dp[]就行
    		 // 因为是 F(0)....到 F(n)，所以是求 n+1 个数，所以数组长度也是 n+1
        int[] dp = new int[n + 1];    // dp[i] 代表的是，第i个数的斐波那契数是 dp[i]

    					//   初始化 dp数组。 
        dp[0] = 0;
        dp[1] = 1;
    					//   遍历计算 dp数组。  for循环一般都是 i 从 2开始。
        for (int i = 2; i <= n; i++){ 
            dp[i] = dp[i-1] + dp[i-2];  // 递推公式 ，状态转移公式，dp[i]依赖前两个数
        }
    			
        return dp[n];

    }
}