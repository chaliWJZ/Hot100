package org.example.CommonString.No22;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        // n = 3
        int n = 3;
        int left = 3;
        int right = 3;
        String str = "hello";
        solution.backtracking(n, left, right, str);
        System.out.println("Done");
    }
}
