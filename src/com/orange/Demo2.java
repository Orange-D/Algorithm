package com.orange;

/**
 * Created  2018/9/30.
 * 将一个字符串中的空格替换成“%20”
 * 例如，当字符串为OH! bird is so big.则经过替换之后的字符串为OH!$$$bird$$$is$$$so$$$big。
 */
public class Demo2 {
    public static void main(String[] args) {
        String s = "OH! bird is so big";
        System.out.println(replaceStr(s));
    }

    public static String replaceStr(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" "))
                stringBuffer.append("$$$");
            else
                stringBuffer.append(str.charAt(i));
        }

        return stringBuffer.toString();
    }

}
