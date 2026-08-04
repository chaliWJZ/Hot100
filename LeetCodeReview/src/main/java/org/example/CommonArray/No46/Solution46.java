package org.example.CommonArray.No46;

import java.util.*;
public class Solution46 {

    // --- 解法一 ---
// 又因为  {1,2} 和 {2,1}  都是  符合的答案，那么 for循环 横向遍历→ 时候，每一次都要从 i=0    开始遍历，可以 再去选取  前面上一个 的元素，那么就需要 used数组[]  √  记录此时的 temp 临时路径答案，里面 已经选了 哪些元素，如果该元素 用过了，就  不需要 再选它了， 防止 重复选取！！！   
//   所以就不需要 startIndex 参数了 ×   。。。。。

    	// 依旧的 两个全局变量，，，
    List<List<Integer>> result = new ArrayList<>();// 存放最终结果集
    List<Integer> temp = new ArrayList<>();// 用来存放单个符合答案

    public List<List<Integer>> permute(int[] nums) {
        
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

      // ‘特殊点’--->这里的for循环  i要从0开始了。因为 “排列” 问题，前面的元素也是可以选择的 
        for (int i = 0; i < nums.length; i++){
            
   //used数组[] 就是记录， 此时的temp 里已经选的元素，如果这个元素使用了，那么就跳过 continue，防止重复选取 。。。
            if (used[i]==true)		
                continue;
            
            used[i] = true;		// 选择的元素当然要标记一下true。
            temp.add(nums[i]);
            
            backtracking(nums,used);
            
             used[i] = false;
            temp.remove(temp.size()-1);
               
        }
    }
}