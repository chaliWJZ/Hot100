package org.example.CommonArray.No40;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution40 solution = new Solution40();
        // candidates = [10,1,2,7,6,1,5], target = 8,
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        boolean[] used = new boolean[candidates.length];
        solution.backtracking(candidates, target, 0, 0, used);
        System.out.println("Done");
    }
}
