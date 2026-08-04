package org.example.CommonString.No131;

import java.util.*;
public class Solution131 {

    // --- 解法一 ---
//  使用 回溯递归 的方法。
// 要定义一个 startIndex 参数，这里是作为 字符串的切割点，不过注意的是，要获取 其中的回文子串，需要从[startIndex,i] 这个下标区间 去获取。当它属于 回文子串的时候，那么才需要不断向下 回溯递归，去查找
// 所以，这道题还要在下面 定义一个，判断 是不是回文串的子函数 。

    private List<List<String>> res = new ArrayList<>();
    private List<String> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        					
        				// 这里的  startIndex 就是切割线，初始化是0 
        					// 比如说 "abc" ，startIndex=0 的话，就是 "a|bc"
        backtracking(s, 0);
        return res;
        
    }

    public void backtracking(String s, int startIndex) {
        
  // 如果切割线 startIndex 的起始位置已经大于等于 s 的长度，说明已经找到 一组分割方案了，递归出口
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            			
            // 通过[startIndex,i]区间，就能获取在 s 中的子串。
       // 调用下面自定义的 判断回文串函数 isPalindrome()，只有判断是 回文串的话才能回溯递归!!!
            if (isPalindrome(s, startIndex, i)) {  
						// 因为要获取 回文子串，只能通过 substring()方法，所以 i+1才能获取。
                String str = s.substring(startIndex, i + 1);
                temp.add(str);
                
                backtracking(s, i + 1); //因为不能重复切割！所以寻找 i+1 为起始位置的子串，
                temp.remove(temp.size() - 1); // 回溯过程，弹出本次已经添加的 回文子串
            }

        }
    }
				
    			// 判断回文串的函数，这个比较简单。
    public boolean isPalindrome(String s, int start, int end) {  
        for (int i = start, j = end; i < j; i++, j--) {
				 if (s.charAt(i)!= s.charAt(j)) 
                return false;
        }
        
        return true;
    }
}