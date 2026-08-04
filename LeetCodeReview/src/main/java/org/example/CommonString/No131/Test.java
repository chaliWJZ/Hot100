package org.example.CommonString.No131;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution131 solution = new Solution131();
        // s = "aab"
        String s = "aab";
        int startIndex = 3;
        solution.backtracking(s, startIndex);
        System.out.println("Done");
    }
}
