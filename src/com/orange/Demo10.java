package com.orange;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Demo10 {

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
    public static int reverse(int x) {
        int term;
        long b = 0;
        while (x != 0) {
            term = x % 10;
            x = x / 10;
            b = b*10 + term;
        }
        if(b > Integer.MAX_VALUE || b < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) b;

    }


}
