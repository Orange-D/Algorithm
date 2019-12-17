package com.orange;

import java.util.ArrayList;
import java.util.List;

public class Demo22 {
    public static void main(String[] args) {
        prime();
    }

    public static void prime() {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 2; i <= 100000; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
//                System.out.print(" " + i);
                list.add(i);
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i) * list.get(j) == 707829217)
                {
                    System.out.println(list.get(i) +" "+ list.get(j));
                }
            }
        }
    }
}
