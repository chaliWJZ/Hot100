package org.example.CommonArray.No189;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution189 solution = new Solution189();
        // nums = [1,2,3,4,5,6,7], k = 3
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.println("Done");
    }
}
