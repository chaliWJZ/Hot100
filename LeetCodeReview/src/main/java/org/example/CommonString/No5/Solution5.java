package org.example.CommonString.No5;

import java.util.*;
public class Solution5 {

    // --- 解法一 ---
// 采用「中心扩散法」, for 循环遍历 每一个下标，以这个下标为中心，利用「回文串」中心对称的特点，往两边扩散 left 和 right ，看最多能扩散多远。。
   //  所以 对于 一个长度为n 的字符串，我们可以用它的 任意一个字符 当做 --->中心点，所以中心点的个数是n
   /** 找出来的所有回文子串 就是只有下面两种情况 ：
  	一种是回文子串长度 为奇数（如aba，中心是b）
	另一种回文子串长度 为偶数（如abba，中心是b，b）
**/

    public String longestPalindrome(String s) {
       	
  		// 求最大长度的时候，一般都是把 maxlen 初始化成 整数最小值
   // 因为这里需要返回 子串，所以需要知道 子串的最左边界下标 ！！！所以定义了 start=0
         int start = 0, maxLen = Integer.MIN_VALUE;
        
        for (int i = 0; i < s.length(); i++) {
            
            // 这两种情况都要进行计算的,为了找的回文子串，全一点！！！就是调用两次 find()
            
            //  以单字符为中心扩散，找出来的 回文子串长度是-->奇数
            int len1 = find(s, i, i);
            //以两个字符中间为中心扩散   回文子串长度是-->偶数
            int len2 = find(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            
             if (len > maxLen) {
                maxLen = len;		
                 
          // 此时的 最左侧边界的下标如何 更新 ？？？ 因为此时的 i指向的是 回文子串的中心点下标，那么其实 此时的 该回文子串的长度是 maxlen。。要算出 这个 回文子串的最左侧下标的话.。。
                 // 就必须先算出来 maxlen要先减去-1再除以2 的值，，然后 用 i减去 它 就能算出最左侧下标，赋值给 start
                start = i - (maxLen - 1)/2;	
               
            }
        }

       // 知道最大子串的左边界起始位置，加上最大长度，就可以返回 最长的回文子串了
        return s.substring(start, start + maxLen);
        
    }

    private int find(String s, int left, int right) {
        
     while (left >= 0 && right <=s.length()-1 && s.charAt(left) == s.charAt(right)) 	{
            left--;
            right++;
        }
        						
         // 注意此处 right,left 的值循环完后  是恰好不满足循环条件的时刻
         // 所以求出来的 最大回文子串的长度，是 right-left-1 
// 比如 "aba",那么此时 跳出循环结束的时候，left= -1，right = 3 。求出来的长度 是 3-(-1)-1= 3
// 下标: 012
        return right - left - 1;
    }
}