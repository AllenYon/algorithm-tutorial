package io.github.alin.algorithm.string;

import sun.security.util.math.IntegerModuloP;

public class 整数反转 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MAX_VALUE-1));
        System.out.println(reverse(Integer.MIN_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE+1));
    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * 示例 1：
     * 输入：x = 123
     * 输出：321
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int y = x % 10;
            int newResult = result * 10 + y;

            if ((newResult - y) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
