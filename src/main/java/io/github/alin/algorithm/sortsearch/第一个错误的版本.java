package io.github.alin.algorithm.sortsearch;

import java.util.Arrays;

public class 第一个错误的版本 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion2(15));
//        System.out.println(firstBadVersion(15));
//        System.out.println(firstBadVersion(8));
//        System.out.println(firstBadVersion(2));
//        System.out.println(firstBadVersion(2));
    }

    public static int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int version) {
        if (version >= 2) {
            return true;
        }
        return false;
    }


    /**
     * 1 2 3 4 5 ->
     * 0 1 2 3 4 5 6 7 8
     *
     * <p>
     * 二分查找
     *
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {
        if (n <= 1) {
            return n;
        }
        //二分查找
        int left = 1;
        int right = n;

        while (left < right) {
            int index = left + (right - left) / 2;
            if (isBadVersion(index)) {
                right = index;
            } else {
                left = index + 1;
            }
        }
        return left;
    }


}
