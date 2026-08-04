package org.example.CommonArray.No42;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution42 solution = new Solution42();
        // height = [0,1,0,2,1,0,1,3,2,1,2,1]
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height));
    }
}
