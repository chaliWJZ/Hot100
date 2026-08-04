package org.example.CommonArray.No121;

import java.util.*;
public class Solution121 {

    // --- 解法一 ---
// 整体思路就是：维护一个最小值 成本cost，最大值 利润profit。只是通过一次遍历股票价格 数组，一边记录最低买入成本cost，然后 计算不同时刻卖出利润，也就是 price-cost 和之前的最大利润profit值比较，最终返回整个过程中可以获得的 最大利润值profit 。

// 使用 贪心的思想，局部最优，到 全局最优

    public int maxProfit(int[] prices) {
        
        // 因为是要不断更新 最低买入成本 cost ，所以先初始化成 整数的最大值
        // 同时初始化 最大利润profit为0，后续会不断更新
        int cost = Integer.MAX_VALUE, profit = 0;

        for (int i = 0; i < prices.length; i++) {
         
            // 获取当前 数组下标位置i 对应的股票价格
            int price = prices[i];
            
    // 用当前遍历的 股票价格price和 之前记录的最低成本cost不断比较，然后更新 最低买入成本cost，
            cost = Math.min(cost, price);
            
            // 计算当前价格下卖出能获得的利润，用当前价格price - cost之前记录的最低买入成本 
            // 然后再取这个利润 和之前记录的最大利润profit中的较大值来更新最大利润
            // 然后不断更新 最大利润值profit
            profit = Math.max(profit, price - cost);
        }
    
        return profit;
        
    }
}