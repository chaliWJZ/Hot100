package org.example.CommonArray.No73;

import java.util.*;
public class Solution73 {

    // --- 解法一 ---
// 主要思路，定义两个 set集合。
/**
	第一次遍历 矩阵的时候：
			rowZero集合，记录 用于存储包含零的 行下标 有哪些
			colZero集合，用于存储包含零的 列下标 有哪些
	第一次遍历 矩阵的时候：
			如果当前元素matrix[i][j] 所在的 行下标i 或 列下标 j，在 rowZero的set集合 或 colZero set集合 中，则将该行的 所有元素 置为零，或者 该列的下面所有元素 置为0
**/
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;  // 获取 矩阵的行数（其实就是个 二维数组[][]）
 		int col = matrix[0].length;  // 获取矩阵的列数。

        // 为什么要用 set集合？主要是为了“去重”。因为如果matrix[0][1] 和 matrix[0][2] 这两个元素都是0值，那么他们的行索引0 ，都会加入到 行set集合中，但只会保留1个 下标0行。。。
        Set<Integer> rowZero = new HashSet<>();  // 用于存储包含零的行下标的set集合
        Set<Integer> colZero = new HashSet<>();  // 用于存储包含零的列下标的set集合

     //第一遍遍历 ：找出所有是0的元素 matrix[i][j]，把他们对应的 行下标i 和 列下标j 记录下来，存入对应的 set集合
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    		// 两个 set 集合 要同时一起记录！！！ 
                    rowZero.add(i);  // 记录包含零的，行下标i 的set集合
                    colZero.add(j);  // 记录包含零的，列下标j 的set集合
                }
            }
        }

      // 第二遍遍历：再次遍历 二维矩阵，如果当前元素matrix[i][j]  所在的 行下标i 或 列下标 j，在 rowZero的set集合 或 colZero set集合 中，则将该行的 其他所有元素 置为零，或者 该列的下面所有元素 置为0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowZero.contains(i) || colZero.contains(j)) {
                    matrix[i][j] = 0; 
                }
            }
        }
    }
}