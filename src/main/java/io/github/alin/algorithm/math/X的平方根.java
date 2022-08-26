package io.github.alin.algorithm.math;


/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * 二分查找
 */
public class X的平方根 {

    public int mySqrt(int x) {
        long left = 1;
        long right = x / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long t = mid * mid;
            if (t > x) {
                right = mid - 1;
            } else if (t == x) {
                return (int) mid;
            } else {
                long tt = (mid + 1) * (mid + 1);
                if (tt > x) {
                    return (int) mid;
                }
                left = mid + 1;
            }
        }
        return -1;
    }


}
