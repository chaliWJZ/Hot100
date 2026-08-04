package org.example.CommonString.No93;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution93 solution = new Solution93();
        // s = "25525511135"
        String s = "25525511135";
        int startIndex = 0;
        int pointNum = 0;
        solution.backtracking(s, startIndex, pointNum);
        System.out.println("Done");
    }
}
