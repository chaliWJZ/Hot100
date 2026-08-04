package org.example.CommonArray.No59;

import java.util.*;
public class Solution59 {

    // --- 解法一 ---
/** 填充上行从左到右→
    填充右列从上到下↓
    填充下行从右到左←
    填充左列从下到上↑
    由外向内一圈一圈这么画下去。
 
**/
// 先定义 当前 左右 、上下边界 
// while最外层的循环 必须是 小于<= 终止值 target  ...

public int[][] generateMatrix(int n) {
	
       int[][] res = new int[n][n];
  			 //  先定义 当前 左右 、上下边界
        int left = 0, right = n-1, top = 0, bottom = n-1;
    			
          // num 用来给 matrix矩阵的每一个空格 赋值，迭代终止值 target，也就是 n的平方
        int num = 1, target = n * n;

       // 使用num <= tar，而不是l < r || t < b作为迭代条件。。。
    // 主要是为了解决当 n为奇数时，是为了解决当 n为奇数时，矩阵中心数字 无法在迭代过程中 被填充
    
        while(num <= target){
            
            //从左到右填充，相当于缩小上边界 top
            for(int j = left; j <= right; j++) 
            {
                res[top][j] = num++;
            }
            //top 缩小上边界
            top++;
            
            //从上向下填充，相当于缩小右边界 right
            for(int i = top; i <=bottom; i++) 
            {
                res[i][right] = num++;
            }
            //缩小右边界 right
            right--;
            
            //从右向左填充，相当于缩小下边界 bottom 
            for(int j = right; j >= left; j--) 
            {
                res[bottom][j] = num++;
            }
            //缩小下边界 bottom
            bottom--;
            
            //从下向上填充，相当于缩小左边界 left 
            for(int i = bottom; i >= top; i--) 
            {
                res[i][left] = num++;
            }
            //缩小左边界 left
            left++;
            
        }
    
                    return res;
}
}