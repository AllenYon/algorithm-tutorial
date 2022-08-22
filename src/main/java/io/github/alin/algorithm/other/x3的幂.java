package io.github.alin.algorithm.other;

public class x3的幂 {
    public boolean isPowerOfThree2(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }


    /**
     * 2*3*3 = 18
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 == 0) {
            return isPowerOfThree(n / 3);
        } else {
            return false;
        }
    }
}
