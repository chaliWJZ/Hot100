package org.example.CommonString.No32;

import java.util.*;
public class Solution32 {

    // --- 解法一 ---
/** 
对于这种括号匹配问题，一般都是使用 "栈"。
我们先找到所有可以匹配的索引号，然后找出最长连续数列！

例如：s =")(()())"，我们用栈可以找到，
		 0123456
位置 2 和位置 3 匹配，

位置 4 和位置 5 匹配，

位置 1 和位置 6 匹配，

这个数组为：2,3,4,5,1,6 这是通过 栈 找到的，我们 按递增排序 ---> 1,2,3,4,5,6

找出该数组的 最长连续数列(但是这里必须是紧挨着的，而且都是必须 后一个数字比 前一个数字大1)
的长度 就是最长有效括号长度！

**/

    public int longestValidParentheses(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // 用于存储合法括号对的索引
        List<Integer> res = new ArrayList<>();
        
        // 辅助栈，存储左括号的索引
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            // 如果当前字符是左括号，将其索引压入栈
            if (s.charAt(i) == '(') 
                stack.push(i);

            // 如果 栈不为空 且 当前字符是右括号
            if (!stack.isEmpty() && s.charAt(i) == ')') {
                // 弹出栈顶左括号索引，并将当前右括号索引加入结果列表
                // 表示找到了一个合法的括号对
                res.add(stack.pop());
                res.add(i);
            }
            
        }
        
        // 然后对 res结果集合中的 下标索引 进行排序
        Collections.sort(res);
        int ans = 0;
        int n = res.size();
       
        for (int i = 0; i < n; i++) {
            int j = i;
            // 查找连续的索引区间，必须是 相邻元素，而且是递增+1的那种才行 。
            while (j < n - 1 && res.get(j + 1) == res.get(j) + 1) {
                j++;
                
            }
            // 更新最长合法括号子串的长度
            ans = Math.max(ans, j - i + 1);
          
        }
        return ans;
    }
}