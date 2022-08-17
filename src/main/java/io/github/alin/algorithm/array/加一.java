package io.github.alin.algorithm.array;

import java.util.Arrays;

public class 加一 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(plusone(new int[]{1, 2, 3})));
//        System.out.println(Arrays.toString(plusone(new int[]{4, 3, 2, 1})));
//        System.out.println(Arrays.toString(plusone(new int[]{0})));
    }
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                //如果数组当前元素不等于9，直接加1
                //然后直接返回
                digits[i]++;
                return digits;
            } else {
                //如果数组当前元素等于9，那么加1之后
                //肯定会变为0，我们先让他变为0
                digits[i] = 0;
            }
        }
        //除非数组中的元素都是9，否则不会走到这一步，
        //如果数组的元素都是9，我们只需要把数组的长度
        //增加1，并且把数组的第一个元素置为1即可
        int temp[] = new int[length + 1];
        temp[0] = 1;
        return temp;
    }

//    public static int[] plusone(int[] digits) {
//        int[] r = new int[digits.length];
//        for (int i = 0; i < digits.length; i++) {
//            r[i] = (int) (digits[i] * Math.pow(10, digits.length - i - 1));
//        }
//        r[0] += 1;
//        return r;
//    }

}
