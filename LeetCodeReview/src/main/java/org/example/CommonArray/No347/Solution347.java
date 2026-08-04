package org.example.CommonArray.No347;

import java.util.*;
public class Solution347 {


    // --- 解法一 ---
public int[] topKFrequent(int[] nums, int k) {
    	
    	// 用于返回结果的 数组 。。返回的是  元素数字， 而不是出现的次数 ！！
    	
        int[] result = new int[k];
    
        // 第 1 步，就是 统计 每个数字 出现的次数 。。最适合用 map 来存储 
    	// key : 数字 ，value ：出现的频次
        Map<Integer, Integer> map = new HashMap<>();
				
    			
        for (int i = 0; i < nums.length; i++) {
				// 因为 map的 value 值 可以覆盖，所以一般就是这样 统计 出现次数的，getOrDefault(nums[i],0) 方法就是指，如果 这个 key 存在，那么就返回对应的 value；如果不存在，就返回 0 
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

   // 第 2 步，其实就是对 map集合中的 value 进行排序，但是呢，key 也要一起连着动。所以就想到了 entrySet()方法 以及 Collections.sort( , )方法，两者结合。因为这个sort 方法只适用于list集合，所以要把entrySet()返回的Set<>集合，先转换存储在 List<>中 
       
       // 根据 map.entry 对象的 value 进行排序。。。其实 也就是 连同 key 一起移动
    	// 本题的 难点 就在这里，只有这样 才能实现 key 跟着 value排序 ，然后 一起移动
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
    
       
   
        Collections.sort(list, (a, b) -> {
            
     //因为 要返回 出现次数最高的 元素，那么 出现次数最多的那个 数字 就要排在第一位，那么就是降序。
            	// 因为 升序 是 a-b。而本题 要降序 ，所以是 b-a ！！
   	// a和b 就是 list中存储的每一个元素，所以是 map.entry类型，而且是根据对象的 value 出现次数 进行排序 ，只能通过getValue()方法 
            return b.getValue() - a.getValue();
        });
       
       //这个 sort()方法一旦执行的话，那么原来的list集合的元素 就会内部排序的，会改变的！！！
       
			
// 第 3 步： 就是把 list 集合中 存储的 每个 map.entry对象，kv结构里面的 key，就是 数字元素， 依次插入到 res 结果数组。。注意是 前 k个   map.entry对象  ！ 所以 循环终止条件 是 k 
       
        for (int i = 0; i < k; i++) {
            
            	// 通过 get(i)获取 list 集合 中的 每一个元素 
            	// 而 每一个 map.entry对象 要获得 key可以通过 getKey()方法 
            result[i] = list.get(i).getKey();
        }

        
        return result;
    }
}