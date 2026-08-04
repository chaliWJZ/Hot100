package org.example.CommonArray.No41;

import java.util.*;
public class Solution41 {

    // --- 解法一 ---
/**   而对于一个 连续的正整数序列，下标从 0 开始，最好是 下标0存放1， 下标1存放2，也就是下标i处存放的 元素值就是 i+1 。
	  所以我们要先遍历一下给定数组，调整 数组中每个元素x的位置，都放在 下标x-1的位置上。
	 然后，方便后续 从头遍历数组 的时候，查找判断，缺失的最小正整数 是哪个。只要有个 下标位置上的元素 不符合 下标i+1，它就是 缺失的最小正整数。

**/
 
    public int firstMissingPositive(int[] nums) {

       // 第1轮for循环：原地，重排数组
        // 元素x 应该放在  数组中下标为x-1 的位置上，所以要进行 数组元素的交换
        for (int i = 0; i < nums.length; i++) {       
            
        // 需要交换的 元素x 必须满足以下条件：元素值 大于等于1 并且 小于等于数组长度(防止越界)，最后一个条件就是，不和 下标x-1上 的元素相等，不然的话 就会一直 无限while死循环。。。
         while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) { 
             // 因为可能交换一次之后，还有符合条件的元素，所以此处不用 if ，必须改用while，这样可以执行多次
            	// 交换数组元素，但是注意，对于数字x，应该放在数组中 下标为 x-1 的位置上
                        int temp = nums[i];
                        nums[i] = nums[temp-1];
                        nums[temp-1] = temp;   
            }
 
        }

        // 第2轮for循环： 查找缺失的最小正整数
        // 因为 元素x放在了 下标x-1的地方。如果for循环扫描的时候，发现 nums[i]的元素值 不等于 下标i+1，那么就发生了缺失，就要返回 下标i+1  (也就是缺失的最小 正整数)
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] != i + 1) 
                return i + 1;
        }
        return nums.length + 1;
    }
}