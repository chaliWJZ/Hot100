package org.example.CommonArray.No704;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution704 solution = new Solution704();
        // nums = [-1,0,3,5,9,12], target = 9
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
        System.out.println(solution.search(nums, target));
    }
}
