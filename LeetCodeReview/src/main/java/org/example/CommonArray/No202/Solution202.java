package org.example.CommonArray.No202;

import java.util.*;
public class Solution202 {

    // --- 解法一 ---
// 要证明是不是 快乐数？？？ 只要 排除 不是的情况，那么剩下的就是 快乐数的情况。。。
// 那么 就是如何判断 不是快乐数？？？ 也就是 这个数字 是会一直循环下去的，也就是说  各位数的平方和后的 数字 后来又出现过。。。那么就会无限循环。。。

// 那么就需要保存每一次 的平方和，然后每次都判断 求出来的平方和 是否之前出现过，存在过。。那么就是和用 哈希表 存储，判断是否存在。。。

    public boolean isHappy(int n) {

     //  声明 一个 哈希表，这里选择的是 set集合 来存储元素，每一次的 各位数平方和
        Set<Integer> set = new HashSet<>();

        //  当然是  n！=1 作为 while循环的终止条件
        while(n!=1){
            
          //  题目中说了会 无限循环，如何判断  这个数字  会  无限循环？？？？？
 //  也就是说  各位数的平方和后的 数字 后来又出现过。。。那么就会无限循环，这里就选择 直接返回 false ，跳出 循环 
            if(set.contains(n))
                return false;
            
            else{
                //  如果 在之前的 set集合中 不存在 ，那么就将它存入 set集合中，并且继续  求 这个数 的 各位数的平方和 
            set.add(n);
            		// 调用下面的方法，用于求 各位数的平方和，然后对 传入的n 这个数 重新赋值 。
            n = getNextNumber(n);
            }

        }
        
        return true;

    }

        //  所以写了 第2个 方法在下面。   功能是，求 某个整数的   各位的数字的平方和
        public int getNextNumber(int n){

            int sum=0;

                //  一般固定写法  就是 n>0 作为 循环终止条件 
            while(n>0){
                
          //  %10  就是  得到某个整数的 最后那个位置的 数值
                int temp = n%10;
                sum+=temp*temp;
           //  每次都要 截掉 整数的 最后那个数值，返回一个新的 整数，也就是少了 1位
                n = n/10;
            }

            return sum;

    }
}