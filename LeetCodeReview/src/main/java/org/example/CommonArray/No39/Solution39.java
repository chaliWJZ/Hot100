package org.example.CommonArray.No39;

import java.util.*;
public class Solution39 {

    // --- 解法一 ---
// 组合的思路。。。回溯递归。。。一直向下递归 ↓ ，接着选择下一个元素
//  然后配合 for循环，就是 横向的，每次选择 起始的开始元素是哪个，
// 但是这道题有点特殊，，， 每个元素 都可以 "重复用" ！！！	

// 这道题是 给你的初始选择列表，里面的元素都是唯一的 。。所以不需要去重 ！！

	// 依旧的 两个全局变量 
     private List<List<Integer>> res = new ArrayList<>();// 存放最终结果集 res
    private List<Integer> temp = new ArrayList<>();// 用来存放 符合的单个路径答案

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
       		// 这里还要额外对sum =0赋值，以及 startIndex =0，因为是第一个元素下标从0开始
        backtracking(candidates, target, 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
		// 递归结束出口，这里的话是有2个了。。。。都必须写出来哦！！！
       
        if (sum == target) {		
            res.add(new ArrayList<>(temp));
            return;
        }
        
         if (sum > target) 
            return;

// 因为只在 一个 选择列表里面取，其实就是 []数组 candidates 里面的元素，里面慢慢选，是横向的 → 
        // 那么 就要用到startIndex, i = startIndex，每次 都向后选一个元素 。。
        for (int i = startIndex; i < candidates.length; i++) {

            sum += candidates[i];
            temp.add(candidates[i]);
            
     // 不用 传入i + 1 了。。。本题 和之前的题目不一样，表示可以 "重复"读取 当前的数，所以递归函数传入的是 i !!! 然后去下一层递归 ↓ 
            backtracking(candidates, target, sum, i);  

            // 撤销 操作
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }
}