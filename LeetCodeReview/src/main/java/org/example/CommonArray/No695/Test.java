package org.example.CommonArray.No695;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution695 solution = new Solution695();
        int[][] grid = new int[][]{
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}
        };
        System.out.println(solution.maxAreaOfIsland(grid));
    }
}
