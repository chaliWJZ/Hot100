package org.example.CommonArray.No63;

import java.util.*;
public class Solution63 {

    // --- 解法一 ---
// 也是要用 dp动态规划来做，很明显是 要用 二维dp来做的。！！！
// 这道题和 63 不同路径，主要就是区别在了，初始化dp[][]数组 和 遍历dp上的一些细节差异。。。
/** 
     因为有障碍物，所以 在初始化dp[][] 的 第一行和 第一列 的时候，有些不一样。。。
     而且 在for循环遍历dp[][]的时候，也要对 障碍物的格子进行判断 ！！
**/

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length; // 获取行数
        int n = obstacleGrid[0].length;  // 获取列数，对于二维数组，只能这么获取 
        
        // 定义dp数组，二维dp[][]
        //   dp[i][j]，代表的是 从最左上角[0,0] 走到 [i,j]格子，一共有 dp[i][j]种路径
        int[][] dp = new int[m][n]; 

        // 如果在起点或终点出现了障碍，直接返回 0，没有路径 可以走了。。。 “剪枝”
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) 
            return 0;
        
 //初始化dp数组。在for循环中间的判断 加上且 &&，这样遇到障碍物格子，在它之后的格子都不需要再赋值 1	
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) 
            dp[i][0] = 1;
        
        for (int j = 0; j < n && obstacleGrid[0][j]== 0; j++) 
            dp[0][j] = 1;
        
	// 遍历计算dp 二维数组，遍历顺序采用的是 ，从上到下 ↓，从左往右→
       // 一般来说 初始化第一行，第一列之后，所以这里的 for循环 一般 都是 下标从 1 开始了。。	
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {	
                
       // 就是要多加上这一行，要采用 递推公式的前提！！！肯定 是当前格子不是 障碍物，才可以使用   
              // 怎么思考递推公式  ！！？？ 
            //很容易发现，，dp[i][j]，依赖左边的格子 dp[i][j-1] 和上边的格子的路径数 dp[i-1][j] 两者相加 ！！ 
   // 你这么想，对于左边的格子的路径数 dp[i][j-1]已经求出来了，那么 要去右边的当前格子dp[i][j]，其实就是往右边前进一格，所以 路径的个数 仍然可以复用。。同理  对于顶上的格子，也可以复用 路径个数。综上所述，就是  等于 它们的 路径和 ！！   
                if(obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            
            }
        }
        
        return dp[m - 1][n - 1];
        
    }
}