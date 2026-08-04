package org.example.CommonArray.No88;

import java.util.*;
public class Solution88 {

    // --- 解法一 ---
/**

主要思想：
  因为 题目要求 合并后的元素，都是存放在 nums1数组。它的长度是 m+n ，所以 nums1数组的空间都集中在后面，所以 ← 从后向前，分别比较 nums1和nums2的末尾元素的大小，一边遍历一边将 较大值 填充进nums1。
  
  设置指针 p1 和 p2 分别指向 nums1 和 nums2 的数组尾部，从他们的 尾部值 开始遍历比较。
  同时设置  指针p 指向 nums1数组 的末尾。
  
  当 nums1[p1]>nums2[p2] , 那么 p下标对应的元素 也就是 nums1[p] = nums1[p1],然后p1--
  否则的话，就是 nums1[p] = nums1[p2],然后p2--
  每次 比较结束之后，就需要 p--
  
  当 p1<0 时遍历结束，此时 nums2 中还有数据未拷贝完全，将其直接拷贝到 nums1 的前面，最后得到最终结果
  		
**/

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // 定义三个指针，p1 指向 nums1 有效元素的末尾，p2 指向 nums2 的末尾
        // p 指向 合并后的 数组nums1的末尾
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

     // ←从后往前 遍历 两个数组 nums1和nums2，比较 当前元素的大小，将较大值放入 nums1 的末尾
        while (p1 >= 0 && p2 >= 0) {
            
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
              
            }
            
            else {
                nums1[p] = nums2[p2--];
               
            }
            
            p--;
            
        }

        // 如果 nums2 中还有剩余元素，将其复制到 nums1 的前面
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
           
        }
        
        // 为什么  只需要 考虑 nums1遍历完了，nums2 没遍历完的情况 ？？？
        // 因为 num1遍历完了，说明 剩下的nums2都是 比nums1的最小值都小的元素了，直接按序插入就行。
        
   // 然后还有 一种情况 就是，nums2遍历完了， nums1没有遍历完。也就是 nums2的 较大值都插入完了，那么 剩下的nums1的元素就是 最小值了，它原本就是 存在nums1里面，就不需要额外再去考虑 复制它们了。
    }
}