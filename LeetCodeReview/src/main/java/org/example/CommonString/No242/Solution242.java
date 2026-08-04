package org.example.CommonString.No242;

import java.util.*;
public class Solution242 {

    // --- 解法一 ---
// 如何判断 两个字符串 是不是  字母异位词 ？？？
// 首先就是 它们的长度是一样的。
// 其次就是，它们包含的 每个字符个数 都是一样的。。。

// 思路就是 先遍历 s字符串的字符 出现次数。。用 map 集合 去累加。。。然后 遍历 字符串t ，对之前的 map集合出现过的字符 响应的if判断操作 。。。。

   public  boolean isAnagram(String s, String t) {

        int len1 = s.length(), len2 = t.length();

   	//  这行必须加！！！  因为 你下面的这个 map计数的方法，以及里面的判断，必须是 长度相等才行
       // 其实也就是 ”剪枝“ 。。。。
        if (len1 != len2)
            return false;

			// 用于统计 字符串中的 每个字符 的出现次数 
        HashMap<Character, Integer> dic = new HashMap<>();

       // 上面的这个 for循环，先去统计 s字符串， 每个字符的出现次数
        for (int i = 0; i < len1; i++) {
				//  put() 和 getOrDefault()一起使用，更新累加
            dic.put(s.charAt(i) , dic.getOrDefault(s.charAt(i), 0) + 1);
        }

       	// 下面的这个 for循环，去遍历 t字符串的！！！！
        for (int i = 0; i < len2; i++) {
            
             // 如果 s字符串的这个字符，存在 之前的map集合，那么对 出现次数 -1 操作。。。
     // 并且内部还要if判断，此时的 出现次数 小于0 了吗，小于的话就说明 这两个字符串s和t 的字符出现次数不一致 。。。就不是 字母异位词 ！！return false 
            if (dic.containsKey(t.charAt(i))) {
                
                dic.put(t.charAt(i), dic.get(t.charAt(i)) - 1);
                if (dic.get(t.charAt(i)) < 0)
                    return false;
            }
            
            // 如果这个字符都不存在 字符串s中，那么直接 return  false;
            else
                return false;
        }

			// 其余情况，那么就是 字母异位词 。返回true 
        
        return true;
    }
}