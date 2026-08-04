package org.example.CommonArray.No169;

import java.util.*;
public class Solution169 {

    // --- 解法一 ---
// 这道理 采用投票法，时间复杂度是 O（n），空间复杂度 O（1）

/** 投票法的主要思路就是 ，

	“多数元素”res 初始化为 nums[0]，票数 count 初始化为 1。
当遇到与 res  相同的数，则票数 count + 1，否则票数 count - 1。
当票数 count 为 0 时，更换“多数元素”，并将票数 count 重置为 1。
遍历完数组后，res 就是 最终答案。

	因为 “多数元素”的个数 > ⌊ n/2 ⌋，其余元素的个数总和 <= ⌊ n/2 ⌋。
所以 “多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
这就相当于每个 “多数元素” 和其他元素 两两相互抵消，抵消到最后肯定还剩余 至少1个 “多数元素”。

**/

    public int majorityElement(int[] nums) {
        
        // 初始化 “多数元素”，并且票数初始化 1 
        int res  = nums[0], count = 1;
        
        for (int i = 1; i < nums.length; ++i) {
            
               // 如果当前遍历元素 和 候选“多数元素” 相等，那么票数加一
            if (nums[i] == res ) {
                count++;
            } else {
                // 如果当前元素和候选多数元素不相等，票数减一
                count--;
            }
            
           // 当票数count减到0的时候，说明之前的 候选“多数元素” 可能不是真正的“多数元素”了
  // 这时候就需要更换候选 “多数元素”，把当前遍历元素 当作 新的候选“多数元素”，并且重新把count 票数 设置为1
            if (count == 0) {
                res = nums[i];
                count = 1;
            }
            
        }
        return res;
    }
}