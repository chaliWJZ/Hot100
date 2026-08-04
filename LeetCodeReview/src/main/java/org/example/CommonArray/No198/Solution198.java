package org.example.CommonArray.No198;

import java.util.*;
public class Solution198 {

    // --- 解法一 ---
//  使用dp动态规划来做。。主要是用 一维dp数组[] 

	public int rob(int[] nums) {
        
	// 这里是"剪枝“，如果长度为 0 那么小偷能偷的就只有  0 金额。
        // 如果 长度为 1，那么小偷能偷的 就只有 第一个房间的 金额
        if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];

   // dp[i] 是指，考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为 dp[i] 
		int[] dp = new int[nums.length];
        
        // 初始化dp数组。
		dp[0] = nums[0];// dp[0] 一定是 nums[0]
		dp[1] = Math.max(nums[0], nums[1]);// dp[1] 肯定是 nums[0]和nunms[1] 中的最大值 

        // for循环遍历计算 的顺序 。依赖前面的状态，所以是 从前往后→。
		for (int i = 2; i < nums.length; i++) {
            
           /** 
     如果偷第i房间，那么dp[i] = dp[i - 2] + nums[i]，因为题目规定 相邻的第i-1 房间 一定是不能偷的，找出 下标i-2（包括i-2）以内的房屋，最多可以偷窃的金额为dp[i-2] 加上第i房间偷到的钱。

	如果不偷第i房间，那么dp[i] = dp[i - 1]，也就是只偷 第i-1房间 

	然后dp[i]取这两个情况的最大值就行。。。
				**/
            
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}

		return dp[nums.length - 1];
        
	}
}