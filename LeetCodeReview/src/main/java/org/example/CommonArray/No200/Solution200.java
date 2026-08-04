package org.example.CommonArray.No200;

import java.util.*;
public class Solution200 {

    // --- 解法一 ---
// 其实 这道题目 可以把传入的 二维数组 [][]当作一个 图 结构。这道题采用 DFS 深度优先遍历的方式。 类似"二叉树"的遍历方式
//  那么以 dfs前序递归遍历 二叉树为例子，遍历的终止条件就是 ：当超过了 数组的下标越界，或者 遇到了格子的值为 海洋 '0'的情况 。

// 单层递归逻辑的话： 双重for循环，然后 外层是从第0行 开始遍历，内层for循环是从第0列开始遍历，每次都会调用一次 dfs()函数。在 dfs里面，都是以当前格子为起点遍历，上、下、左、右的 相邻4个格子。但是  相比于 "二叉树" 的话，这里还需要考虑 重复遍历格子的情况，所以 我们每次遍历完 一个陆地'1'格子 之后，要给它修改为'2'(陆地格子已经遍历过)，下次不需要再遍历它了 ！！！
// 			那么 相比于 之前的话，我们的 终止条件就要改为，当超过了 数组下标越界，或者 遍历的格子不等于 '1'(未遍历过的陆地格子)。。

/** 
  		总体而言，当 双重for循环 遍历的起点是 '1'(未遍历过的陆地格子)，那么就要开始调用 dfs()函数了，当它结束完之后，记得 岛屿数量res++。说明已经找到一个岛屿了。
  		当 双重for循环结束，把res 返回，就是最终答案。
**/

    public int numIslands(char[][] grid) {
       		  int res = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                
                // 只有 遍历到 '1'(未遍历过的陆地格子)才能作为起点，调用 dfs()深度优先遍历。
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    //结果 dfs()之后，说明找到一个 岛屿。res要++
                    res ++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int row, int col) {
        
        // 第一个 递归终止条件 ：当遍历的 行或者列的数，超过了数组的下标边界，就要 return返回了。
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0) {
            return;
        }

           // 第二个 递归终止条件 ：当遍历的 格子 不等于 '1'(未遍历过的陆地格子)，说明当前格子要么就是'0'，要么就是 '2'(已经遍历过的格子)，就要 return返回了。
        if (grid[row][col] != '1') {
            return;
        }
		
        // 因为要防止 重复遍历 陆地格子，所以要给 遍历过的陆地格子，改为 '2'。。
        grid[row][col] = '2';
        
        dfs(grid, row - 1, col); //上面的格子
        dfs(grid, row + 1, col); // 下面的格子
        dfs(grid, row, col - 1); // 左面的格子
        dfs(grid, row, col + 1); // 右面的格子
    }
}