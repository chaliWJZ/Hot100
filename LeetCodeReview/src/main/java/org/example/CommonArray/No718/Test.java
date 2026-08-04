package org.example.CommonArray.No718;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution718 solution = new Solution718();
        // nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{1,2,3,2,1};
        System.out.println(solution.findLength(nums1, nums2));
    }
}
