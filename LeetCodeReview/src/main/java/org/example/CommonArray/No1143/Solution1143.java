package org.example.CommonArray.No1143;

import java.util.*;
public class Solution1143 {

    // --- 解法一 ---
// “非连续”的子序列 ，也就是 选择两个元素之间可以空开。。。所以判断条件稍微复杂一点。。。
//   采用dp动态规划来做。很明显是 两个 字符串，要采用 二维dp[][]

    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();
        
        //这里定义就是 按照两个数组的长度，定义 dp 二维数组 [][]
     //dp[i][j]是指，表示在nums1中以下标 i 为结尾，nums2中以下标 j 为结尾的最长公共子数组的长度是dp[i][j] 
        int[][] dp = new int[m][n];

        //  这里同样是需要不断的比较最终答案的。。。所以定义max ..这里比较特殊， 所以要定义成 0，
        //  因为如果不存在公共子序列，那么最大值就是 0 。。。而不是 Integer.MIN_VALUE，那么就是 -2738993234234。。。。。。了
        int max = 0;   

     // 初始化dp[][]的 第一行，也就是 text1固定 第一个字符，然后去匹配 text2字符串的 各个字符 
        for (int i = 0; i < m; i++) {
            
            if (text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
                max = 1;
       // 这里为什么要加上  内部的for循环。。。可以这么理解。。此时固定的只有一个 text1的 第一个字符，只有一个字符，也就是说 最长公共子序列最多就是1！！所以当我们找到 charAt(i) ==的时候， 对于 i 之后的 i+1,i+2....直到末尾字符，它对应的 dp[][] 格子值最多就是 1 。。
                // 而且有因为这里是 "非连续"的子序列，也就是 后面的字符 哪怕是不连续的，也可以沿用前面的 已经存在的 最大公共序列长度
             
                for(int k=i;k<m;k++)
                    dp[k][0]=1;
                
                break;
            }
            
        }

     // 初始化dp[][]的 第一列，也就是 text2固定 第一个字符，然后去匹配 text1字符串的 各个字符
        for (int j = 0; j < n; j++) {
            
            if (text2.charAt(j) == text1.charAt(0)) {
                dp[0][j] = 1;
                max = 1;
                
                for(int k=j;k<n;k++)
                    dp[0][k]=1;
                break;
            }
            
        }

        // for遍历计算的 顺序，当然是从上到下↓，从左到右→，因为已经对第一列和第一行遍历过了，所以 i 和 j 都是从下标 1 开始遍历。。   
        
        //   外循环 遍历的是 text1的 各个字符 
        for (int i = 1; i < m; i++) {
            // 内循环 遍历的是 text2的 各个字符 
            for (int j = 1; j < n; j++) {
                
  // 只有 text1的 i下标 和 text2的 j下标指向的 两个字符 相等，才会采用递推公式，去更新计算dp！！
      // dp[i][j] 当前格子，依赖前面的状态，所以就看它们的前一个元素 dp[i-1][j-1]值， 最长公共子数组的长度是多少，然后加 1 就行了。。就是 dp数组[][] 里面，2*2格子“斜着” 左上角那个值 。。。
                if(text1.charAt(i)==text2.charAt(j))
                    dp[i][j]=dp[i-1][j-1]+1;
                
                else
            // 否则的话，如果 在 两个text 字符串的 指向的 字符 它们不相等。。
    //  那么，要么就是  text1 退前面一个字符，也就是 i-1对应的那个 dp[i-1][j]值，保存的最长公共子数组的长度。。或者是  text2 退前面一个字符，也就是 j-1对应的那个 dp[i][j-1]值，保存的最长公共子数组的长度 。。所以是取 两者的最大值就行 ！！！
                    dp[i][j]=Math.max(dp[i -1][j],dp[i][j -1]);
                
                  //每次都记得 dp[i][j]和 max 比较大小，然后要更新 max
                max = Math.max(dp[i][j], max);
            }
        }

        // 这里也是返回max，而不是 dp[][]二维数组的最末尾的下标
      // 因为不一定以最末尾的 两个数组的 text1 和 text2 的，它的dp格子值，才是最长的 
        return max; //特殊之处 
    }
}