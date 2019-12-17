package com.orange;

import java.util.Stack;

public class Demo20 {


    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            if (isLeftHalf(temp))
                stack.push(temp);

            if (isRightHalf(temp)) {
                if (stack.empty()) {
                    return false;
                }
                String stackRight = (String) stack.peek();

                if (stackRight.equals(LookForTheOtherHalf(temp))) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }


        return (stack.size() == 0);
    }

    public static boolean isRightHalf(String s) {
        switch (s) {
            case ")":
                return true;
            case "}":
                return true;
            case "]":
                return true;
        }
        return false;
    }
    public static boolean isLeftHalf(String s) {
        switch (s) {
            case "(":
                return true;
            case "{":
                return true;
            case "[":
                return true;
        }
        return false;
    }

    public static String LookForTheOtherHalf(String s) {

        switch (s) {
            case "(":
                return ")";
            case "{":
                return "}";
            case "[":
                return "]";
            case "}":
                return "{";
            case ")":
                return "(";
            case "]":
                return "[";
            default:
                return "";
        }
    }
}
