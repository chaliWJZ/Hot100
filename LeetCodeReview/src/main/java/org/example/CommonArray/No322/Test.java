package org.example.CommonArray.No322;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Solution322 solution = new Solution322();
        // coins = [1, 2, 5], amount = 11
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(solution.coinChange(coins, amount));
    }
}
