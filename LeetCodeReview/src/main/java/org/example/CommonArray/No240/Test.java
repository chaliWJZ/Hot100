package org.example.CommonArray.No240;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution240 solution = new Solution240();
        // matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(solution.searchMatrix(matrix, target));
    }
}
