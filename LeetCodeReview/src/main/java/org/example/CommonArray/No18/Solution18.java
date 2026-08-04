package org.example.CommonArray.No18;

import java.util.*;
public class Solution18 {

    // --- 解法一 ---
// 在"三数之和"的基础上外层再 多加 for循环就行。。。

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        // 只不过这里的要多定义一层for循环了，其他思路和三数之和一样
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                int left = j + 1;
                int right = nums.length - 1;

                while (right > left) {

                    // 为什么要这么做，因为本题的4个整数相加超出int能表示的最大值
                    // 所以要强转(long)类型！！！
                    long sum = (long) nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum > target)
                        right--;
                    else if (sum < target)
                        left++;
                    else {

              result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}