package org.example.CommonString.No394;

import java.util.*;
public class Solution394 {

    // --- 解法一 ---
// 因为这道题带了 括号，所以很大概率要使用 “栈” 来解决
// 用的是 两个“栈”来解决问题。

/** 
   一个是数字栈nums。用来 保存字符串s 中出现的数字字符 numStr，用于 倍数拼接字符串多少次。

   另一个是 字符串栈strs。用于保存 res 的结果字符串 
   
   当我们循环遍历 字符串s 的时候，每次遇到 '[' 的时候，就要把之前的 res结果字符串 入栈，以及 之前的数字 numStr 放入  数字栈，同时记得 给他们清零，因为 内部括号还会继续遇到 数字 和字符，嵌套！！！ 
    当 遇到 ']'，那么就是需要 for 循环 不断 append()拼接字符串了，然后 一直 更新 res结果字符串 
**/

    public String decodeString(String s) {

        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();

  // 因为  字符串中有多个数字字符 比如'1'、'2'，我们要采用拼接的方式，把它们拼接成 12。还要配合	Integer.parseInt(numStr)方法转成 int类型的数字 								
        String numStr = "";   
        
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            	
       // 对于 字符串中的 数字字符判断 就应该这么 写。
            if (ch >= '0' && ch <= '9') {
              	// 对于这样的 "123[ab]" 我是这样子把123取出来的，先保存在numStr字符串中
                 numStr+=ch;
            } 
            
       //如果是 小写字母的话，判断是这样写的。。这时候的话就是普通的 结果字符串res 的一直拼接字符
            else if (ch >= 'a' && ch <= 'z') {
                res += ch;
            }
            
 // 当遇到'[' 时！！就要把'['的之前的数字 num 压入nums栈内， 结果字符串 res 压入strs栈内  
            
 	// 记得要为 numStr 重置！！因为 每遇到一次'['的话，就要把'['的之前的数字 num 压入nums栈内。 有可能 '[' 内部还有 数字字符,又是新的了，所以必须重置numStr =""  。比如"abc100[20[a]]"
            
   // 记得也要为 res 重置！！因为 在遇到'[' 之后，还会遇到括号里面的小写字符，它们都是保存在res中   
            else if (ch == '[') { 
                			
                nums.push(Integer.parseInt(numStr));
                numStr="";
                             
                strs.push(res);
                res = "";    
            } 
            
            // 遇到']' 时，操作与之相配的‘[’之间的字符， res。
            else { 
                
                int times = nums.pop();
                StringBuilder temp = new StringBuilder(strs.pop());
                
                for (int j	 = 0; j < times; j++) {
                    
         // 因为 在遇到'[' 之后，还会遇到括号里面的小写字符，它们都是保存在res中。所以要 用 之前的保存在strs栈里面的 字符串 temp，再拼接上 倍数的 res
                    temp.append(res);
                }
                		// 还要将拼接好的 temp 赋值给 结果字符串 res。要为下一次循环做准备
                res = new String(temp); 
            }
        }
                        // 最周返回结果字符串 
        return res;
    }
}