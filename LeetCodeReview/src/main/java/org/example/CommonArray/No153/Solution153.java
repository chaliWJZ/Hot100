package org.example.CommonArray.No153;

import java.util.*;
public class Solution153 {

    // --- 解法一 ---
// 这道题 也是 非完全有序的 ，也是左半段，右半段才有序 。
// 这道题是 搜索最小值min，并不是 搜索目标值 target，不需要 if(nums[mid]==target)语句....

    public int findMin(int[] nums) {
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {

          // 1.一直缩小 左、右区间。直到 left,right 的左右区间里面的数组 是 完全有序 的时候，那么nums[left]的值就是最小值 ！！
            if (nums[left] <= nums[right]) {
                return nums[left];
            }

           int mid = (left + right)/2;
            
           // 2.这里就是开始 缩小  左、右边界的 判断了。。。。

          //  2.1若 nums[left] <= nums[mid]，说明区间 [left,mid] 连续递增，则最小元素一定不在这个区间里，可以直接排除。因此，令 left = mid+1，在 [mid+1,right] 继续查找
            if (nums[left] <= nums[mid]) 
                left = mid + 1;

         // 2.2否则，说明区间 [left,mid] 不连续，则最小元素一定在这个区间里。因此，令 right = mid，在 [left,mid] 继续查找!!这里的话 right 必须赋值 mid，而不是mid-1。。因为 mid无法被排除!比如 说 mid指向的值可能就是 右边的最小值呢？所以 right 必须改成 mid ！！！
            else 
                right = mid;

        }
   
// 这个返回值实际上永远不会被触发，因为输入数组总是有一个最小值，所以只是为了 让  编译器通过而已。。        
        return -1; 
        
    }
}