package org.example.CommonArray.No47;

import java.util.*;
public class Solution47 {

    // --- 解法一 ---
// 这道题目，相对于 46题的 原始 “全排列”题目的话，就是 nums数组中存在 重复的元素，所以要去重 ！！    // 其实就是 多加了两行代码

    	// 依旧的 两个全局变量，，，
    List<List<Integer>> result = new ArrayList<>();// 存放最终结果集
    List<Integer> temp = new ArrayList<>();// 用来存放单个符合答案

    public List<List<Integer>> permuteUnique(int[] nums) {
        
            // 首先对 nums 数组进行排序。方便后面 去重 ！！
        Arrays.sort(nums);
        
	// ‘特殊点’--->"排列" 的题目的话，就是要传入一个 used []数组 √ !! 而不是 startIndex 了 ×
     // used数组[]，主要是 标记单个答案temp里面，我们选过 哪些元素，使用过的元素我们也不再选了  
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return result;
        
    }

    private void backtracking(int[] nums,boolean[] used){
        
        	// 递归出口 还是很容易想到的，就是 每个单个答案的长度 和 原数组的长度一样就停止了
        if (temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

      // ‘特殊点’--->这里的 i要从0开始了。因为 “排列” 问题，前面的元素也是可以选择的 
        for (int i = 0; i < nums.length; i++){
            
             // used[i - 1] == true，说明同一树枝 nums[i - 1]使用过
            // used[i - 1] == false，说明同一"树层"  nums[i - 1]使用过
            
    // 我们去重主要是，同一"树层"的去重 。 所以只需判断 used[i - 1]==false，使用过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) 
                continue;

   //used数组[] 就是记录， 此时的temp 里已经选的元素，如果这个元素使用了，那么就跳过 continue，防止重复选取 。。。 
            if (used[i]==true)		
                continue;
            
            used[i] = true;		// 选择的元素当然要标记一下。
            temp.add(nums[i]);
            
            backtracking(nums,used);
            
            used[i] = false;
            temp.remove(temp.size()-1);
               
        }
    }
}