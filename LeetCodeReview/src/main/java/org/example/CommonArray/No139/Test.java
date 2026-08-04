package org.example.CommonArray.No139;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution139 solution = new Solution139();
        // s = "leetcode", wordDict = ["leet", "code"]
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
