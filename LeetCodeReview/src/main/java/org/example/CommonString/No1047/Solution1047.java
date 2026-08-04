package org.example.CommonString.No1047;

import java.util.*;
public class Solution1047 {

    // --- 解法一 ---
//  用“栈”
// 一直往里面添加元素，但是每次添加的时候，都要判断，如果 和 栈顶元素不相等的话，那么 该字符才入栈，如果  相等，那么就 把栈顶元素 弹出去。

public String removeDuplicates(String S) {

    Stack<Character> stack = new Stack<>();
    
    for (int i = 0; i < S.length(); i++) {
        
        char ch = S.charAt(i);
        
            // 如果栈为空的话，那么也就是说第一次开始判断字符串，那么就要用isEmpty()判空，入栈
        if (stack.isEmpty()) {
            stack.push(ch);
        } 
        
// 如果栈不为空，那么就要对 里面的 "栈顶" 的元素进行判断,只是判断 不需要 弹出栈，所以调用peek()
        else
        {   

 // 如果 "栈顶" 元素和 要添加的相邻字符不重复，也就是不相等，那么就要把这个 字符 入栈。 
            if(stack.peek()!=ch)
                stack.push(ch);
// 否则的话，就是 字符 相等 的情况，就只需要 pop()出栈即可。
            else
                stack.pop();
        }

    }

    // 声明 StringBuffer 去接收 出栈的 的 字符 ，并添加到字符串里 
    StringBuffer res = new StringBuffer();

//因为 最后的栈中 剩余的元素，即为 不重复的元素,通过 一个while循环依次 出栈，加入res 中 
       
    while (!stack.isEmpty()) {
        // 调用 StringBuffer 的append()方法，不断加入
       res.append(stack.pop());
        
    }
     
    // 只不过 添加之后的 字符串 与想要的 结果 是相反的，所以调用reverse()方法 倒序一下就行。 
    return new String(res.reverse());
}
}