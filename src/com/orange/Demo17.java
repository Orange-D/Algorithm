package com.orange;

import java.util.HashMap;

/**
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};  // 罗马数字
 * int[] arab     = {1000, 900, 500,  400, 100,  90,   50,  40,   10,   9,   5,   4,    1};  // 阿拉伯数字
 */
public class Demo17 {
    static HashMap<String, Integer> romanMap = new HashMap<>();

    public static void main(String[] args) {





        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String roman) {
        if (romanMap.size() == 0){
            romanMap.put("M", 1000);
            romanMap.put("CM", 900);
            romanMap.put("D", 500);
            romanMap.put("CD", 400);
            romanMap.put("C", 100);
            romanMap.put("XC", 90);
            romanMap.put("L", 50);
            romanMap.put("XL", 40);
            romanMap.put("X", 10);
            romanMap.put("IX", 9);
            romanMap.put("V", 5);
            romanMap.put("IV", 4);
            romanMap.put("I", 1);
        }
        if (roman.length() == 0 )
            return 0;
        int len = roman.length();
        String key = "";
        if (len >= 2 ){
             key = roman.substring(0,2);
            if (romanMap.containsKey(key)){
                return romanMap.get(key) + romanToInt(roman.substring(2,len));
            }
        }

        key = roman.substring(0,1);
        return romanMap.get(key) + romanToInt(roman.substring(1,len));


    }
}
