package org.example.CommonArray.No704;

public class Test {
    public static void main(String[] args) {
        Solution704 solution = new Solution704();
        int[] nums = {-1, 0, 3, 5, 9, 12};

        // 用例1: 找得到
        System.out.println("用例1: nums=[-1,0,3,5,9,12], target=9");
        System.out.println("  结果: " + solution.search(nums, 9) + " (期望: 4)");

        // 用例2: 找不到
        System.out.println("\n用例2: nums=[-1,0,3,5,9,12], target=2");
        System.out.println("  结果: " + solution.search(nums, 2) + " (期望: -1)");

        // 用例3: 马上找到 (mid=(0+5)/2=2, nums[2]=3)
        System.out.println("\n用例3: nums=[-1,0,3,5,9,12], target=3");
        System.out.println("  结果: " + solution.search(nums, 3) + " (期望: 2)");
    }
}
