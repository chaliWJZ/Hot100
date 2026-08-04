package org.example.CommonArray.No215;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution215 solution = new Solution215();
        // [3,2,1,5,6,4], k = 2
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums, k));
    }
}
