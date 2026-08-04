package org.example.CommonArray.No494;

import java.util.*;
public class Solution494 {

    // --- 解法一 ---
/** 将数组(元素均正数)分成两个子集， left子集 和 right子集：

设数组的和为 sum，  left子集的和为 left，right子集的和为 right
根据上面的分析，我们可以得出： left + right = sum (1)
同时有： left - right = target (2)
将(1)式与(2)式相加，可以得到： 2left = sum + target (3)

即：left = (sum + target) / 2 ，因为sum就是整个数组的和 是固定的，target也是题目中给出来的，也是固定的，所以我们找到了 固定的值，作为01背包的固定容量。原问题 可以转化为--> 0-1背包问题：

每个物品(也就是数组中的元素)的重量为 nums[i]， 背包的容量 bigSize 为(sum + target) / 2，问：有多少种方式将背包【恰好填满】

**/

    public int findTargetSumWays(int[] nums, int target) {

		// 先求出 整个数组nums的 总和
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //  !!注意点1.   
      //   如果 target大于 sum，根据上述等式计算出来的 bigSize = (sum + target) / 2会大于sum，这在实际情况中是不合理的。因为 bigSize 是从数组nums中的元素组成的和，它如果 超过 数组元素总和sum，那么是 无解的
        if(sum < Math.abs(target)){
            return 0;
        }

           //  !!注意点 2. 
        //  如果所求的背包容量 bigSize 不是整除，结果是小数，那么 整数 数组的nums里的任何元素 自然是没有办法凑出这个小数的 
        if((sum + target) % 2 != 0) {
            return 0;
        }

        		// 01背包的 容量 
        int bigSize = (sum + target) / 2;
        
        // dp[i][j]：使用 下标为[0, i]的nums[i]能够凑满背包容量j，有dp[i][j]种方法。
        int[][] dp = new int[nums.length][bigSize + 1];

        // 初始化dp，第一行..
      // dp[0][0]的值，代表的是，对于 第0个物品，装满背包容量为0，就是不放它 ，那么 就有1种方法
        /**
           dp[0][j]：只放物品0， 把容量为j的背包填满有几种方法。
             只有当 背包容量为物品0 的容量 的时候，方法为1，正好装满。
            其他情况下，要不是 装不满，要不是装不下。
            所以初始化：dp[0][nums[0]] = 1 ，其他格子 均为 0  
**/
        if (nums[0] <= bigSize) {
            dp[0][nums[0]] = 1;
        }

        // 初始化dp数组的第一列
    // 当从nums数组[0,i]的部分有n个0时，每个0可以取+/-，因此有2^n种方法 可以放到背包容量 0
        // 所以这里 额外定义了个 numZeros，代表 0的数量。
        int numZeros = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);
        }

        // for循环遍历计算 顺序：从左到右→，从上到下↓
        // 当nums[i] > 背包容量j时，这时候nums[i]一定不能取，所以是dp[i - 1][j]种方案数
        
        // nums[i] <= j时，第i个数字 可放可不放：
        /**
        1.选择将第i个数字放入，此时，数字还剩i - 1个，背包的容量需要减去nums[i]。递推式为
dp[i][j] = dp[i - 1][j - nums[i]]；
		2.选择放弃第i个数字，背包的容量不变，直接从 [0,i-1]区间里面选择。递推式为dp[i - 1][j]
	**/
        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= bigSize; j++) {
                
                if(nums[i] > j) 
                    dp[i][j] = dp[i - 1][j];
                 else 
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                
            }
        }

        return dp[nums.length - 1][bigSize];
        
    }
}