package org.example.CommonArray.No64;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution64 solution = new Solution64();
        // grid = [[1,3,1],[1,5,1],[4,2,1]]
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(solution.minPathSum(grid));
    }
}
