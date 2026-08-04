package org.example.CommonString.No72;

import java.util.*;
public class Solution72 {

    // --- 解法一 ---
// 这道题很明显是需要用 动态规划dp来做，而且是 二维的。
// 这里定义的是 dp数组 的含义，dp[i][j]是指，以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，word1 → word2的 编辑次数 为dp[i][j] 。。。切记 ！！这里只针对 把word1 变成word2！

//  根据那个dp数组矩阵，可以指导，在第一行的话， 要想 word1变成 word2，就是 第一行的每个元素，对应要添加 word2的下标j的元素就行了。对于 第一列的话，word1 变成word2，因为 word1的元素不断添加，但是 word2一直是 ""空串，就只需要每添加一个 i下标的字符 时候，把它 删除一次就行。。。

    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
	
  // ----->这里比较特殊了，
 // +1 多开一行一列，是为了保存边界条件，即字符长度为 0 的情况""，这样子方便后面的dp数组初始化。。记得for循环里面的 终止条件要写成 <= ，小于等于了。。。
 	
 // 所以此时的 dp[i][j]是指，以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，word1 → word2的 编辑次数 为dp[i][j]
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        // 初始化dp数组的 第1列，当 word2 为 "" 时。将 word1 的全部删除即可，编辑次数就是非空字符串word1的长度 i
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        
        // 初始化dp数组的第1行，当 word1 为"" 时。将 word2 的全部增加即可，编辑次数就是非空字符串word2的长度 j
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }

 //dp数组的 循环计算遍历 顺序，因为dp[i][j] 依赖左上角，上边元素，左边元素 ，所以是 从上到下↓，从左到右→遍历，就是 i=1，j=1 了
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                
                // 这是最佳情况，word1和word2的此时 两个字符 相等的时候
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
  // 此时的dp[i][j]递推公式等于，dp[i-1][j-1]，就是左上角的元素。。其实就是 它们分别去掉一个字符的剩下字符串 
                    dp[i][j] = dp[i - 1][j - 1];
                    
                }

  // 如果 两个字符 不相等，那么就是对 word1 增删改 操作，从三种情况中 选步骤最少的！！然后再次数+1 
                else{

     // 1、选左边元素 [i,j-1]，因为要算 dp[i,j]，此时 word2多了一个字符，那么就只需要在word1后面 增加一个 和 word2一样的j下标对应的字符
                    int insert = dp[i][j - 1];
                    
     // 2、选左上角元素[i-1,j-1],因为 要算dp[i,j]，其实 就是把 word1的末尾字符 替换成 和 word2一样的末尾字符就可以了
                int replace = dp[i - 1][j - 1];
                    
     // 3、选上边元素dp[i-1][j];,因为要算 dp[i,j]，此时 word1多了一个字符，就是把 word1的末尾字符 删掉就行了。。。
                int delete = dp[i - 1][j];
                    
              //此时的递推公式，依赖于 就是取这三者的最小值，然后再 +1 次数就可以了
                dp[i][j] = Math.min(Math.min(insert, replace), delete)+1;
                }

            }
        }
        
        	// 这道题比较特殊!!!前面的xxx求最大的dp题目，都是 返回max(在for循环遍历计算的不断比较更新)
        // 但是这道题 返回的就是 下标范围 [0,n-1] 的 dp数组，这个和 dp数组的含义有关系，因为是整个范围从0到 末尾下标i-1
        return dp[len1][len2];
    }
}