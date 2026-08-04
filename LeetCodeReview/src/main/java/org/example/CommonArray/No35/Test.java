package org.example.CommonArray.No35;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        // nums = [1,3,5,6], target = 5
        int[] nums = new int[]{1,3,5,6};
        int target = 5;
        System.out.println(solution.searchInsert(nums, target));
    }
}
