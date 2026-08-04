package org.example.CommonArray.No54;

import java.util.*;
public class Solution54 {

    // --- 解法一 ---
//通过左右边界，上下边界，一步步循环，从左到右遍历 →，从上到下遍历 ↓，从右到左遍历 ←，从下到上遍历↑
// 然后 每次都要判断一下 左右边界、上下边界 是否 == ，这时候就要跳出while循环了。。

    public List<Integer> spiralOrder(int[][] matrix) {
        
        // 创建一个空列表来存储螺旋遍历的结果
        List<Integer> arr = new ArrayList<>();
        
        // 初始化边界指针
        int left = 0, right = matrix[0].length - 1; // 左右边界
        int top = 0, down = matrix.length - 1;      // 上下边界
        
        // 开始螺旋遍历
   //这里的话就是先用一个 死循环 while(true)，然后配合 一些if条件 进行 break 跳出死循环，就行。
        while (true) {

            // 从左到右遍历并将元素添加到结果列表
            for (int i = left; i <= right; i++) {
                arr.add(matrix[top][i]);
            }
            top++; // 上边界 top 向下移动一行
            if (top > down) 
                break;    // 如果 上下边界 相遇，则退出循环 break

            // 从上到下遍历并将元素添加到结果列表
            for (int i = top; i <= down; i++) {
                arr.add(matrix[i][right]);
            }
            right--; // 右边界right 向左移动一列
            if (left > right) 
                break; // 如果左右边界相遇，则退出循环 break
            
            	// 从上到下遍历的话	和下面的从下到上 一样，if 条件都是 left > right 
            
            // 从右到左遍历并将元素添加到结果列表
            for (int i = right; i >= left; i--) {
                arr.add(matrix[down][i]);
            }
            down--; // 下边界down 向上移动一行
            if (top > down) 
                break; // 如果上下边界相遇，则退出循环 break

            // 从下到上遍历并将元素添加到结果列表
            for (int i = down; i >= top; i--) {
                arr.add(matrix[i][left]);
            }
            left++; // 左边界向右移动一列
            if (left > right) 
                break; // 如果左右边界相遇，则退出循环
        
        }
        
                    // 返回 螺旋遍历的 结果列表集合arr
                    return arr;
    }
}