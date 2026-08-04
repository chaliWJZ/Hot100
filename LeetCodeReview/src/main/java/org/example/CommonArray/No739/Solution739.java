package org.example.CommonArray.No739;

import java.util.*;
public class Solution739 {

    // --- 解法一 ---
// 这道题的话是 找右边的第一个比 当前元素大(栈顶元素)的 元素---->所以用的是 单调递增栈↑(我这里是 栈顶-栈底，递增)
// 单调递增栈↑，用于保存遍历过的数组元素。。这里保存的是 数组元素的下标i，而不是元素值nums[i]，这样方便计算，下标的差值(隔了多少天) ！！！！！！！！！

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> st = new Stack<>();
           
        int size = temperatures.length;

   // 用于保存最终的答案结果，也就是每个元素的 第一个比它大的元素值，它们之前下标的差值(隔了多少天)
        int[] result = new int[size];

        // 因为栈保存的是 元素的下标i。所以 先保存数组的第一个元素的下标值0
        st.push(0);
        
        // 然后for循环要从下标1 开始遍历，而且是从 左到右遍历→
        for (int i = 1; i < size; i++) {

            //当前遍历的元素 小于< 栈顶元素，就直接插入 当前元素的下标值i
            if (temperatures[i] < temperatures[st.peek()])  
                st.push(i);
             //  当前遍历的元素 == 栈顶元素，也是直接插入 当前元素的下标值
            else if (temperatures[i] == temperatures[st.peek()])  
                st.push(i);

  // 当前遍历的数组元素temperatures[i] 大于> 栈顶元素temperatures[st.peek()]，就说明此时已经找到  右边第一个 比栈顶元素大的 元素 ， 也就是当前遍历的数组元素temperatures[i] 
         //  那么就要执行 弹栈 pop()的操作，以及 记录答案 res了 ！！！ 内部是while，因为要继续和栈里面的已有元素比较，如果还是 大于＞，说明又找到答案了。。。
            else {

    // 里面的这个while循环的终止条件是两个！！！因为是维护的单调递增栈↑，所以 要把 栈中 比当前遍历元素temperatures[i] 小的，都弹出去！！！
    //直到 当前遍历的数组元素temperatures[i]遇到了 比它大的 栈内元素，才结束while循环
                while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) { 

         //不同的题目，主要就是这里的 判断写法不同。。。这里是 计算下标值的 差值(相隔天数)
                    result[st.peek()] = i - st.peek();

                     //弹出栈顶元素。。。这个是必须要有的代码！！
                    st.pop();
                }

         // 当上面的while循环终止了，也就是直到新元素遇到了 栈里比它 大的元素，此时 才把新元素的下标值插入 单调栈。！！！
                st.push(i);
            }
        }

        return result;

    }
}