package org.example.CommonArray.No78;

import java.util.*;
public class Solution78 {

    // --- 解法一 ---
// 这道题的话，是 求子集问题。所以 使用回溯递归的时候， 是对 遍历的 每一个树的节点 添加到 res结果集里面。。而不是 遍历到 叶子节点 才加入res结果集中。。
//     

    	// 依旧的 两个全局变量，，，
    List<List<Integer>> result = new ArrayList<>();// 存放最终结果集
    List<Integer> temp = new ArrayList<>();// 用来存放单个符合答案
    
    public List<List<Integer>> subsets(int[] nums) {
        
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex){
				 // “特殊” 就在这里   ！！！ 。。。。
        	//遍历这个树的时候，把 “所有节点” 都记录下来，就是要求的 所有子集
      result.add(new ArrayList<>(temp));
        
        		// 所以不是在 终止条件里面写，res.add()了！！！--->这个只对 叶子节点 
        if (startIndex >= nums.length)  // 递归出口
            return;

        for (int i = startIndex; i < nums.length; i++){
            
            temp.add(nums[i]);
            
            backtracking(nums, i + 1);
            
            temp.remove(temp.size()-1);
            
        }
    }
}