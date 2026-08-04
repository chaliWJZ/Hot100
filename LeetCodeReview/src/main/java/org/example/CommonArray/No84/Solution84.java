package org.example.CommonArray.No84;

import java.util.*;
public class Solution84 {

    // --- 解法一 ---
// 1、这道题 ，其实就是 找左边的第一个小的元素 和 右边第一个小的元素，比较最小值，然后计算高和宽，就能计算面积了 -->所以用的是 单调递增减↓(我这里是 栈顶-栈底，递减)
    // 递增栈，用于保存遍历过的数组元素。。这里保存的是 元素的下标！！而不是元素值。。。方便后续计算

    //2、这道题，有点特殊，因为如果 原始的 height数组是 [1,2,3,5] 递增，会有问题，比如 入栈了 也不会 计算面积  ;以及原始的 height数组是 [5,4,3,2,1] 递减，也会有问题，因为 每次弹栈的时候，会少左侧的元素，也导致不计算面积！！  --->所以要 对初始的height 数组 首尾加 0元素！

            public int largestRectangleArea(int[] heights) {

            Stack<Integer> st = new Stack<>();

        // 对原来数组扩容，返回一个新数组newHeights。在头和尾各加入一个元素 0 ！！！这个很关键！！！
            int [] newHeights = new int[heights.length + 2];
            newHeights[0] = 0;
            newHeights[newHeights.length - 1] = 0;

                 // 把原来数组，要原封不动的一一复制到 新数组中。
            for (int i = 0; i < heights.length; i++){
                newHeights[i + 1] = heights[i];
            }

            int newsize = newHeights.length;

     // result变量 用于保存最终的答案结果，也就是 对于数组中的每一个nums[i]，看它能形成的矩阵面积，需要不断比较更新的
            int result= 0;

            // 因为先保存数组的第一个元素的下标值，所以就是0
            st.push(0);

            // 所以for循环要从左到右遍历→
            for (int i = 1; i < newsize; i++) {

            //因为这道题是递减栈↓ ，所以当前遍历的元素 大于＞ 栈顶元素，就直接插入 当前元素的下标值
                if (newHeights[i] > newHeights[st.peek()])  
                    st.push(i);
                 //  当前遍历的元素 == 栈顶元素，就直接插入 当前元素的下标值
                else if (newHeights[i] == newHeights[st.peek()])  
                    st.push(i);

                   // 当前遍历的数组元素newHeights[i] 小于＜ 栈顶元素newHeights[st.peek()]，就说明此时已经找到  右边第一个 比栈顶元素小的 元素 ， 也就是当前遍历的数组元素newHeights[i] 
             //  那么就要执行 弹栈 pop()的操作，以及 记录答案 res了 ！！！ 内部是while，因为要继续和栈里面的已有元素比较，如果还是 小于＜，说明又找到答案了。。。
                else {

          // 里面的这个while循环的终止条件是两个！！！因为是维护的单调递增栈↑，所以 要把 栈中 比当前遍历元素newHeights[i] 大的，都弹出去！！！
        //直到 当前遍历的数组元素newHeights[i]遇到了 比它小的 栈内元素，才结束while循环
                    while (!st.isEmpty() && newHeights[i] < newHeights[st.peek()]) { 

         //主要逻辑，不同的题目，主要就是这里的写法不同。。这里是计算，数组中的每一个newHeights[i]，能形成的矩形面积，这个值需要不断和前面的面积result 比较，得出最大值 !!

            // 这里比较”特殊“，要先把！！！栈顶元素 弹出来！！然后保留 栈顶元素 作为中间值mid 。。。那么 剩下的栈顶元素 就是 之前的栈顶元素的 左边第一个比它小的元素。。。同时 在上面我们也找到了比 之前栈顶元素 右边第一个小的元素(当前遍历的数组元素)。。。接下来就只需要判断，高宽，计算面积了
                        int mid = st.pop();

      // 这里仍要先 if判断一下栈是否空，因为 每个newHeights[i]要有左侧和右侧，才能计算面积！！一定要记得！！
                         if (!st.empty()) {

                      // 这里只需要计算宽w 就可以了 
                        int left = st.peek();
                        int right = i;
                        int w = right - left - 1; // 注意减一，只求中间宽度
                        
 //然后 高h的话，就是 当前mid下标对应的元素值。其实，就是画个图，它向右边横向扩展一个自己柱子，计算面积
                        int h = newHeights[mid];   
                        
                             // 和之前的 最大柱子面积，不断比较更新。
                        result = Math.max(result, w * h);

                        }

                    }

             // 当上面的while循环终止了，也就是直到新元素遇到了比它 小的元素，此时 才加入新遍历的元素的下标值。。。这个是必须要有的代码！！
                    st.push(i);
                }
            }

            return result;

        }
}