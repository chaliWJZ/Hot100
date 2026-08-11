package org.example.CommonArray.No35;

public class Test {
    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        int[] nums = {1, 3, 5, 6};

        // 用例1: 找得到
        System.out.println("用例1: nums=[1,3,5,6], target=5");
        System.out.println("  结果: " + solution.searchInsert(nums, 5) + " (期望: 2)");

        // 用例2: 找不到（应插入中间位置 1）
        System.out.println("\n用例2: nums=[1,3,5,6], target=2");
        System.out.println("  结果: " + solution.searchInsert(nums, 2) + " (期望: 1)");

        // 用例3: 马上找到 (mid=(0+3)/2=1, nums[1]=3)
        System.out.println("\n用例3: nums=[1,3,5,6], target=3");
        System.out.println("  结果: " + solution.searchInsert(nums, 3) + " (期望: 1)");
    }
}
