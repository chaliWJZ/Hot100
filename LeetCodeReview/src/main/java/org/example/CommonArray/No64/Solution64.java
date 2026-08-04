package org.example.CommonArray.No64;

import java.util.*;
public class Solution64 {

    // --- 解法一 ---
// 采用 dp 动态规划，而且很明显的话，要用 二维dp数组[][]
//  同样的，对于 每一个 矩阵的 格子，比如 dp[i][j]只能依赖 它的左边的格子 dp[i][j-1] 和 它顶上的格子dp[i-1][j] 这两者之间的关系 。。。找出递推关系 ！！

    public int minPathSum(int[][] grid) {

    int m = grid.length ;  // 获得矩阵的 行数
    int n = grid[0].length; // 获得矩阵的 列数
    
    		// dp[i][j] 代表的是，从[0,0] 到 [i,j] 下标的格子，最小的路径之和是 dp[i][j]
    int[][] dp = new int[m][n];	
    
    dp[0][0] = grid[0][0];	//  特殊处理左上角元素[0,0]
    
    		// 初始化 dp数组，第一列的每个格子dp[i][0]，都是 它顶上一个格子 + 自己格子的值
    for (int i = 1;i < m;i++) 
        dp[i][0] = grid[i][0]+dp[i-1][0];
    
				// 初始化 dp数组，第一行的每个格子，都是 左边一个格子 + 自己格子的值
    for ( int i = 1;i < n;i++) 
        dp[0][i] = grid[0][i] + dp[0][i-1];
    
		// 开始for循环遍历计算 dp数组，从上到下↓，从左往右→
      // 一般来说 初始化第一行，第一列之后，所以这里的 for循环 一般 都是 下标从 1 开始了。。。 
    for ( int i = 1 ; i < m ;i++) {
        for ( int j = 1;j < n;j++) {
            
     //dp递推公式。dp[i,j]依赖于，上面格子 和 下面格子的最短路径和的 最小值，再加上当前格子的值，就是当前格子 的最短路径和。
            dp[i][j] =  Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
        }
    }
    
   			 return dp[m-1][n-1];
    
}
}