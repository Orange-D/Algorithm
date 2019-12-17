package com.orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 */
public class Demo24 {
    public static void main(String[] args) {

        List<Integer> triangleOne = new ArrayList<>();
        triangleOne.add(-10);
        List<Integer> triangleTwo = new ArrayList<>();
        triangleTwo.add(3);
        triangleTwo.add(4);
        List<Integer> triangleThree = new ArrayList<>();
        triangleThree.add(6);
        triangleThree.add(5);
        triangleThree.add(7);
        List<Integer> triangleFour = new ArrayList<>();
        triangleFour.add(4);
        triangleFour.add(8);
        triangleFour.add(1);
        triangleFour.add(6);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(triangleOne);
//        triangle.add(triangleTwo);
//        triangle.add(triangleThree);
//        triangle.add(triangleFour);

        minimumTotal(triangle);
        /*
            2 0 0 0         2   0   0   0
            3 5 0 0         5   6   0   0
            6 5 7 0         11  10  13  0
            3 1 8 6         15  11  18  16
         */
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int dp[][] = new int[row][col];



        dp[0][0] = triangle.get(0).get(0);
        int minPath = dp[0][0];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int rowSize = triangle.get(i).size();
                if(j >= rowSize)
                    continue;

                int currNum = triangle.get(i).get(j);
                int leftCount =( j == 0 ? 0 : dp[i-1][j-1]) + currNum;
                int rightCount =  (j == rowSize - 1 ? 0 : dp[i-1][j]) + currNum;
                if (j == 0) {
                    dp[i][j] = rightCount;
                }else if ( j == rowSize - 1 ){
                    dp[i][j] = leftCount;
                }else {
                    dp[i][j] = Math.min(leftCount, rightCount);
                }

                minPath = j == 0 ? dp[i][0] : Math.min(minPath,dp[i][j]);
            }
        }

        for(int i=0; i<dp.length; ++i) {
            for(int j=0; j<dp[i].length; ++j)
                System.out.print(dp[i][j] + " ");
            System.out.print("\n");
        }
//        int []lastRow = dp[row -1];
//        int min = lastRow[0];
//        for (int i = 1; i < lastRow.length; i++) {
//            min =  min <  lastRow[i] ? min : lastRow[i];
//        }
        System.out.print(minPath);
        return minPath;
    }
}

