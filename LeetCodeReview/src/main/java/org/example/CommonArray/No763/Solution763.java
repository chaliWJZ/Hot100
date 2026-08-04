package org.example.CommonArray.No763;

import java.util.*;
public class Solution763 {

    // --- 解法一 ---
// 整体算法基于 贪心 策略，每次都 尽可能地扩展 当前区间，直到当前区间 包含了所有 在该区间内出现字母的 最后出现位置，然后确定这个区间，可以高效地计算出每个区间的长度，然后 再继续寻找下一个区间 。

    public List<Integer> partitionLabels(String s) {
        
        // 用于存储最终划分的每个区间的长度
        List<Integer> result = new ArrayList<>();
        
        // 用于记录每个字母最后出现的位置，数组大小为26，对应26个英文字母，初始化每个位置为
        int[] lastIndexOfChar = new int[26];
        
        // 遍历字符串，记录 每个字母 最后出现的 数组下标位置
        for (int i = 0; i < s.length(); i++) {
            
            // 获取当前字符在字母表中的索引位置（'a' - 'z' 对应 0 - 25）
            int index = s.charAt(i) - 'a';
            
            // 不断更新 同一字母 最后出现的位置 为 当前下标位置 i
            lastIndexOfChar[index] = i;
        }

        int start = 0;  // 当前划分区间的起始位置
        int end = 0;    // 当前划分区间的结束位置，初始化为起始位置 0

        // 第二次遍历 字符串，来确定 划分的区间
        for (int i = 0; i < s.length(); i++) {
            
            // 获取当前字符 在字母表中的 下标位置
            int index = s.charAt(i) - 'a';
            
            // 更新当前区间能到达的最远距离，取当前记录的最远距离和该字母最后出现位置的较大值
            // 这个是  “关键”
            end = Math.max(end, lastIndexOfChar[index]);
            
            // 如果当前位置i 已经到达了当前区间的最远距离end ， 说明可以划分出一个区间了
            if (i == end) {
                
                // 将当前区间的长度添加到结果列表中
                result.add(end - start + 1);
                // 更新下一个区间的 起始位置 为 当前区间 结束位置的下一个下标位置 end+1
                start = end + 1;
            }
        }

        return result;
    }
}