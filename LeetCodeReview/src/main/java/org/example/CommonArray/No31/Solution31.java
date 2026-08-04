package org.example.CommonArray.No31;

import java.util.*;
public class Solution31 {

    // --- 解法一 ---
/** 主要思路，

1.先找出最大下标 k 满足 nums[k] < nums[k+1]。如果不存在，就说明这个数组是降序，处于最大排列的状态，就翻转整个数组，也就是 得到 从小到大排序 的数组，也就是它的 下一个 排列数组。

2.再找出另一个最大下标 l 满足 nums[l] > nums[k]。
3.交换 nums[l] 和 nums[k]。
	为什么要这么做？？那是因为，当找到了 最大下标k满足nums[k] < nums[k+1]，那么k之后下标的 对应元素都是 降序的，所以我们需要在 k之后的这个小范围的 降序序列里面，找到一个稍微大于 nums[k]的元素nums[l] 满足 nums[l] > nums[k] 并且l下标是最大的，此时的nums[l] 是最接近的k的元素。然后和k对应的元素交换位置。

4.最后翻转 nums[k+1:]。
	为什么要这么做 ？？ 因为 当l和k交换完之后，显然 当前排列数组 并不是 下一个排列，因为k后面的元素仍然是 降序的，所以这时候 要对k后面的元素进行 升序，这样操作之后的数组，才是 下一个排列。。。
**/

    public void nextPermutation(int[] nums) {

        int k = -1;  // 最大下标k ，满足  nums[k] < nums[k + 1]
        int l = -1;  // 最大下标 l 满足 nums[l] > nums[k] 

        // 1. 倒序遍历, 找到第一个数, 这个数 比后面的数小，然后把它对应的 下标赋值给  k 
          // i = nums.length - 2 是为了防止下面nums[i + 1]越界!
        for (int i = nums.length - 2;i >= 0;i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }

      	// 这就说明for遍历之后，整个数组是 降序的，所以直接 reverse()翻转一下数组，返回就行。
        if (k == -1) {   
            reverse(nums,0,nums.length-1);
            return;
             
        }
        	  // 2. 继续倒序遍历, 找到一个上面的数大的数
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > nums[k]) {
                    l = j;
                    break;
                }
            }
           
            // 3. 交换i和j对应下标的 元素值
            swap(nums, k, l); 

        // 4. 将 k后面的数组元素 升序排列,也就是翻转一下。 
        reverse(nums, k + 1, nums.length - 1);
                
    }

    // 两两元素交换函数
  public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
	
    // 翻转数组，只需要 双向的双指针 交换就能实现。
    public void reverse(int[] nums, int left, int right) {
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}