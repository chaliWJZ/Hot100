package org.example.CommonString.No3;

import java.util.*;
public class Solution3 {


    // --- 解法一 ---
public int lengthOfLongestSubstring(String s) {

            //创建哈希表,用来存储 字符串中 的每个 字符，出现的 次数 ，为了统计 “重复”
            HashMap<Character,Integer>map=new HashMap<>();

            //定义滑动窗口的左右指针，left和right ,默认都从 0开始  
            int left=0;
            int right=0;

       // result 用于保存 最终结果，求的是 子串的最大长度。所以这里默认就是 Integer.MIN_VALUE，用于之后的比较和更新
            int result=Integer.MIN_VALUE;

            while(right<s.length()){
                    // 右指针的话就是 对扫描过的 字符，不断进行 出现次数的累加，也就是“添加”元素
                map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);

        // 因为是套 代码模板的，这道题是 求最“长” 。 所以内层的 while循环 就必须 是  不满足题目条件才触发
          // 题目要 不重复字符，所以 不满足 不重复，翻译过来就是 => 要有重复字符 的时候                	// 所以就是 字符出现次数大于1，那么就是 get(right)>1 

                while(map.get(s.charAt(right))>1){

      // left左指针仍然是 向右移动，缩小窗口，那么就要对扫描过的字符 的出现次数 -1 ，也就是“移除”元素
                     map.put(s.charAt(left),map.get(s.charAt(left))-1);
                     left++;

                }

      // 外层while循环的下面，这里就是 满足题目条件的，才去 不断比较，更新最终结果 result

                result  = Math.max(result,right-left+1);

                // 滑动窗口的右指针 向右移动，right++
                right++;
            }

             // 如果result没有被赋值的话，就返回0，说明 没有符合条件 的子数组 
           return result==Integer.MIN_VALUE?0:result; 
        }
}