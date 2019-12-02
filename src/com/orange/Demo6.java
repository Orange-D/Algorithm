package com.orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Demo6 {
    public static void main(String[] args) {
        System.out.println("orange");
        int[] nums1 = new int[]{1};
        int[] nums2 =new int[]{2,3,4};
        double medianNum = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianNum);
        
    }

    //归并算法 "治" 部分
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int count = length1 + length2;

        int index = 0;
        int i = 0; //nums1 指针
        int j = 0; //nums2 指针
        int[] tempArr = new int[count];

        //其中一个为空的时候，直接返回一个数组的中位数
        if (length1 == 0){
            int position1 = count/2;
            if (count % 2 == 0) {
                int position2 = count/2 -1;
                return ((double)nums2[position1] + (double)nums2[position2]) /2;
            }else {
                return nums2[position1];
            }
        }

        if (length2 == 0){
            int position1 = count/2;
            if (count % 2 == 0) {
                int position2 = count/2 -1;
                return ((double)nums1[position1] + (double)nums1[position2]) /2;
            }else {
                return nums1[position1];
            }
        }

        while (index != count) {
            if (i == length1){
                tempArr[index++] = nums2[j++];
                continue;
            }

            if (j == length2){
                tempArr[index++] = nums1[i++];
                continue;
            }

            if (nums1[i] < nums2[j]){
                tempArr[index++] = nums1[i++];
            }else{
                tempArr[index++] = nums2[j++];
            }

        }

        if (count % 2 == 0) {
            return ((double)tempArr[count/2] + (double)tempArr[count/2 -1]) /2;
        }else {
            return tempArr[count/2];
        }
//        ArrayList<Integer> list = new ArrayList();
//        list.addAll(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
//        list.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
//        for (int i = 0; i < list.size() - 1; i++) {
//            for (int j = 0; j < list.size() - 1 - i; j++) {
//                if (list.get(j) > list.get(j+1)){
//                    int temp = list.get(j+1);
//                    list.set(j+1,list.get(j));
//                    list.set(j,temp);
//                }
//            }
//        }
//
//        int position1 = list.size()/2;
//        if (list.size() % 2 == 0) {
//            int position2 = list.size()/2 -1;
//            return ((double)list.get(position1) + (double)list.get(position2)) /2;
//        }else {
//            return list.get(position1);
//        }

    }


}
