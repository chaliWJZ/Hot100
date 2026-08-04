package org.example.CommonArray.No77;

import java.util.*;
public class Solution77 {

    // --- 解法一 ---
// 组合的思路。。。回溯递归。。。一直向下递归 ↓ ，接着选择下一个元素
//  然后配合 for循环，就是 横向的，每次选择 起始的开始元素是哪个，
	
             // 基本上这两个都是这样定义好，在最外面。。。
    
            // 设置 全局列表List<List<...>> res 存储最后的所有结果
             // List<...> temp，代表每一个 到叶子节点的 临时路径答案 
    List<List<Integer>> res= new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
	
    			//自带的主函数 
    public List<List<Integer>> combine(int n, int k) {
        // 调用下面自定义的函数 ，这里传入的初始值 startIndex 是1，因为 n集合就是 从1开始的数字
      	// 这里的  startIndex 指的是，选择的第几个数字，比如1234，那么1就是1，	2就是2
        backtracking(n,k,1);
        
        return res;
    }

    public void backtracking(int n,int k,int startIndex){
				
        // 当到了  要找答案的长度的时候，也就是遇到了叶子节点，就要 保存到 最终结果 res 里面
        if(temp.size() == k){

		// 这里的话，有个小细节，所以必须是 new ArrayList<>(temp)传入temp，开辟一个新对象，
            //  如果是 直接res.add(temp), 那么 里面的 temp 临时答案就会一直变化。。。
            res.add(new ArrayList<>(temp));
            return;

        }
        
	// 选择列表，因为这里只有一个选择列表，其实就是 1,2,3,4 里面慢慢选，是横向的 → 
        // 那么就要用到startIndex， i = startIndex，每次 都向后选一个元素 。。
        for (int i =startIndex;i<=n;i++){ 
            
            // 单个 临时路径答案，不断添加元素，比如这里先选上 第一个元素，1
            temp.add(i);
            
     // 向下递归，纵向的 ↓，记得 i+1，也就是选择 第二个元素，2，那么此时的临时路径答案是 1，2 了
            backtracking(n,k,i+1);
            
         	// 撤销，移除临时路径 末尾的元素，比如 撤销 2，那么临时路径答案又只剩下1 了
            temp.remove(temp.size()-1);
        }
    }
}