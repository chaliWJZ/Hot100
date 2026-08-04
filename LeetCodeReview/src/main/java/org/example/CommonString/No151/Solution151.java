package org.example.CommonString.No151;

import java.util.*;
public class Solution151 {

    // --- 解法一 ---
// 先删除首位空格
// 再根据 空格进行分割 字符串，得到 String[] 数组 
// 从末尾遍历，反转字符串
// 通过 StringBuilder的apend()每次添加 字符串 
    
    public String reverseWords(String s) {
        							 
        // 1.先trim() 删除首尾空格，然后按照空格 " " 去分割字符串 split()
        // 这种情况 分割的话 ， 每个单词之间 的 空格个数 比较多，那么 如果 之间有 3个空格 ，   比如，"I am   happy"，会多会分割产生2个 空字符串["I","am","","","happy"]，所以采用" +"方式，就可以避免这样的问题 ！！！
	
        String[] strs = s.trim().split(" +"); 
        	
        // 用于存储最终的结果 res ，不断添加 append()
        StringBuilder res = new StringBuilder();
        
       // 2.“倒序”遍历单词列表，然后 再插入 。 那么 i的初始值 就是 length-1 。  这种方法很“特殊”！！
       // 从数组的 最后面 开始 遍历。。。
        for(int i = strs.length - 1; i >= 0; i--) { 
              
            res.append(strs[i] + " "); 
       
        }

        // 3. 为什么还要 删除尾部空格？因为 添加 最后一个单词 的时候 它还会多 添加一个 空格  
        return new String(res).trim();
    }
}