package org.example.CommonArray.No695;

import java.util.*;
public class Solution695 {

    // --- 解法一 ---
// 其实 这道题目 可以把传入的 二维数组 [][]当作一个 图 结构。这道题采用 DFS 深度优先遍历的方式。 类似"二叉树"的遍历方式
//  那么以 dfs前序递归遍历 二叉树为例子，遍历的终止条件就是 ：当超过了 数组的下标越界，或者 遇到了格子的值为 海洋 0的情况 。

// 单层递归逻辑的话： 双重for循环，然后 外层是从第0行 开始遍历，内层for循环是从第0列开始遍历，每次都会调用一次 dfs()函数。在 dfs里面，都是以当前格子为起点遍历，上、下、左、右的 相邻4个格子。但是  相比于 "二叉树" 的话，这里还需要考虑 重复遍历格子的情况，所以 我们每次遍历完 一个陆地1 格子 之后，要给它修改为2(陆地格子已经遍历过)，下次不需要再遍历它了 ！！！
// 			那么 相比于 之前的话，我们的 终止条件就要改为，当超过了 数组下标越界，或者 遍历的格子不等于 1(未遍历过的陆地格子)。。

/** 
  		总体而言，当 双重for循环 遍历的起点是 1(未遍历过的陆地格子)，那么就要开始调用 dfs()函数了，递归函数内部，只要遍历一次，就说明找到一个陆地格子，岛屿的面积就要 +1。
  		然后 dfs()遍历完之后，就要和之前的 res最终的最大面积 更新比较。。。
  		当 双重for循环结束，把res 返回，就是最终答案。
**/

        public int maxAreaOfIsland(int[][] grid) {
                  int res = 0;
            for (int i = 0; i < grid.length; i ++) {
                for (int j = 0; j < grid[0].length; j ++) {

                    // 只有 遍历到 1(未遍历过的陆地格子)才能作为起点，调用 dfs()深度优先遍历。
                    if (grid[i][j] == 1) {

           //结果 dfs()之后，说明找到一个 岛屿，并且计算了 岛屿面积。要不断和res更新比较最大值
                        int area = dfs(grid, i, j);
                        res = Math.max(res,area);
                    }
                }
            }
            return res;
        }

        public int dfs(int[][] grid, int row, int col) {

       // 第一个 递归终止条件：当遍历的 行或者列的数，超过了数组的下标边界，就要 return返回了,面积就是 0
            if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0) {
                return 0;
            }

               // 第二个 递归终止条件：当遍历的 格子 不等于 1(未遍历过的陆地格子)，说明当前格子要么就是0，要么就是 2(已经遍历过的格子)，就要 return返回了，面积就是 0
            if (grid[row][col] != 1) {
                return 0;
            }

            // 因为要防止 重复遍历 陆地格子，所以要给 遍历过的陆地格子，改为 2。。
            grid[row][col] = 2;

        // 每次遍历一个 陆地格子，就要 岛屿的面积+1
            return 1 + dfs(grid, row - 1, col) //上面的格子
            + dfs(grid, row + 1, col) // 下面的格子
            + dfs(grid, row, col - 1) // 左面的格子
            + dfs(grid, row, col + 1); // 右面的格子
        }
}