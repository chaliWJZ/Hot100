package org.example.CommonString.No344;

import java.util.*;
public class Solution344 {

    // --- 解法一 ---
// 因为要求 “原地”修改，  所以可以用 双指针来解决。。
// 两个左、右指针left 和 right ，每次相互交换值，然后再向中间靠拢就行。

    public void reverseString(char[] s) {
		
        //  用的是  双指针的相向指针  一个在最左端 left  ，另一个在 最右端 right   
        int left = 0;
        int right =s.length-1;
		
        while(left < right){
				
              //  常见的 二值交换的 固定代码，就是这么 3行 ！！！
            char temp = s[right];
            s[right] = s[left];
            s[left]  = temp;
            
            left++;
            right--;

        }

    }
}