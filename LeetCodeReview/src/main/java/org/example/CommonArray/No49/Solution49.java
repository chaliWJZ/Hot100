package org.example.CommonArray.No49;

import java.util.*;
public class Solution49 {

    // --- 解法一 ---
//  我们可以将 String [] 字符串数组中的，每个字符串 排序，就方便 后面分组了。。。
// 然后，把它们存入 哈希表。。这里采用map 集合， 按照不同的 key 进行添加同一组的 字母异位词

    public List<List<String>> groupAnagrams(String[] strs) {
       
        int len = strs.length;
        String[] tempstrs = new String[len];

 // 也可以 这么设置 map的数据类型。key就是 String 。。。。但是 value 可以设置为 是 List< > ，  保存一组 字符串。。。
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < len; i++){ 
            
            // 因为 是 字符串 String[]数组，所以先对 数组中 的 每一个 字符串String  先转变成 char[] 字符数组。。然后才方便 对 单个字符串的字符 进行排序                
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            
            //  再 把 排序后的 char[]字符数组 --> 转成 字符串String，作为key插入 map集合
            String key = new String(cs);

        //  这行代码很关键！！因为 如果 这个 排序后的字符串key 不存在，那么就第一次 插入key和 value，value先是一个空的 list集合。。。
           // 后期 会一直在这个key中 对应的value， 也就是那个 list< >集合,累计 插入 新元素
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            
    // 如果 "排序"后的字符串 存在 map 集合，，那么是插入 "未排序"原始的字符串 strs哦！！！这个也很关键。。。
    // 上面的”排序“逻辑。。。 只是为了方便 找到哪些 字母异位词
            map.get(key).add(strs[i]);
            
        }
        						
        return new ArrayList<>(map.values());
    }
}