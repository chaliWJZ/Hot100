package org.example.CommonArray.No39;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution39 solution = new Solution39();
        // candidates = [2,3,6,7], target = 7
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        int sum = 2;
        int startIndex = 2;
        solution.backtracking(candidates, target, sum, startIndex);
        System.out.println("Done");
    }
}
