package org.example.CommonString.No22;

import java.util.*;
public class Solution22 {

    // --- 解法一 ---
/**首先我们需要知道一个结论，一个合法的 括号序列：
	1、左右括号,数量相等  都等于 n 括号对数。比如 n是3 ，那么 左括号和右括号的数量都是3 个
	2、左括号数量 >= 右括号数量
**/

// 如果 左括号数量 小于 n，我们就可以放一个 左括号(，来等待一个右括号来匹配 。当 左括号数量等于n的时候，此时如果 (右括号数量 小于 左括号的数量，我们就可以放一个右括号，来使一个右括号和一个左括号相匹配

// 这里采用  dfs回溯递归的方式，构建一颗 二叉树，来匹配 左右括号。

    				//全局变量，最终的结果集 res
    static List<String> res = new ArrayList<String>();  

    public List<String> generateParenthesis(int n) {
        
        	// 1.初始时定义序列的左括号数量lc 和右括号数量rc都为0 。这里是加法 。
	// 这里的话，把保存临时的 单个答案作为参数 String，不断递归更新了，是 值传递 的形式，下一层的变化对 上一层 是没有影响的 
        
        backtracking(n, 0, 0, "");
        return res;
        
    }
    
    public void backtracking(int n ,int left, int right ,String str)
    {
      			//  2 左括号和 右括号的数量都等于 n ，将当前合法序列str加入结果集 res中。
        if( left == n && right == n) { //递归出口 
            
            	// 因为 String 是不可变的，所以直接加入就行。
             res.add(str);   
             return;
        }

        // 3.如果 左括号的个数小于n，则在当前序列str后拼接左括号--->来等待一个 右括号来匹配
        if(left < n) 
            backtracking(n, left + 1, right, str + "(");         
        		
    //4. 如果 右括号的个数小于左括号的个数，则在当前序列str后拼接右括号。-->来使一个右括号和一个  左括号相匹配		---> 切记！！当然 right也必须小于 n ！！！！
        if(right<left && right < n ) 
            backtracking(n, left, right + 1, str + ")");  	 
        
    }
}