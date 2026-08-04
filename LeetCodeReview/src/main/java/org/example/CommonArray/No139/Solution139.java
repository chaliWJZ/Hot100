package org.example.CommonArray.No139;

import java.util.*;
public class Solution139 {

    // --- 解法一 ---
//  使用的是 dp二维数组，完全背包问题
//  这里的  字符串就是 背包，字典里面的 单词 就是 一个个的物体，可以重复取。

    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        
        // 创建一个长度为 n + 1 的整数数组 dp，dp[i] 表示字符串 s 的前 i 个字符能否由字典中的单词组成。
        boolean[] dp = new boolean[n + 1];
        // 空字符串一定可以由空的单词列表组成，所以 dp[0] 设为 true
        dp[0] = true;

        // 遍历字符串 s 的长度，从 1 开始，因为 dp[0] 已经初始化好了。
        // 这里采用的是 双层for循环。。从左向右→
        for (int i = 1; i <= n; i++) {
            // 遍历从 0 到当前位置 i 的所有可能的子串起始位置 j。
            for (int j = 0; j < i; j++) {
                
                // 获取从位置 j 到位置 i 的子串。
                String word = s.substring(j, i);
                // 如果这个子串在字典中，并且前 j 个字符可以由字典中的单词组成（即 dp[j] == 1）。
                if (wordDict.contains(word) && dp[j] == true) {
                    // 那么前 i 个字符也可以由字典中的单词组成，所以将 dp[i] 设为 1。
                    dp[i] = true;
                    
                    /**
                    
             当考虑子串"code"（对应i = 8，j = 4）时，首先检查"code"是否在字典中，然后检查前j = 4个字符"leet"是否可以由字典中的单词组成（即dp[4] == 1）。只有这两个条件都满足时，才能确定前i = 8个字符"leetcode"可以由字典中的单词组成。
                                  
                    **/

                }
            }
        }

        // 返回 dp[n] 是否为 true，即整个字符串 s 是否可以由字典中的单词组成。
        return dp[n];
    }
}