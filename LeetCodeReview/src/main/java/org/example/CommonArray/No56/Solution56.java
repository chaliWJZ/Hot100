package org.example.CommonArray.No56;

import java.util.*;
public class Solution56 {

    // --- 解法一 ---
// 整个合并区间的过程基于 贪心思想，目标是让 相互重叠的区间 尽可能 合并成一个 更长的区间。

// 思路就是，先对输入的 所有区间 按照 所有区间的左端点 从小到大 进行排序。然后再顺序遍历 这些区间，来判断合并情况了：
	/** 排序后的intervals 中的两个区间 a,b，假设a在前，b在后，那么必然有a[0]<=b[0]，我们合并的时候 只需要判断 b区间的左端点 是否小于等于 a区间的右端点 就行了，看看 区间有没有交集，重叠。
	如果 b区间的左端点 b[0] <= a区间的右端点 a[1]，那么当前b区间就和a区间有交集，可以合并，由于合并后并不知道a的右端点大，还是b的右端点大，可以直接取max即可。
	否则，没有交点，直接插入一个 新的区间 就行。
	**/

    public int[][] merge(int[][] intervals) {
        
        // 先对区间数组intervals 按照 区间的左端点 进行排序，方便后续合并操作
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 创建一个 res 合并集合，用于临时存储 合并后的区间
        List<int[]> res = new ArrayList<>();

        // 遍历排序后的 区间数组 intervals
        for (int i = 0; i < intervals.length; i++) {
            
            // 获取 当前遍历区间的  左端点 和 右端点
            int start = intervals[i][0];
            int end = intervals[i][1];

            // 判断 合并集合res 是否为空
            if (res.isEmpty()) {
                // 如果为空，直接 将当前区间 添加到 合并集合 res 
                res.add(new int[]{start, end});
            } else {
                
                // 如果不为空，每次都要获取 合并集合res 的最后一个区间的右端点
                // 去和 遍历当前区间的左端点 比大小，判断 是否有重叠部分，有交集
                int lastEnd = res.get(res.size() - 1)[1]; 
                
                if ( start<=lastEnd) {      
           // 如果 当前区间的左端点 <=  合并集合的 最后一个区间的 右端点，就说明有交集
                 // 就要更新 合并集合的 最后一个区间的 右端点，取当前遍历区间的右端点 和 合并集合的 最后一个区间的右端点 的较大值
                    res.get(res.size() - 1)[1] = Math.max(lastEnd, end);
                    
                } else {
                    // 否则，就没有 重叠部分，则直接将 当前遍历区间 添加到 合并集合
                    res.add(new int[]{start, end});
                }
            }
        }

        // 将 合并集合 转换为 二维数组[][] 并返回
        return res.toArray(new int[res.size()][]);
    }
}