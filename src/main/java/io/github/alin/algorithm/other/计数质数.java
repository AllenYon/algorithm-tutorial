package io.github.alin.algorithm.other;

public class 计数质数 {

    public static void main(String[] args) {
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(10));
    }

    /**
     * 埃氏筛
     *
     * @param n
     * @return
     */
    public static int countPrimesV2(int n) {
        boolean[] x = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (x[i] == true) {
                continue;
            }
            count++;
            for (int j = i; j < n; j += i) {
                x[j] = true;
            }
        }
        return count;
    }

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrimes(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
