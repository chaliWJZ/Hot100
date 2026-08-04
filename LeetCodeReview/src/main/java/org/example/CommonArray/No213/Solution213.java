package org.example.CommonArray.No213;

import java.util.*;
public class Solution213 {

    // --- 解法一 ---
/**
       	
       这道题 II ，房间环形排列 意味着 第一间 和 最后一间 不能同时选择，所以我们可以分成两种情况来讨论：
       	1、不偷窃最后一间房间，那么问题转化为 偷窃下标0 到 最后 length-2 末尾房间 所能获得的最高金额。
		2、不偷窃第一间房间，那么问题转化为 偷窃下标1 到 length-1 号房间 所能获得的最高金额。
		
		两种情况中取最大值，这样我们就把 环形问题 转化为了 两个单排列的 子问题。    
  
**/

    public int rob(int[] nums) {
        
  		// 这里是"剪枝“，如果长度为 0 那么小偷能偷的就只有  0 金额。
        // 如果 长度为 1，那么小偷能偷的 就只有 第一个房间的 金额
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

   // copyOfRange() 方法，传入 nums数组下标范围的 新数组，可以直接调用下面的 打家劫舍I的代码
        	// 这个方法是不包括 右边界的。。。
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), 
                        myRob(Arrays.copyOfRange(nums, 1, nums.length)));
        
    }

    // 就是打家劫舍 I 的代码，作为了 次函数，方便 上面主函数 去调用。。。
    public int myRob(int[] nums) {
        
 // 主要是为了防止主函数传入的数组，长度为 0 或者 1，导致后面的初始化，dp[0],dp[1] 下标越界
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