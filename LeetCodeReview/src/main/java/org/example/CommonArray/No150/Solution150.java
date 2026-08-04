package org.example.CommonArray.No150;

import java.util.*;
public class Solution150 {

    // --- 解法一 ---
/**	
    1.逆波兰表达式求解,其实就是求 后缀表达式的 值。
    2.要用一个 辅助栈 来计算，利用它的 "先进后出"的 特性
        3.1 如果遍历到 运算符 "+"、"-"、"*"、"/"时,从栈中 pop() 弹出两个数字计算，并将计算结果
        3.2 那么剩下的情况就是，遍历到 数字字符，直接入栈 就行了。。。
**/

	public int evalRPN(String[] tokens) {
        	
        // 辅助栈
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++){
  
            // 这里 采用 if 、else if、 else 判断结构，很方便！！ 
            if (tokens[i].equals("+")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a + b);
            } else if (tokens[i].equals("-")) {
                
                	int a = stack.pop();
                    int b = stack.pop();
     	// !!!! 注意  ，- 减的 运算符 与 除/ 运算符 比较特殊，先出栈的元素 a 要作为 减数，后出栈的元素b要作为 被减数。  记得反一下 减法顺序
                    stack.push(b - a);
                
            } else if (tokens[i].equals("*")) {
                
                	int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a * b);
                
            } else if (tokens[i].equals("/")) {
                
             	    int a = stack.pop();
                    int b = stack.pop(); 
           // !!!! 注意  ，- 减的 运算符 与 除/ 运算符 比较特殊，先出栈的元素 a 要作为 减数，后出栈的元素b要作为 被减数。  记得反一下 减法顺序
                    stack.push(b / a);
            } 
            
     // 把其他的情况 	只含有算符 的字符串 	+-*/ 情况 先放在上面，那么剩下的 else 情况 就肯定  只剩下 数字 了，遇到数字 字符的话，就要入栈
            else {
                			// 因为是 "1"，他是个字符串，所以要调用这个方法进行转换
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return stack.pop();
        
    }
}