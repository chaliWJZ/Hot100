package org.example.CommonArray.No34;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution34 solution = new Solution34();
        int[] nums = {5, 7, 8, 8, 10};

        // 用例1: 找得到（重复元素，返回第一个和最后一个位置）
        System.out.println("用例1: nums=[5,7,8,8,10], target=8");
        System.out.println("  结果: " + Arrays.toString(solution.searchRange(nums, 8)) + " (期望: [2, 3])");

        // 用例2: 找不到（返回 [-1,-1]）
        System.out.println("\n用例2: nums=[5,7,8,8,10], target=6");
        System.out.println("  结果: " + Arrays.toString(solution.searchRange(nums, 6)) + " (期望: [-1, -1])");

        // 用例3: 单个元素，上下边界相同（target=7 只出现一次，low == upper）
        System.out.println("\n用例3: nums=[5,7,8,8,10], target=7");
        System.out.println("  结果: " + Arrays.toString(solution.searchRange(nums, 7)) + " (期望: [1, 1])");
    }
}
