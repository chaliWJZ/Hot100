package org.example.CommonArray.No11;

import java.util.*;
public class Solution11 {

    // --- 解法一 ---
// 把数组中的每一个元素值，当作一块板。。。。。此时左右边界 有两块板。。。。

/** 
	若向内 移动短板 ，水槽的短板 min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大↑；
 	若向内 移动长板 ，水槽的短板 不变或变小，因此下个水槽的面积 一定变小↓ 。
因为  长板先不动，每次都移动 短板，向中间 移动一个位置，遍历里面的 元素， 就可能会找到 水槽的面积最大值-----》  也就是  “贪心”的思想 

**/

// 因此，初始化双指针，分别指向 数组 左、右两端，每次循环，都将 短板 向内移动一格，并更新面积最大值，直到两指针相遇时跳出，即可获得最大面积。。

    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        
        int res = 0;

        while(left < right) {
            
                  // 进行条件判断 
        if (height[left] < height[right]) {

            // 计算面积：(右指针 - 左指针) * 左指针对应高度
            // 每次都要更新res  为当前最大面积
            res = Math.max(res, (right - left) * height[left]);
            left++; // 左指针向右移动(向内)

        } 
            // 如果height[left]大于或等于height[right]  
            else {

            // 计算面积：(右指针 - 左指针) * 右指针对应高度
            // 每次也要更新res  为当前最大面积 
        	res = Math.max(res, (right - left) * height[right]);
            right--; // 右指针向左移动(向内)

        }

        }
        
        return res;
        
    }
}