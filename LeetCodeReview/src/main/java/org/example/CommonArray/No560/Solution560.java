package org.example.CommonArray.No560;

import java.util.*;
public class Solution560 {

    // --- 解法一 ---
// 这道题可以结合 前缀和 + 再通过 哈希表的优化方式，达到 O(n) 时间复杂度。
	//  因为 前缀和数组，有这么一个特性：
	// 对于一个连续子数组 nums[i:j] (i 到 j 的区间，包含 i 和 j),它的和,等于前缀和 preSum[j] - preSum[i - 1] 的差值

/**  
 想要求出 和为k的子数组 的个数？！就可以通过遍历 前缀和数组preSum，使用哈希map 来记录 每一个前缀和 出现的次数。
 在依次向后遍历 的过程中，对于当前的前缀和 preSum[j]，我们去哈希map中查找，preSum[j] -k的差值 对应的 元素key，出现的次数value 就行。然后 个数count 一直累加。。。因为 它其实只会  在当前j下标 以前的那些前缀和里面找。。。所以不需要考虑 它可能会遍历到 哈希map 后面下标的 前缀和
	因为每出现一次 preSum[j] - k，就意味着 存在一个以当前位置j 为结尾的 子数组的和为 k

**/

    public static int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        
        // 创建 前缀和数组，长度为n + 1，长度多一个，方便后续计算
        // preSum[0] 的前缀和, 初始化为 0
        int[] preSum = new int[n + 1];

        // 计算 前缀和数组 preSum
        for (int i = 0; i < n; i++) {
       //计算当前的前缀和，就等于 前一个的前缀和，再加上当前遍历数组的元素值 nums[i]
            preSum[i + 1] = preSum[i] + nums[i];
        }
        
			// map哈希表, 统计每一个前缀和,出现的次数.
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        
        // 初始化前缀和为0，出现1次. 用于处理从索引0开始，就满足和为k的 那种 特殊情况
        sumCountMap.put(0, 1);
        
        int count = 0; // 统计,最终的个数
        
        for (int j = 1; j <= n; j++) {
            
       // 计算出 当前的前缀和preSum[j] - k 的差值. 然后去 哈希map 查询,找到对的value值,就是和为k的连续子数组 的个数了.
            int targetSum = preSum[j] - k;
            
            if (sumCountMap.containsKey(targetSum)) {
                count += sumCountMap.get(targetSum);
            }

            // 不论 存不存在target差值,都会 统计某个 前缀和 出现的次数,不断累加
            sumCountMap.put(preSum[j], sumCountMap.getOrDefault(preSum[j], 0) + 1);
        }
        
        return count;
    }
}