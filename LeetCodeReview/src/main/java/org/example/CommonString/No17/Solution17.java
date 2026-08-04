package org.example.CommonString.No17;

import java.util.*;
public class Solution17 {

    // --- 解法一 ---
// 也是 回溯组合 的方法去做，不断递归 。。。
// 这里默认的话，传入的 digits数字键字符串，它的长度是多少，那么最终答案res保存的 单个临时路径答案的字符串组合的长度就是几， digits=“23” ,那么 他的长度是2 ，最终返回的 ["ad","ae","af",..] 这样的
// 只不过这里是 两个选择的集合了。。。所以 这里的话，在下面的for 循环，横向→ 选择元素的是，i=0 ，而不是 i= startIndex 开始了 ！！！

    // 基本上这两个都是这样定义好，在最外面。。。
    // 设置全局列表存储最后的所有结果
    List<String> res = new ArrayList<>();
    // 设置全局列表存储每次递归的 单个临时路径的答案
    StringBuilder temp = new StringBuilder();
			
   									// 自带的主函数 
    public List<String> letterCombinations(String digits) {

            // 这里的话，这个就是必须要加了的。。判断传入为空的 digits
        if (digits.length() == 0) {
            return res;
        }

        // 每个数字键 和 包含字符串 之间的映射！！为了直接对应2-9，新增了两个无效的字符串""  
        // 下标 2-"abc" ,3-"def" ,以此类推 
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
   // 主函数传入的额外参数 numString[] 字符串数组，其实就是 对应手机的 每个数字键，它里面包含的 字符串。。。比如 数字键2->"abc"
       // ！！然后就是 index 参数，代表  当前遍历的 字符串 digits的下标。第一个字符，它的下标是从0开始。这里它的含义是，指向的 digits字符串中的第几个 数字字符....  
        // 比如 digits ="23" ，index =0，就是指向 '2'数字字符
        backTracking(digits, numString, 0);
        
        return res;

    }

    public void backTracking(String digits, String[] numString, int index) {
        
        // 递归的结束条件
      //比如输入字符串 digits="23"，是两个数字，那么根节点往下递归 两层 ,就可以了，叶子节点就是要收集的结果集res 。。
     // 所以 这里的 只需要 index 的下标遍历到了 digits字符串的长度(2)，就是递归 2次 ，就可以结束了.....
        if (index == digits.length()) 
        {		
            res.add(new String(temp));
            return;
        }

    // 比如传入的 自带参数，数字字符串digits 为"23",那么 index 下标 为0，指向'2'，再转为数字 2，从数字键映射表 numString ，取出对应的字符串 "abc"，也就是 str
    // str 表示当前 数字键，对应的字符串   	
            String str = numString[digits.charAt(index) - '0'];

       	  // 规定模板的for循环语句。。。因为这里是 从两个集合里面 选元素，那么就是i=0开始。。                       也就是从 str 里面一个个取出 字母字符，寻找组合答案 			
        for (int i = 0; i < str.length(); i++) {
            
            temp.append(str.charAt(i));
            // 递归，处理下一层 。。很常见的 index+1，其实就是指向 digits 数字字符串中 下一个 数字字符，也就是 下一个 数字键。 比如 digits="23",那么下一个取出的数字键 就是 '3'
            backTracking(digits, numString, index + 1);
            // 剔除末尾的，继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}