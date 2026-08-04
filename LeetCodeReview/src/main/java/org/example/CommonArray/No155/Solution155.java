package org.example.CommonArray.No155;

import java.util.*;
public class Solution155 {


    // --- 解法一 ---
// 也是需要 两个栈，来实现 “最小栈”
// 主栈main ---》 存储所有元素的栈 ，每次添加一个元素的时候，就直接里面 无脑添加 就行  
// 最小栈min ---》  存储当前最小元素的栈。它的栈顶！！的元素 永远是 最小的那个元素 ，所以每次添加元素的时候，都要 和栈顶元素比较，如果比 栈顶元素 小，那么才把它加入 栈顶。

class MinStack {

    private Stack<Integer> main; 
    private Stack<Integer> min; 

    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
         
   // 将元素x压入 主栈main，这个是正常的入栈。每次都要 调用  主栈main的 push()
        main.push(x);
        
    // 当元素x 插入主栈main之后。还需要判断比较一下！！！是否要进入  min最小栈 ！！
 // 如果 min最小栈 为空，也就是第一次往 main主栈加入元素的时候，那么无需判断，直接将x压入最小栈
        if(min.isEmpty()) {
            min.push(x);
        }

        
       // 如果 min最小栈 非空
        else {
            
      // 那么就要查看当前 min最小栈的 栈顶！！元素，因为只在它的栈顶保存的就是 最小值
            int top = min.peek(); 
            // 只有当 x 小于等于最小栈的栈顶元素top， 才将x压入最小栈。
            // 这样才能保证 min最小栈的 栈顶！！元素 一直是最小的元素。
            if (x <= top) {
                min.push(x);
            }
        }
        
    
    }

    public void pop() {
        
        // 从 main主栈中 弹出栈顶元素，这个是正常的出栈。
        int pop = main.pop();
        
		// min最小栈只需要调用peek()查看方法，查看当前最小栈的栈顶元素
        int top = min.peek(); 
        
 // 只有当 main主栈 弹出的元素 等于 min最小栈的 栈顶元素。这时候 才从 min最小栈中弹出它的栈顶元素
        if (pop == top) {
            min.pop();
        }
    }

    
    
    
    
    public int top() {
        return main.peek(); // 返回 main主栈的 栈顶元素，这个方法 很普通
    }

    public int getMin() {
        return min.peek(); // 返回 min最小栈的  栈顶!!!元素，即当前最小值。这个是关键 ！！
    }
}
}