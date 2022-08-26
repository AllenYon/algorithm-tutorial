package io.github.alin.algorithm.other;

/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 * 示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xwaiag/
 */
public class 两整数之和 {

    public static void main(String[] args) {

        System.out.println(getSum(1, 2));
        System.out.println(getSum(2, 3));
    }

    /**
     * ^ 异或=半加   0^1=1 1^0=1 0^0=0 1^1=0
     * <p>
     * & 与
     */
    public static int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        int aa = (a & b) << 1;
        int bb = a ^ b;
        return getSum(aa, bb);
    }
}
