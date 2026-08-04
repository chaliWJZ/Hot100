package org.example.CommonArray.No225;

import java.util.*;
public class Solution225 {


    // --- 解法一 ---
// 用 1 个 队列 其实 就可以实现了 栈的特性"先进后出"。
// 使用 “双端” 队列。最主要还是实现这个  pop()弹出元素，这个方法 ** 
class MyStack {
    
				// 声明 1 个 “双端”队列 Deque
        Deque<Integer> queue;

        public MyStack() {

            queue = new ArrayDeque<>();

        }

    		// 调用 deque双端队列的这个方法，就是从队尾插入。
        public void push(int x) {
					
            queue.offerLast(x);
        }
    
    	// ** 主要就是要去实现 "栈”的弹出元素 pop() 方法，要满足“先进后出”
    // 要把 目前 双端队列中的，前size-1个 元素，按序出队，然后重新 插入到 队尾
           // 然后再调用1次 pollFirst() 方法就行了。因为此时队头的元素，就是 当时最后添加的元素
    						// 也就是 满足 “先进后出”
        public int pop() {
	
            int size = queue.size();
          
			
            while (--size >0)
            {	
     //   一个队列在模拟栈弹出元素的时候只要将  队列头部的元素（除了最后一个元素外） 重新添加到队列尾部 ，此时再去弹出元素就是	栈的 出栈顺序了---》“先进后出”
                queue.offerLast(queue.pollFirst());
            }

            return queue.pollFirst();

        }

        public int top() {
			
            return queue.peekLast();
        }

        public boolean empty() {
         
            return queue.isEmpty();
        }
}
}