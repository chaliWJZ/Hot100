package org.example.CommonArray.No74;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution74 solution = new Solution74();
        // matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(solution.searchMatrix(matrix, target));
    }
}
