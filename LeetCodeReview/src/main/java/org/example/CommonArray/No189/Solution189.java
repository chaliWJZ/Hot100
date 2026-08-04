package org.example.CommonArray.No189;

import java.util.*;
public class Solution189 {

    // --- 解法一 ---
// 主要就是三次翻转，，，，1.先反转全部的元素 2. //在反转前k个元素  3. 接着反转剩余的
        public void rotate(int[] nums, int k) {

        int length = nums.length;

        k %= length;    // 这行代码很关键！！！因为 k 可能会，大于数组的长度，而且 可以防止 数组的越界问题 。而且则旋转 k 次和旋转 k % nums.length 次的效果是一样的。

        reverse(nums, 0, length - 1);//先反转全部的元素
        reverse(nums, 0, k - 1);//在反转前k个元素
        reverse(nums, k, length - 1);//接着反转剩余的
    }

    //把数组中从[start，end]之间的元素两两交换,也就是"反转"
    // 这道题的 次方法 reverse()，其实和 344 反转字符串的思想一摸一样。用到了 双指针的相向指针，来实现的
    public void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}