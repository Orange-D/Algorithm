package com.orange;

import java.util.HashMap;
import java.util.List;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class Demo23 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(climbStairs(45));
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static int climbStairs(int n) {
        int count  = 0;

        int stair[] = new int[n +1];
        stair[0] = 1;
        stair[1] = 1;
        for (int i = 2; i <= n; i++) {
            stair[i] = stair[i-1] + stair[i-2];
        }
        return stair[n];
    }
//    public static int climbStairs(int n) {
//        if(n == 2)
//            return 2;
//        if(n == 1)
//            return 1;
//        if(n == 0)
//            return 0;
//        return climbStairs(n-1) + climbStairs(n-2);
//    }

//    public static int climbStairs(int n) {
//        int memo[] = new int[n + 1];
//        return climb_Stairs(0, n, memo);
//    }
//    public static int climb_Stairs(int i, int n, int memo[]) {
//        if (i > n) {
//            return 0;
//        }
//        if (i == n) {
//            return 1;
//        }
//        if (memo[i] > 0) {
//            return memo[i];
//        }
//        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
//        return memo[i];
//    }

}
