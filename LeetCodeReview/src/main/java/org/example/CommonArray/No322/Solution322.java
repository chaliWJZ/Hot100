package org.example.CommonArray.No322;

import java.util.*;
public class Solution322 {

    // --- 解法一 ---
// dp二维数组，是 完全背包问题。
// 这里和 01背包的最大区别就是，对于 第i个物体可以取无数次，所以只需要考虑 取0，1，。。。k次就行。
// 能取k次的前提 ： 第i个硬币 取k次的容量，小于等于 j背包容量金额

    public int coinChange(int[] coins, int amount) {
       
        	 // 后续有加法操作，所以要除以2防止 整数溢出
        int INF = Integer.MAX_VALUE / 2;
        int n = coins.length; 

        //	dp[i][j] 表示，从前 i 种硬币中组成金额 j 所需最少的硬币数量
        	// 这里为了方便，多搞出来了一行，第 0 行。。。也就是 没有金币的时候。。
        	//  所以之后的话，每次选择 第i个数字的时候，那么他的下标是 i-1 哦
        int[][] dp = new int[n + 1][amount + 1];

        // 初始化dp数组，全为 INF，因为是不断比较 最小值，最少硬币个数。。
        // 比如 第一行可以这么理解，表示从前 0 种硬币中选出若干个组成金额j>=1，是不可能的，所以设置成 INF
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = INF;
            }
        }

  // 初始化dp数组，对于第一列，都设置为 0。表示从前 i 个硬币中凑出 背包金额0 所需要的硬币数目为 0，也就是 不取 就行。
        // 单独对第一列设置为 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
	   
        	// 双层 for循环 ，从左到右→，从上到下↓
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                
                // 这个 k代表 每一个硬币的 可以重复取的次数，默认从0 开始
                int k = 0;
                
             // 能取k次的前提 ： 第i个硬币 取k次的容量，小于等于 j背包容量金额
                while (k * coins[i - 1] <= j) {
     // 也就是 背包减去 第i个硬币 取k次的金额之后，剩下的金额 在 0,i-1区间取金币的个数，再加上k个 第i个硬币个数 ，一直和之前的 dp[i][j] 比最小值min 。
                 dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i - 1]] + k);
                    k++;
                }
            }
        }	
		// 因为一开始设置成了 INF 最大值，如果 没有更新，就说明找不到 最少的硬币数，就返回-1
        return dp[n][amount] == INF? -1 : dp[n][amount];
    }
}