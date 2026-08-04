package org.example.CommonArray.No349;

import java.util.*;
public class Solution349 {

    // --- 解法一 ---
// 求交集，比较适合 用哈希表。。这里选用 set集合，用于对最终的答案 "去重"

    public int[] intersection(int[] nums1, int[] nums2) {

    // 这个 哈希表 set1 用来 存储 数组nums1的  "去重"之后 的 剩下元素。。。
        Set<Integer> set1 = new HashSet<>();

        // 这个 哈希表 res 用来 存储 相交元素，而且会对结果 "去重"
        Set<Integer> res = new HashSet<>();

        //遍历数组nums1，把元素 存入 哈希表set1中，会“去重” ！！！
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

   // 遍历数组 nums2 的过程中，对nums2中的每个元素 判断一下 它是否存在之前 set1 哈希表中，如果 存在，那么 就是 “相交”元素！！！！！就把它添加到  的保存结果的  res 哈希表
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }

   //因为题目最后要求返回的是一个数组[]类型，所以要另外申请一个int []数组，存放 res集合。

        int[] arr = new int[res.size()];
        int j = 0;
        for(Integer i : res){
            arr[j++] = i;
        }

        return arr;
    }
}