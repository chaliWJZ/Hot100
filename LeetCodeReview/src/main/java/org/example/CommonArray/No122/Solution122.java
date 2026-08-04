package org.example.CommonArray.No122;

import java.util.*;
public class Solution122 {

    // --- 解法一 ---
// 这道题相比于I的话，就是可以多次 买卖股票了
//  总体思路就是，设 tmp 为第 i-1 日买入与第 i 日卖出赚取的利润，即 tmp = prices[i] - prices[i - 1] ；当该天利润为正 tmp > 0，则将利润加入总利润 profit；当利润为 0 或为负，则直接跳过；遍历完成后，返回总利润 profit。

// 使用 贪心的思想，局部最优，到 全局最优
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) 
                profit += tmp;
        }
        return profit;
    }
}