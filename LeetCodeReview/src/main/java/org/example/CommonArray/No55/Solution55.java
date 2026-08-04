package org.example.CommonArray.No55;

import java.util.*;
public class Solution55 {

    // --- 解法一 ---
// 大致思路.
/**
 
如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
如果可以一直跳到最后，就成功了
	贪心的思想，局部最优，到 全局最优

**/
   public boolean canJump(int[] nums) {
        
        // k 代表 前n-1个元素能够跳到的最远距离
        int k = 0;
       
        for (int i = 0; i <= k; i++) {
            
            //第i个格子 能够跳到的最远距离
            int temp = i + nums[i];
            //更新最远距离 k 
            k = Math.max(k, temp);
            //如果最远距离k 已经大于或等于最后一个元素的下标,则说明能 跳过去,退出，减少for循环
            if (k >= nums.length - 1) {
                return true;
            }
        }
       
  // for循环遍历完之后，也没有执行上面的 return true，就说明最远距离k 跳不出去，所以 返回false
        return false;
    }
}