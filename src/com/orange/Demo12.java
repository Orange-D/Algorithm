package com.orange;

public class Demo12 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(332233));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if ( x < 10)
            return true;

        String temp = String.valueOf(x);
        int len = temp.length();
        for (int i = 0; i < len/2; i++) {
            if (temp.charAt(i) != temp.charAt(len-1-i))
                return false;
        }
        return true;
    }
}
