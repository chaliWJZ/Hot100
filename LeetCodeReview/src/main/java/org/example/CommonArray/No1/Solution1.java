package org.example.CommonArray.No1;

import java.util.*;
public class Solution1 {

    // --- 解法一 ---
// 暴力解法，双层 for 循环，一直去寻找。

    public int[] twoSum(int[] nums, int target) {

            int[] result = new int[2];
        
            // 暴力 解法 双层 for循环 
            for (int i = 0; i < nums.length; i ++) {

           //  为了 不找重复的元素，所以是从i的后一个数字开始查找
                for (int j = i + 1; j < nums.length; j ++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }

            }

     // 因为 这道题说明了，肯定是有一个答案的。。。这里其实返回 result 就根本不会执行到这行代码。。主要是为了 leetcode的 编译通过。。。。

              return result;

          }
}