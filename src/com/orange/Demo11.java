package com.orange;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  字符串转换整数 https://leetcode-cn.com/problems/string-to-integer-atoi/submissions
 *
 ^：匹配字符串开头
 [\+\-]：代表一个+字符或-字符
 ?：前面一个字符可有可无
 \d：一个数字
 +：前面一个字符的一个或多个
 \D：一个非数字字符
 *：前面一个字符的0个或多个


 */
public class Demo11 {

    public static void main(String[] args) {
//        System.out.println(reverse(123));

        // 要验证的字符串
        String str = "+20";

        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String str) {
        String temp = str.replace(" ", "");
        if (temp.startsWith("+-") || temp.startsWith("-+"))
            return 0;
        if (!temp.startsWith("-") && !temp.startsWith("+")){
            try {
                Integer.parseInt(String.valueOf(temp.charAt(0)));
            } catch (Exception e) {
                return 0;
            }
        }
        // 正则表达式规则
        String reg = "[\\+\\-]?\\d+";
        // 封装/编译正则表达式
        Pattern p = Pattern.compile(reg);
        //让正则对象和要作用的字符串相关联。获取匹配器对象。
        Matcher m  = p.matcher(str);
        //输出结果
        if(m.find()) {
            String result = m.group();
            Long num = null;
            try {
                num = Long.parseLong(result);
            } catch (NumberFormatException e) {
                return Integer.MAX_VALUE;
            }
            return (int) Math.max(Math.min(num, Integer.MAX_VALUE), Integer.MIN_VALUE);
        }

        return 0;
    }
//
//    public int matches(String s) {
//        String regex = "^[\\+\\-]?\\d+";
//        return s.matches(regex);
//    }
}
