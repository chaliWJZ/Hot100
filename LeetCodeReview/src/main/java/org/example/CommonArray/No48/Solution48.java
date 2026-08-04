package org.example.CommonArray.No48;

import java.util.*;
public class Solution48 {

    // --- 解法一 ---
// 上下翻转方式(翻转一整行)+ 正对角线翻转(对称的单个元素，交换) ===》就也是“原地”翻转
    
    public void rotate(int[][] matrix) {
        
        int n = matrix.length; // 记录 二维数据[][]的行数 n
        
        // 上下翻转：也就是 先把第0行 和 第n-1行 元素，整个翻转交换一下。
        // 然后依次 遍历中间行，不断翻转
        for (int i = 0; i < n / 2; i ++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
        
        // 按照 正对角对角线 翻转：对称的单个元素，交换
       //  内部的 j 要设置成 i+1 。
        for (int i = 0; i < n; i ++){
            for (int j= i + 1; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}