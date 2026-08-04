package org.example.CommonArray.No416;

import java.util.*;
public class Solution416 {

    // --- 解法一 ---
// 01背包来做，动态规划dp ，这里选用的是 二维dp数组
//  这道题目是要找 是否可以 将这个数组分割成  两个子集，使得两个子集的元素和相等。
// 那么只要找到数组里能够出现 sum/2 的子集总和，就说明 该数组可以分割成两个子集 元素和相等了。sum是这个数组的总和。

// 但是注意 ！！！ sum必须是偶数，也就是整个数组的所有元素之和 必须是 偶数，才会找到答案 。。

/**
	 这里就假设，背包的容量为 sum/2 作为 bigSize，
     背包要放入的物体重量为 元素的数值，这里的 价值 概念是有点模糊的。。。
      背包如果正好装满，说明找到了总和为 sum / 2 的子集。
      背包中每一个元素是不可重复放入。
**/

    public boolean canPartition(int[] nums) {

		// sum先累加 nums数组的总和，然后记得 sum/2 作为 01背包的容量 bigSize。
        int sum = 0;
        
        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        
        // ”剪枝”，特殊判断，如果是奇数，那么就没有 两个子集的和 相等  的说法，就不符合 题目要求
        if ((sum %2 ) != 0) {
            return false;
        }

        // 目标 01背包容量
        int bigSize = sum / 2; 
        
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        /*
      dp[i][j]，表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，是否可以 使得这些数的和恰好等于 j ，用boolean来表示
        */
        boolean[][] dp = new boolean[nums.length][bigSize + 1];

        //  初始化 dp数组 ，对于第一列的话，就是指dp[i][0],当 bigSize=0的时候，其实 又因为 nums数组里面，每一个数都是正数，那么 是不可能选取一些数，它们的和 等于 0 的。。。所以它们的格子false
        
 //初始化 dp数组 ，对于第一行的话，只从0 到 0区间的元素选取，其实就是 选这一个 nums[0] 元素。
  // 只有当 第一个物品的重量 (nums元素值)小于等于 目标容量bigSize，那么就让 容积为它自己的背包  恰好装满， 设置为 true
        if (nums[0] <= bigSize) {
            dp[0][nums[0]] = true;
        }
        
		// dp循环计算 遍历顺序，从左到右→，从上到下↓
        //外层for遍历 物品，这里就是 每一个 数组nums[i]的元素
        for (int i = 1; i < nums.length; i++) {
            //内层for遍历  背包，就是 bigSize， 总和的一半 sum/2
            for (int j = 0; j <= bigSize; j++) {
                 
   // 如果如果物品i的重量 大于 背包的容量j，就说明肯定不能把它放入背包。。只能沿用 上一层的也就是[0, i-1] 这个子区间的元素，dp值
                if(nums[i]>j)
                	dp[i][j] = dp[i - 1][j];

                //如果如果物品i的重量 恰好就等于 背包的容量j，那么也是满足条件的，就设置true
                else if (nums[i] == j) 
                    dp[i][j] = true;

                //如果物品i的重量 小于背包的容量j，那就可以看该物品 是否放入 背包 ：
     //如果该物品i 不放入背包，如果在 [0, i-1] 这个子区间内已经有一部分元素，使得它们的和为j，那么就是 dp[i-1][j]=true
                
    // 如果该物品放入背包，如果在 [0, i-1] 这个子区间内已经找到一部分元素，使得它们的和为j-nums[i]。 那么就是 dp[i - 1][j - nums[i]]，为true
                //  这两种情况，求个 或 || 
                else if  (nums[i] < j) 
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                
            }
        }

        return dp[nums.length-1][bigSize];

    }
}