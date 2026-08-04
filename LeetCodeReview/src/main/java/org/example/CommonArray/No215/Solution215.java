package org.example.CommonArray.No215;

import java.util.*;
public class Solution215 {

    // --- 解法一 ---
// 使用 快速排序(变形) ---> "快速选择" 排序算法。

/** 主要思路：

a.主要就是以 快排(升序)为基础，核心的就是 划分分区函数 partition()方法。不过这里比较特殊， pivot中枢值选择 (left+right)/2，主要是为了防止 数组中出现大量重复元素时候，选择pivot中枢值造成的排序时间浪费。 最后返回中枢值的最终下标，也就是左右分区的下标值 pivotIndex
b. 此时，得到 pivotIndex 之后，要和 k值比较。因为 k是 有序数组中第k个大的元素。比如数组长度 n，下标是0~n-1，所以 第1个大的元素，它的下标值是 n-1 ，其实下标公式就是 数组长度n-k  。
所以只需要比较 pivotIndex中枢值下标 和 n-k的大小：
	如果等于，那就直接返回。
	如果小于，说明 第k个大的 在 右分区，所以 ”递归“ 右分区
	如果大于，说明 第k个大的 在 左分区，所以 “递归” 左分区
**/

	//  用于查找第k个最大元素
    public int findKthLargest(int[] nums, int k) {
							
        return quickSelect(nums, 0, nums.length - 1, k);
        
    }

    // 快速选择的 核心函数 ！！！
    public int quickSelect(int[] nums, int left, int right, int k) {
        
        int pivotIndex = partition(nums, left, right);
        
        if (pivotIndex == nums.length - k) {
            return nums[pivotIndex];
        } 
        
        else if (pivotIndex < nums.length - k) {
            return quickSelect(nums, pivotIndex + 1, right, k);
        } 
        
        else {
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
        
    }

   // partition() 分区划分函数，以 (left + right) / 2的下标元素作为基准值 进行划分。和以前的 一直以左边第一个元素作为 基准值pivot不太一样。
    // 主要是为了防止 数组中出现重复元素情况下的 无效选择 基准值pivot ！！导致的时间复杂度太高。。
public int partition(int[] nums, int left, int right) {
   
    int pivotIndex = (left + right) / 2;
    	// 这里是选择 pivotIndex 还要和 left 最左边的第一个元素 交换一下位置
    	// 因为 排序流程是固定的，一个 左指针，一个右指针 
    int temp = nums[pivotIndex];
    nums[pivotIndex] = nums[left];
    nums[left] = temp;

    int pivot = nums[left];
   
        while (left < right) {
      // right 指针 从右向左←，当元素大于 pivot的时候，指针一直左移。如果找小于 pivot 的值之后，，记得把它放到 left指针下标位置
            while (left < right && nums[right] >= pivot) 
                right--;
            
            nums[left] = nums[right];

  // left 指针 从左向→，当元素小于 pivot的时候，指针一直右移。如果找大于 pivot 的值之后，记得把它放到 right 指针下标位置
            while (left < right && nums[left] <= pivot) 
                left++;
            
            nums[right] = nums[left];
        }
        
        			// 此时把 pivot基准元素 放在 两个指针相遇的下标位置
        nums[left] = pivot;

        return left; // 返回基准值pivot的 最终索引下标
}
}