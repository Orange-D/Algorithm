package com.orange;

/**
 * 归并算法核心（分而治之）
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 */
public class Demo7 {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        //临时数组 ，临时存储交换后的数组
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length - 1,temp);
        System.out.println(arr);
    }


    //用递归实现数组的分割
    private static void sort(int arr[],int left,int right,int []temp){
        if (left < right){

            int mid = (left + right)/2;

            sort(arr,left,mid,temp);    //左边归并排序

            sort(arr,mid+1,right,temp); //右边归并排序

            merge(arr,left,mid,right,temp);
        }
    }

    private static void merge(int arr[],int left,int mid,int right,int []temp){
        int i = left;
        int j = mid +1;

        int t = 0;
        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j<= right){
            temp[t++] = arr[j++];
        }

        t = 0;
        //用临时数据的排序 替换掉arr数组中的数据
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
