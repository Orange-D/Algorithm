package com.orange;

/**
 * Created  2018/9/30.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完 成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * 思路：从右上角或左下角开始找，逐行删除
 */
public class Demo1 {
    public static void main(String[] args) {
        int arr[][] = new int[][]{
                {1,3,5,7,9},
                {2,4,6,8,10},
                {3,5,7,9,11},
                {5,6,8,10,12},
                {30,32,35,36,38}
        };
        int target = 35;
        if (findNum(arr,target))
            System.out.println("target 存在于arr数组中");
        else
            System.out.println("my lady gaga");
    }

    public static boolean findNum(int [][]arr,int target){
        if(arr == null) return false;
        int row = 0;
        //最后一列的数是所在行的最大数，
        //比对最后一列的数，大于目标数的话，列减-1，  小于目标数 行+1
        int column = arr[0].length-1;

        while (row < arr.length && column > 0) {
            if (arr[row][column] == target) {
                System.out.println("index"+" "+row +" "+column);
                System.out.println("arr"+arr[row][column]);
                return true;
            }

            if (arr[row][column] > target){
                column--;
            }else if(arr[row][column] < target){
                row++;
            }
        }
        return false;
    }

}
