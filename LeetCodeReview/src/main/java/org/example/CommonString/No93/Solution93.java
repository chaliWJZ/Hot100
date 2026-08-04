package org.example.CommonString.No93;

import java.util.*;
public class Solution93 {

    // --- 解法一 ---
//  这道题要用 回溯递归 来解决。
//   也要定义一个 startIndex 参数，作为每一次的 字符串的 切割点。  [startIndex,i] 这个区间就是截取的子串，需要判断  这个子串数字 是否符合ip地址的 规范。
//  然后还要定义一个 pointNum 参数，作为每一次符合分割 加入一个 点号.  用于递归出口的结束。因为 只要有了3个点. 就说明已经分割完毕了，正常的ip地址 就是 3个 点. 
//  注意！！每次当达到 3个点. 之后，还要在 递归出口里面判断，剩下的的 第四个数字 是否符合 ip规范 ！！只有 if判断为true 的情况下，才会把某个ip子串 加入到 res结果集中 。

    private List<String> result = new ArrayList<>(); // 记录结果
	
      public List<String> restoreIpAddresses(String s) {
        		
          	// 这里的  startIndex 就是切割线，初始化是0 
        				// 比如说 "11123" ，startIndex=0 的话，就是 "1|1123"
          
          // 这里还要传入一个 pointNum 参数，代表往原始字符串s 添加的 点号. 数量，主要作为递归出口的判断
        backtracking(s, 0, 0);
          
        return result;
          
    }
   
    public void backtracking(String s, int startIndex, int pointNum) {
        
        // 点号 数量为 3 时，分隔结束，递归出口。说明已经分成了四个字串了，已经是 ip地址格式
        if (pointNum == 3) {
            
            //  这行代码很关键！！！
            // 还需要再判断 第四段 ！！！ 剩下的子串是否合法，如果合法就放进 result 中
            if (isValid(s, startIndex, s.length() - 1)) {
                	// 这里的话比较特殊，因为String 类型是不可变的，所以这里直接加 s就可以，	
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            
                  // 通过 [startIndex,i] 这个区间，就能获取到 s的子串，然后判断 是否合法	
            if (isValid(s, startIndex, i)) { 
                	
          // 注意！！！这里的话，对于符合 需要对 原始字符串 s 每次都更新 ！！添加 点号.  	                                和之前的那种temp.add()不太一样 ！！！！
                
    //在原始字符串s 的i下标对应 的后面，插入一个逗点，主要通过substring(),注入传入的下标！！
		   // 其实还是很好理解的，先要截取 i之前的 所有字符串s ，然后加上 点号.  然后再拼接上 i 下标到剩下的 length()-1 的截取字符串s  
                s = s.substring(0, i + 1) + "." + s.substring(i + 1); 
                pointNum++;
                
                backtracking(s, i + 2, pointNum); //插入点号. 后 ！！因为原始字符串s 多了个字符串，所以下一个子串的起始位置为 i + 2 。。这点也很特殊 ！！																			
                pointNum--;         // 回溯，点号数量 -1
                s = s.substring(0, i + 1) + s.substring(i + 2);    // 回溯删掉点号.  ，这里记得 后面的截取 s字符串，也要从 i+2 开始，毕竟有之前的点号 .
            
            }

        }
        
    }

    // 判断字符串 s 在  左闭右闭区间[start, end] 所组成的数字是否合法
    public boolean isValid(String s, int start, int end) {
        
        if (start > end) {
            return false;
        }
        
        if (s.charAt(start) == '0' && start!= end) { // 1、开头是0 的数字不合法
            return false;
        }

        int num = 0;
        						// 因为是闭区间，所以要 <=
        for (int i = start; i <= end; i++) {
            
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 2、遇到非数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 3、如果大于 255 了不合法
                return false;
            }
            
        }
        	
        return true;
   
    }
}