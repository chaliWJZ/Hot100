package org.example.CommonArray.No718;

import java.util.*;
public class Solution718 {

    // --- 解法一 ---
// 子数组是 “连续”的 ，所以相对简单点~~~~
// 采用动态规划来做。很明显是两个数组，要采用 二维dp[][]

    public int findLength(int[] nums1, int[] nums2) {
        
        		//这里定义就是 按照两个数组的长度，定义 dp 二维数组 
     //dp[i][j]是指，表示在nums1中以下标 i 为结尾，nums2中以下标 j 为结尾的最长重复子数组长度是dp[i][j] 	
        	int m = nums1.length;
        	int n = nums2.length;
     		int[][] dp =new int[m][n];
        
     		int max=Integer.MIN_VALUE;  //  这里同样是需要不断的比较最终答案的。。。所以定义max
        
// 初始化dp数组 第一列。当j=0,也就是固定nums2 的下标为0 的那个子数组，然后遍历 nums1。
              for(int i=0;i<m;i++){
                  if(nums1[i]==nums2[0]){
                      dp[i][0]=1;
                      max=1; //特殊之处
                  }
              }
        
      // 同理，初始化dp数组的第一行，也就是固定nums1 的下标为0 的那个子数组，然后遍历 nums2。
              for(int i=0;i<n;i++){
                  if(nums2[i]==nums1[0]){
                       dp[0][i]=1;
                       max=1; //特殊之处
                  }
              }
        
     // for循环遍历顺序，当然是从上到下↓，从左到右→，因为已经对第一列和第一行遍历过了，所以i和j都是从下标1 开始遍历。。 
        		// 外层遍历的是 nums1中的元素 。。。
             for(int i=1;i<m;i++){
                    // 内层遍历的是  nums2数组中的元素 。。
                 for(int j=1;j<n;j++){
                     
  // 只有 nums1的 i下标 和 nums2的j下标指向的 两个元素相等，才会采用递推公式，去更新计算dp！！
      //dp[i][j] 当前格子，依赖前面的状态，所以就看 这两个数组nums的 分别的前一个元素也就是 nums1数组的 i-1和 nums2数组j-1，对应的 dp[i-1][j-1]值，最长重复子数组的长度是多少，然后加 1 就行了。。。就是 dp数组[][] 里面，2*2格子“斜着” 左上角那个值 。。。
                     if(nums1[i]==nums2[j])
                    	 dp[i][j]= dp[i-1][j-1]+1;
                     
                     //每次都记得 和 max 比较大小，然后要更新
                     max=Math.max(dp[i][j],max); //特殊之处
                     
                 }
             }
        
                 // 这里也是返回max，而不是 dp[][]二维数组的最末尾的下标
      // 因为不一定以最末尾的 两个数组的 nums1 和 nums2的，它的dp格子值，才是最长的 
             return max;  //特殊之处
    }
}