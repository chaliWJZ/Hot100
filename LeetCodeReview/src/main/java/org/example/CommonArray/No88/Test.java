package org.example.CommonArray.No88;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution88 solution = new Solution88();
        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{1,2,3,0,0,0};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.println("Done");
    }
}
