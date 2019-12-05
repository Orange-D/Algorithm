package com.orange;

public class Demo13 {

    public static void main(String[] args) {
        minTimeToVisitAllPoints(null);
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int seconds = 0 ;
        for (int i = 0; i < points.length -1 ; i++) {
            int[] point1 = points[i];
            int[] point2 = points[i+1];
            seconds += absoluteDistance(point1, point2);
        }
        return seconds;
    }

    public static int absoluteDistance(int[] point1, int[] point2) {
        int x = Math.abs(point2[0] - point1[0]);
        int y = Math.abs(point2[1] - point1[1]);
        return Math.max(x, y);
    }
}
