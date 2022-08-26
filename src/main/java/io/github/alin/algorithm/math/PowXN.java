package io.github.alin.algorithm.math;

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 */
public class PowXN {

    public static void main(String[] args) {
        System.out.println(myPow3(2, -2));
//        System.out.println(myPow(2, 5));
//        System.out.println(myPow(2, 7));
//        System.out.println(myPow(2, 8));
    }

    /**
     * 2^10 =  (2*2)^5
     * <p>
     * 循环
     */
    public static double myPow(double x, int n) {
        double ans = 1.0;
        int m = n;
        while (m != 0) {
            if (m % 2 != 0) {
                ans *= x;
            }
            x *= x;
            m = m / 2;
        }
        return n > 0 ? ans : 1 / ans;
    }

    public double myPow2(double x, int n) {
        double ans = 1.0;
        int m = n;
        while (m != 0) {
            if (m % 2 != 0) {
                ans = ans * x;
            }
            x *= x;
            m = m / 2;
        }
        return n > 0 ? ans : 1 / ans;
    }

    public static double myPow3(double x, int n) {
        double res = myPowH(x, n);
        return n >= 0 ? res : 1 / res;
    }

    public static double myPowH(double x, int n) {
        if (n == 0) {
            return 1;
        }
//        if ((n & 1) == 1) {
        if (n % 2 == 1 || n % 2 == -1) {
            return x * myPow3(x * x, n / 2);
        }
        return myPow3(x * x, n / 2);
    }
}
