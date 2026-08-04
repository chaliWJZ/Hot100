package org.example.CommonArray.No15;

import java.util.*;
public class Solution15 {

    // --- 解法一 ---
// 主要思想就是，从头开始 每次固定一个 下标元素 a，然后在 从它的下一个元素 b 以及 末尾下标元素 c 作为 左右双指针->相向指针，不断向中间每次靠拢，去查找 三数之和。。。

    public List<List<Integer>> threeSum(int[] nums) {
        // 这里用的是Set集合，可以对最终的答案集合“去重”元素！！！
        Set<List<Integer>> result = new HashSet<>();

        // 要先对数组排序 -->"有序"这个是前提!!!! 这样才能方便使用双指针（相向指针）。
        Arrays.sort(nums);

        // 在 "双指针"模板的基础上，这里外面还多了个for循环，这个是 特殊的地方！！！
        // 这里只不过是每次都固定住一个数字a = nums[i]，其他的 两个数字 b和c就是作为 双指针
        for (int i = 0; i < nums.length; i++) {
            // 每次固定一个新的nums[i]的时候，必须重新初始化 left和right 指针！！！
            // left是i的下一个元素nums[i + 1]，right当然永远是数组的最后一个元素nums[nums.length - 1]
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];

                if (sum < 0)
                    left++;
                else if (sum > 0)
                    right--;
                // 如果sum = 0,就说明找到了一组解a,b,c，把他们放在list集合里面
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                   // 找到一组解之后，肯定是需要同时left和right每次都向中间移动一步。。更新下标
                    left++;
                    right--;
                }
            }
        }

       // 题目中要求返回list集合，所以在new ArrayList的()传入set集合。。set转化为list集合就行
        return new ArrayList<>(result);
    }
}