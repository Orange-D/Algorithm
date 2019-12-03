package com.orange;

/**
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 *
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Demo9 {

    public static void main(String[] args) {
        convert("ABCD", 3);
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        int len = Math.min(s.length(), numRows);
        String []rows = new String[len];
        for(int i = 0; i< len; i++) rows[i] = "";
        int loc = 0;
        boolean down = false;

        for(int i=0;i<s.length();i++) {
            rows[loc] += s.substring(i,i+1);
            if(loc == 0 || loc == numRows - 1)
                down = !down;
            loc += down ? 1 : -1;
        }

        String ans = "";
        for(String row : rows) {
            ans += row;
        }
        return ans;
    }

//    public static String convert(String s, int numRows) {
//        if (s.equals(""))
//            return "";
//        if (numRows < 2)
//            return s;
//        int column = calculateColumn(s, numRows);
//        String[][] zMatrix = new String[numRows][column];
//        int sIndex = 0;
//        int rIndex = 0;
//        int cIndex = 0;
//        int len = s.length();
//        boolean increase = true;
//        do {
//            String tempStr = String.valueOf(s.charAt(sIndex++));
//            zMatrix[rIndex][cIndex] = tempStr;
//
//            if (rIndex == numRows- 1){
//                increase = false;
//            }
//
//            if (rIndex == 0){
//                increase = true;
//            }
//
//
//            if (rIndex < numRows && increase){
//                rIndex++;
//            }
//
//            if (rIndex > 0 && !increase){
//                rIndex --;
//                cIndex ++;
//            }
//
//
//        }while (sIndex < len);
//        String printStr = "";
//        String rows[] = null;
//        for (int i = 0; i < zMatrix.length; i++) {
//             rows = zMatrix[i];
//            String result=String.join("", rows);
//            result = result.replace("null","");
//            printStr += result;
////            for (int j = 0; j < rows.length; j++) {
////                String str = rows[j];
////
////
////                if (str != null && !"".equals(str) ) {
////                    printStr+= str;
////                }
////            }
//        }
//        return printStr;
//    }
//
//    //计算总共多少行
//    /*
//     * L     D     R
//     * E   O E   I I
//     * E C   I H   N
//     * T     S     G
//     */
//    public static int calculateColumn(String s, int numRow) {
//        int len = s.length();
//        int column = 1;
//
//        if (numRow == 2) {
//            column = len%2 ==0?len/2:len/2+1;
//            return column;
//        }
//
//
//        //eg： 一个循环 leetco d开始属于下个循环内
//        //一个z单位循环有多少个字符，以及多少列
//
//        int divisor = 2 * numRow - 2;   //一个z单位循环有多少个字符
//        int divisorColumn = numRow - 1; //一个z单位循环有多少列
//
//
//
//        if (len > divisor) {
//            column = (len / divisor) * divisorColumn;
//            int remainder = len % divisor;
//            if (remainder != 0) {
//                int temp = remainder <= numRow ? 1 : remainder - numRow + 1;
//                column += temp;
//            }
//
//        }else {
//            int remainder = len % numRow;
//            if (remainder != 0) {
//                column += remainder;
//            }
//        }
//        return column;
//    }
}
