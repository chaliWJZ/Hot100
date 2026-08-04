package org.example.CommonArray.No40;

import java.util.*;
public class Solution40 {

    // --- 解法一 ---
// 组合的思路。。。回溯递归。。。一直向下递归 ↓ ，接着选择下一个元素
//  然后配合 for循环，就是 横向的，每次选择 起始的开始元素是哪个，

// 这道题的要求 和 之前的 组合总和的原始题目不一样。。。有两点不太一样！！！
/**
1. 这道题，要求，求出来的最终答案 res ，也就是那么多个 单个路径答案，必须不重复！！！ 但是 给你的初始选择列表，里面的元素有可能"重复"的。。比如 1,2,3,7,-1,2,1 。。所以需要去重 ！！这里引入used[]数组来去重。。。我没采用 最终 转为 hashset 的方式 把结果集 去重。。。。

2. 而且 单个路径答案里面，每个元素只能用1次  ！！！
**/
    
    	// 依旧的 两个全局变量，，，
   private List<List<Integer>> res = new ArrayList<>(); // 存放最终结果集
    private List<Integer> temp = new ArrayList<>(); // 用来存放单个符合答案

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        // 首先对 candidates 数组[]进行排序！！！方便后面 使用 used[] "去重" ！！！
        Arrays.sort(candidates);
        
        boolean[] used = new boolean[candidates.length];
        
            	// 这里还要额外对sum =0赋值 
       // 并且这里还额外传入了个 used[]数组，为了方便“去重”。哪些元素已经用，没用过 
               //  最核心的当时是  startIndex =0，因为是第一个元素下标从0开始
        backtracking(candidates, target, 0, 0, used);
        return res;
        
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] used) {

        // 多个 递归出口！！
        if (sum == target) {

            res.add(new ArrayList<>(temp));
            return;
        }
        
         if (sum >target) 
            return;
        
        		// 因为只在 一个选择列表里面取，那么就是要采用 startIndex。。i= startIndex
        for (int i = startIndex; i < candidates.length; i++) {
            	
            // used[i - 1] == true，说明同一树枝(纵向↓)，前面相邻的相同元素 使用过
            // used[i - 1] == false，说明同一"树层"(横向→)，前面相邻的相同元素 使用过
            
    // 排序之后的话，在for循环 横向→取元素的时候， 当发现  candidates[]中的i 和 i-1下标的元素相等的时候。。就需要去重了。。。但是还需要配合 used[]数组!!!那么如何判断呢？？？     
   // 要对同一"树层" 去重！！所以是 判断userd[i-1] == false！！说明 前面相邻的相同元素 使用过，
// 所以代码里面是 continue 跳过 它！！
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) 
                      continue;   
            
            sum += candidates[i];
            temp.add(candidates[i]);
            used[i] = true;  // 多了这条代码 

            backtracking(candidates, target, sum, i + 1, used); 
            used[i] = false; // 多了这条代码  
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }
}