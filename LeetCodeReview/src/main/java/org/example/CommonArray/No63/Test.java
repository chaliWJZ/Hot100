package org.example.CommonArray.No63;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution63 solution = new Solution63();
        // obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
