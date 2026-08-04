package org.example.CommonString.No438;

import java.util.*;
public class Solution438 {

    // --- 解法一 ---
//这道题 先用map 集合，记录 字符串p各个字符出现的次数。
//  然后用 “滑动窗口”的思想，去 遍历整个 字符串 s ，记得是固定长度，也就是 字符串p的长度作为 滑动窗口的定长。   
//   去统计 当前字符串 s 中的子串 的各个字符出现的次数 。
 
   public   List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
							// 这里的 m作为 下面 “滑动窗口”的 定长长度 ！！！！
        int n = s.length(), m = p.length();

        // 先存储 p字符串中的每个字符 出现的次数。把它放入 map2 哈希表中     
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < m; i++)
        {
            char ch = p.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

     // map1 哈希表的话，是对于  “滑动”窗口的时候要用的，用来统计「滑动窗口」内的 s 的子串词频 ，然后 和 map2已有的 进行比较。。。当两个map 所统计词频相等，说明找到了一个异位组，将窗口的左边界left 加入答案。
        HashMap<Character, Integer> map1 = new HashMap<>();
        
        int left = 0, right = 0;

        // 有点 “滑动窗口” 的 最长或者 最短的 代码模板的样子
        //  但里面的内层while判断 有点特殊的。   <----- “定长” 滑动窗口 的 模板
        while (right<s.length()) {

            // 先添加 右边界的元素
            char ch_r = s.charAt(right);
            map1.put(ch_r,map1.getOrDefault(ch_r,0)+1);

            //当 窗口的长度大于 m的时候，那么 左边界left 就要往右移动
            if(right - left + 1 > m){
                // 移除 左边界对应的 元素 ，并且 左边界要 右移！！
                char ch_l = s.charAt(left);
                map1.put(ch_l,map1.get(ch_l)-1);
                left++;

          //   这行肯定要加的！！因为如果 这个字符 出现的 次数 为0了，但是这个key还是存在的
                  // 如果不删除它，那么 之后 两个map比较的时候会出问题，会误识别 异位词。。
                if(map1.get(ch_l)==0)
                    map1.remove(ch_l);
               
            }

     //  当滑动窗口 等于定长的 时候，就要比较 map1和map2，如果相等的话 ，就添加left 作为结果
            if(right-left+1==m){

                if(map1.equals(map2))
                    ans.add(left);
            }

            // right 右边界 在最下面的地方要 继续往右移动。
            right++;

        }

        return ans;

    }
}