package org.example.CommonString.No76;

import java.util.*;
public class Solution76 {

    // --- 解法一 ---
//  采用 “滑动窗口”的思路
// 先要对 遍历字符串 t，先初始化 每个字符的 出现次数，通过 map 实现
//  然后才是 对字符串s 进行"滑动窗口"，添加元素，减少元素。。-->这里就是对 map的 value值-1和 +1

/**主要就是 如何 判断 当前“窗口” 扫描到的 子串 已经包含 字符串t ？？？？
  
  循环遍历整个map的key ，通过 判断 map 所有的 value<=0 了，这样才说明包含了 字符串t，找到一个 子串。
 
**/  

public String minWindow(String s, String t) { 

    Map<Character, Integer> map = new HashMap<>();
    
    // 1. 遍历字符串 t，先初始化 每个字符的 出现次数。
    // 这里主要是为了 之后的 right 右指针扫描 s 字符串的时候，不断“添加”元素进去，所以 每次扫描到一个字符，如果存在于 map，就得 出现次数 -1 。。。
    // 这主要是  为了判断 S 扫描的子串， 是否包含的 字符串t 
    for (int i = 0; i < t.length(); i++) {
        char char_i = t.charAt(i);
        map.put(char_i, map.getOrDefault(char_i, 0) + 1);
    }
    
     // 滑动窗口的 左、右指针
            int left = 0;
            int right = 0;

        // 为什么这道题要定义这个 ans_ 版本 的 左、右边界？因为 这道题是 找最小子串 进行返回。  题目  要求 返回一个 字符串String ，知道 边界的话，比较好返回。

            int ans_left = 0; //保存最小子串 的左边界
            int ans_right = -1; //保存最小子串 的右边界 ,这里很奇怪，为什么是 -1 ?
    //子串的右边界初始化为-1，是因为我们在 找不到 符合的子串 时候，要返回 空字符串 "" 。恰好在返回substring(0,-1+1)， 什么都没截取到（0,0）就是一个空字符串 ""

    int ans_len = Integer.MAX_VALUE; //当前最小窗口的长度，需要不断地更新比较，重新赋值。所以初始化成  整数 的最大值。
    
    //2.遍历字符串 s，“滑动窗口”的 模板 。。每次记得要去调用下面的 match()判断，扫描的子串 是否已经包含 字符串t了。
    while (right < s.length()) {
        
		// 特殊的地方！！！！
   //这里对 right 右指针扫描，“添加”元素的操作--> 其实就是对 每个字符的 value出现 减去 1  。
        // 要先 if判断 map 中是否 包含 当前字符 !!! 只有 包含 的情况下，才能执行 -1操作 ！！ 
        if (map.containsKey(s.charAt(right))) {
			
            map.put(s.charAt(right), map.get(s.charAt(right)) - 1);  

         // 这里的话，if 的内部，都要立即 进行 while()的循环判断
     // 也就是 调用 下面定义的次函数 match() 判断，是否  已经“全部包含” ，看看有没有  已经全部  包含 所有t字符串的字母
        //如果当前窗口的子串包含了 所有字母，就进入循环
        //开始移动 左指针left ，减小窗口
    
            while (match(map)) { 
               
       // 这道题的话，就必须这样更新和 比较 最小值 ans_len ，而不是Math.min()！！！
    // 因为只有 得到更小的 ans_len 时候，我们才要对 ans_的左、右边界 进行更新！！！
                if (right-left+1 < ans_len) {
                    ans_left = left;
                    ans_right = right;
                    ans_len = right-left+1;
                }

            // 接下来就是滑动窗口 左指针left 向右边移动，执行“移除”操作     
         //判断 map 中是否有当前字母,有的话，才能进行 “移除”，所以这里的 if判断 是 必要的！！！
                
                if(map.containsKey(s.charAt(left))) {
   // 因为要把当前字母“移除”-->所有相应次数要加 1 。这个 加1 就是和之前的右指针的操作  “反”一下
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                }

                left++; // 左指针left 右移
            }
        }

        //右指针右移，扩大窗口
        right++;
    }

        return s.substring(ans_left, ans_right+1);
    
}

    // 3.下面定义一个  函数 ---> 这主要是  为了判断 滑动窗口内的字符串， 是否包含的 字符串t 
// 通过 判断 map 所有的 value<=0 了，这样才说明包含了 字符串t，找到一个 子串。
private boolean match(Map<Character, Integer> map) {
    for (Integer value : map.values()) {
        if (value > 0) {
            return false;
        }
    }
    return true;
}
}