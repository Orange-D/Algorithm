package com.orange;

import java.util.HashMap;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
 */
public class Demo8 {
    public static void main(String []args){
        String s = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        System.out.println(longestPalindrome(s));
    }


    /**
     *
     * 我们知道回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
     *
     */
    public static String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        int len = s.length();
        int start = 0;
        int end   = 0;
        for (int i = 0; i < len; i++) {
            int len1 = expandAroundCenter(s, i, i);         //奇数的字符串  eg: abcba
            int len2 = expandAroundCenter(s,i,i+1);    //偶数的字符串 eg: abccba
            int maxLen = Math.max(len1, len2);

            if (maxLen >end - start  ) {
                start = i - (maxLen - 1)/2;
                end = i + (maxLen /2);
            }
        }
        return s.substring(start, end + 1);
    }



    //扩展中心
    public static int expandAroundCenter(String s, int left,int right){
        int L = left;
        int R = right;
        while (L >= 0 && R <= s.length() -1 && s.charAt(L) == s.charAt(R)){
            L --;
            R ++;
        }

        return R - L - 1;
    }
    //暴力
//    public static String longestPalindrome(String s) {
//        String ans = "";
//        int max = 0;
//        int len = s.length();
//        for (int i = 0; i < len; i++)
//            for (int j = i + 1; j <= len; j++) {
//                String test = s.substring(i, j);
//                if (isPalindromic(test) && test.length() > max) {
//                    ans = s.substring(i, j);
//                    max = Math.max(max, ans.length());
//                }
//            }
//        return ans;
//    }
//
//
//    //判断是否回文
//    public static boolean isPalindromic(String s) {
//        int len = s.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (s.charAt(i) != s.charAt(len - i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
