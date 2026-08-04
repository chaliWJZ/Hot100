package org.example.CommonArray.No4;

import java.util.*;
public class Solution4 {

    // --- 解法一 ---
// 1.先把 nums1 和 nums2 这两个数组 合并成 一个有序的数组 
// 2.然后再计算 中位数，就比较方便了 。。。。 
// 时间复杂度 是O(m+n)

      public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
      //1. 先合并 
        int m = nums1.length; // 第一个数组的长度
        int n = nums2.length; // 第二个数组的长度
        
        int[] newArr = new int[m + n]; // 创建第三个的数组，来存储合并后的有序数组
        
        int i = 0; // 第一个数组的 索引
        int j = 0; // 第二个数组的 索引
        int idx = 0; // 第三个的数组的 索引

   // 合并两个 nums1 和nums2 数组 ，这里的while循环条件是 i和j 遍历索引都小于自身长度，才循环
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                newArr[idx++] = nums1[i++]; // 将较小的数放入结果数组，并移动索引
            } else {
                newArr[idx++] = nums2[j++]; // 将较大的数放入结果数组，并移动索引
            }
        }
        	
        // 这里的话就说明跳出了第1个 while 循环，也就是 i或者j 遍历完了 自身数组
		
        // 如果第一个数组还有剩余元素，将它们添加到结果数组
        while (i < m) {
            newArr[idx++] = nums1[i++];
        }

        // 如果第二个数组还有剩余元素，将它们添加到结果数组
        while (j < n) {
            newArr[idx++] = nums2[j++];
        }

          //  2. 然后再 计算 中位数 。。
          
        int length = newArr.length; 

        // 如果 新数组的长度 是偶数，那么计算偶数长度数组的中位数，其实是 中间两个数的平均值
        if (length % 2 == 0) {
            return (double) (newArr[length/2] + newArr[length/2 -1])/2;
        }        
          
           // 如果新数组的长度是奇数， 返回中间的数作为中位数
      	else {
                return (double) newArr[length/2];
        }
    }
}