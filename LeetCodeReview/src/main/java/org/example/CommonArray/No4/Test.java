package org.example.CommonArray.No4;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        // nums1 = [1,3], nums2 = [2]
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{1,3};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
