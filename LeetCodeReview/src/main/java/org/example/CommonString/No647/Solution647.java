package org.example.CommonString.No647;

import java.util.*;
public class Solution647 {

    // --- 解法一 ---
// 采用 "中心扩散" 的方法。。。。去找有多少个 回文子串，统计个数 
// 就是 从某个字符 作为中心点，然后有两个指针，从中心点分别向left 和 right 扩散移动，每次移动，  如果发现它们指向的 字符 是相等的，就说明找到了一个 回文子串。。。。

//  所以 对于 一个长度为n 的字符串，我们可以用它的 任意一个字符 当做 --->中心点，所以中心点的个数是n

    // 回文串的数量,当作全局变量，这样子的话，在下面的 次函数find()里面也可以直接更新了。
		int count = 0;

	public int countSubstrings(String s) {
   		
            for (int i = 0; i < s.length(); i++) {
                
 // 这里面的话，每次for循环的时候，是调用两次find()，而不是 只选择某一种if情况，主要是为了找全所有的回文子串， 因为 它们是 奇数长度 或 偶数 长度 ！！
                
   //那么就是 传入 i,i，找出来的回文子串长度就是 奇数。也就是 初始化的时候，指向的中心点 是一个字符，然后左右扩散
                find(s, i, i);
      //传入 i,i+1，找出来的回文子串是长度就是偶数。也就是 初始化的时候，指向的中心点 是两个字符，然后左右扩散
                find(s, i, i + 1);
                
            }
   				 return count;
}

	//	对于一个长度为n的字符串，我们可以用它的任意一个字符当做中心点，所以中心点的个数是n		
	public void find(String s, int left, int right) {
    
        while (left >= 0 && right <=s.length()-1&& s.charAt(left) == s.charAt(right)) 		{
                            left--;
                            right++;
                            count++;
         }
	}
}