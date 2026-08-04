package org.example.CommonArray.No239;

import java.util.*;
public class Solution239 {

    // --- 解法一 ---
// 这道题用 双端队列  + 单调队列来实现，使用的是 单调递减队列↓ (队头-队尾，递减)(队头永远是最大值)

// 这道题，主要是遍历数组新元素的时候，要和 队尾的元素比较，如果是小于等于的话，那么直接插入就行 。如果 新元素比 队尾元素大，就要把 队尾元素弹出来，直接弹，直到新元素遇到了 比它大的，才把它插入队列。

//  双端队列里面 保存的是 元素的下标！！而不是元素值。。。 因为每次遍历的时候，已经形成 定长窗口k，其实 直接从 队头取值(单调递减队列↓，所以它永远是最大值) 作为答案就行。。。但是 还要 判断队头的值是否在窗口范围k 之内。。。所以保存数组下标，可以很方便知道 队头元素在不在 范围里。。。同时下标取值也很方便。  

    public int[] maxSlidingWindow(int[] nums, int k) {

        // 保存每个窗口的最大值，用list集合来保存
        List<Integer> res = new ArrayList<>();
			
        // 队列一般用的就是 “双端”队列 Deque ！！！因为它可以 一端又 入队 和 出队
        Deque<Integer> queue = new ArrayDeque<>();

        // 1.遍历数组中元素，right 表示 滑动窗口的 右边界 
        for(int right = 0; right < nums.length; right++) {

            // 如果队列不为空，并且 当前遍历的新元素 大于等于 >= 队尾元素，则将队尾元素移除
            // 又因为可能会满足多次 出队，所以用 while 循环。。。
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) 
                queue.pollLast();
           		            
    //如果 队列为空 或者 当前遍历的新元素  小于  新的队尾元素的时候，才插入，存储元素下标
            queue.offerLast(right);

   // 2.当前遍历的新元素  添加之后 ，都要重新 计算滑动窗口的左边界left。。
            int left = right - k +1;
            
            // 当队头元素(当前窗口的最大值) 的下标，小于 滑动窗口的左边界left时
            // 表示队头元素 已经不在 滑动窗口内 ！！因此将其从队头移除
            if (queue.peekFirst() < left)
                queue.pollFirst();

  // 3.因此当 滑动窗口右边界 right+1 大于等于 窗口大小k时，意味着 定长k的 滑动窗口，已经形成
      // 并且 队头元素在  滑动窗口内！！
            //  此时 队首元素 就是该窗口内的 最大值，直接当作答案，保存一下就行。
            
            if (right +1 >= k) {
                res.add(nums[queue.peekFirst()]);
            }
        }

        // 把最终的结果list 集合 要 转换为  int[] 数组 ！！
        int[] arr_res = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
             arr_res[i] = res.get(i);
        }

        return arr_res;
    }
}