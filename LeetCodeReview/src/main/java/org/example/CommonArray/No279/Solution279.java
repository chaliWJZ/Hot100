package org.example.CommonArray.No279;

import java.util.*;
public class Solution279 {

    // --- 解法一 ---
//这道题 和 ”零钱兑换“ 一样。。。这里就是先要 找出  所有的 完全平方数。
// 使用的是 dp二维数组，完全背包问题

    public int numSquares(int n) {
	
        // 预处理出所有可能用到的「完全平方数」---->找出来，把它们作为  背包的 物品。
        // 这些平方数 都是 小于等于 n 总和的 
        List<Integer> list = new ArrayList<>();
        int t = 1;
        while (t * t <= n) {
            list.add(t * t);
            t++;
        }

        // dp[i][j] 表示，使用前 i 个完全平方数字，凑出 总和j 所使用到的 最少完全平方数的 个数
        	// 这里为了方便，多搞出来了一行，第 0 行。。。也就是 没有 完全平方数 的时候。。
        	//  所以之后的话，每次选择 第i个 平方数的时候，那么他的下标是 i-1 哦
        int m = list.size();
        int[][] dp = new int[m + 1][n + 1]; 
        
        // 初始化dp数组，全为 INF，因为是不断比较 最小值，最少 平方数的 个数。。
        // 比如 第一行可以这么理解，表示从前 0 种平方数 中选出若干个组成金额j>=1，是不可能的，无效值，所以设置成 INF
        int INF = Integer.MAX_VALUE;
         for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        
     // 初始化 dp数组的第一列。这是因为 背包容量为 0 时，不需要 任何完全平方数 就能凑出，即使用 0 个 平方数。
         for (int i=0;i<=m;i++) {
           dp[i][0] = 0;
        }

        // dp循环遍历计算，从左到右 →，从上到下 ↓
        for (int i = 1; i <= m ; i++) {

              int x = list.get(i - 1);
 			for (int j = 0; j <= n; j++) {
                
                // 这个 k代表 每一个平方数的 可以重复取的次数，默认从0 开始
                int k = 0;
                
             // 能取k次的前提 ： 第i个平方数 取k次的容量，小于等于 j背包的 数字总和
                while (k * x <= j) {
          // ---->"特殊"，又因为这道题 是 ”恰好“凑出 总和j，所以必须 还要if(...)判断一下！！
     //也就是 背包减去 第i个平方数 取k次的容量之后，剩下的容量 在 0,i-1区间取平方数的个数，再加上k个 第i个平方数 的个数 ，一直和之前的 dp[i][j] 比最小值min 。
                       if (dp[i - 1][j - k * x] != INF) {
                 dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k *x] + k);
                    
                       }
                    k++;
                }
            }

        }

     return dp[m][n];

    }
}