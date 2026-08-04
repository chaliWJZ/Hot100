package org.example.CommonArray.No209;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution209 solution = new Solution209();
        // target = 7, nums = [2,3,1,2,4,3]
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}
