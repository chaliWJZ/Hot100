package org.example.CommonArray.No48;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution48 solution = new Solution48();
        // matrix = [[1,1,1],[1,0,1],[1,1,1]]
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        solution.rotate(matrix);
        System.out.println("Done");
    }
}
