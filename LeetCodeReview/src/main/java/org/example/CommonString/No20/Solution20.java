package org.example.CommonString.No20;

import java.util.*;
public class Solution20 {

    // --- 解法一 ---
// 首先！ 明确本题  正确 的 字符串是怎么样的 ----> 比如 ()(){}[]()  或 [({})]
//  比如常见的错误  ----> (] 或 (( 或者 ))

//这道题 用 "栈" 的思想 ！！！
/**
   主要思想，在匹配左括号{的时候，我们是把 它的右括号}先入栈。如果 当遇到 字符串中的右括号的时候， 比如 } ，看看它和 栈顶的元素是否相等，相等就说明匹配，那么就把栈顶元素出栈，一直这样循环比较，出栈入栈
**/
    public boolean isValid(String s) {

            // "剪枝"。字符串的个数的判断，如果是 匹配字符串，那肯定是偶数。
              if (s.length()%2!=0)
                return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            //碰到 左括号，就把相应的 "右"括号 入栈 ！！ 这样的 "反向"思路更好理解

            if (ch == '(')
                stack.push(')');

            else if (ch == '{')
                stack.push('}');

            else if (ch == '[')
                stack.push(']');

      //第一种情况：遍历字符串匹配的过程中，栈已经 为空了，说明只剩下右括号 之类的，它没有找到对应的左括号 再去匹配了,所以return false 。比如 ([])) ，最后的 )匹配不了了

      //第二种情况：遍历字符串匹配的过程中，栈不为空，发现栈里没有我们要匹配的字符,所以return false 。比如 ([]}, (和 } 匹配不了

            else if (stack.isEmpty())
                return false;

            else if(stack.peek() != ch)
                return false;

  // 其余的情况就是，右括号 和 "栈顶"元素 匹配相等，因为"栈顶"元素 存的是 左括号的对应 右括号，那么就要 出栈 ~~~

            else
                stack.pop();

        }

     //for循环 遍历完 字符串后。还要检查 栈是否为空 如果栈不为空，说明有相应的左括号 没有 右括号来匹配，返回 false。。。 如果是 空的话，说明匹配完毕了，那么返回 true  ！！
       // 就是第三种情况  ： 左括号 没有匹配的 情况有这些： 比如 ((
        return stack.isEmpty();

    }
}