package org.example.CommonArray.No128;

import java.util.*;
public class Solution128 {

    // --- 解法一 ---
// 主要思想：因为题目中 要找 最长连续序列，要先"去重"，所以这样方便找 连续序列 ！！
// 使用哈希set 数据结构，可以达到 “去重" 的目的。
//  注意！！要找的 最长连续序列。。。。它的含义，不需要 元素在原数组中的位置，也连续

/**
   遍历哈希set。对于每个数字，如果 它是连续序列的起始数字（也就是 当前数字-1 不在哈希集合中）。那么才从 当前数字 开始，统计以它为起始的 连续序列长度。
   然后判断 当前遍历的数字+1 是否在哈希set中，在的话，就说明有连续的序列，那么 count序列长度+1 ，然后继续向后遍历，也就是 当前数字+1。。在while循环里面，直到 不存在当前数字+1 为止，退出循环
   所以，在每个有效的起点数字，找到的连续序列长度中，取最大值，就最最终答案。

**/

   public static int longestConsecutive(int[] nums) {
       
       if(nums.length==0)
           return 0;
       
     // 创建哈希set， 将数组中的元素添加进去，利用他的 ”去重“ 以及快速查找的特性contains()方法
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

       int res = 1; // 不断更新，最长连续序列的长度值。
       
        // 遍历哈希set 中的元素
        for (int num : numSet) {
            // 判断当前元素是否是连续序列的起始元素（即 当前元素-1 不在 set集合中）
            if (!numSet.contains(num - 1)) {
                
                 int count = 1;  // 每个连续序列长度，默认为 1
            	 int currentNum = num;
                
          // 从当前起始元素开始，不断往后查找连续的元素，只要当前元素 + 1在集合中，就继续循环
                while (numSet.contains(currentNum + 1)) {
                   
                     count++;
                     currentNum++;
                }
                // 更新最长连续序列的长度
                res = Math.max(res, count);
            }
        }

        return res;
    }
}