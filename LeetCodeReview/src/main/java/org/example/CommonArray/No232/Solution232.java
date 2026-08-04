package org.example.CommonArray.No232;

import java.util.*;
public class Solution232 {


    // --- 解法一 ---
// 用栈 “先进后出”，实现队列“先进先出”的特性。那么就需要 用2个栈 来实现： 
	/** 
		一个栈，只 负责进栈in， 另一个栈，只 负责出栈out
	**/
	
//  主要就是实现下面的两个核心方法： 
              //  **队列的 pop()方法：从队头，移除并返回元素 
                // **队列的 peek()方法： 只是返回  队头的元素

class MyQueue {

    // 一个栈，只负责进栈in
    Stack<Integer> in;
    // 另一个栈，只负责出栈out
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    // push（）方法，只需要进栈in，调用栈的push（）
    public void push(int x) {
        in.push(x);
    }

    // 队列的pop()方法：从队头，移除并返回元素
    public int pop() {
        // 当调用队列的pop()弹出元素方法的时候
        // 如果out出栈为空，那么先要把in入栈中的元素全部放到out出栈
        // 然后再调用out出栈的pop()方法，弹出1个元素就行。
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.pop();
        }

        // 如果out出栈非空 ，那么就意味着之前已经调用过第一次队列的pop()方法了，已经把之前的in入栈里面的元素全部转移到out出栈中了，那么现在就直接调用out出栈的pop()方法就行
        else {
            return out.pop();
        }
    }

    // 队列的peek()方法：只是返回队头的元素
    public int peek() {
        // 其实这里的实现逻辑和pop()差不多的
        // 所以可以先调用上面实现好的队列pop()弹出元素的方法，然后再把那个弹出的值插入出栈out就行。
        int num = pop();
        out.push(num);
        return num;
    }

    // 队列的判空empty（）
    public boolean empty() {
        // 这里当然是两个栈都为空！！
        return in.isEmpty() && out.isEmpty();
    }
}
}