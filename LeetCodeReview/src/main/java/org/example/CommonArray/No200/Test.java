package org.example.CommonArray.No200;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution200 solution = new Solution200();
        // grid = [
        // ['1','1','1','1','0'],
        // ['1','1','0','1','0'],
        // ['1','1','0','0','0'],
        // ['0','0','0','0','0']
        // ]
        char[][] grid = new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(solution.numIslands(grid));
    }
}
