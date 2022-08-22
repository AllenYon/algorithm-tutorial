package io.github.alin.algorithm.other;

import javax.crypto.spec.PSource;

public class 汉明距离 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
        System.out.println(hammingDistance(3,1));
    }

    public static int hammingDistance(int x, int y) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int d = (x>>i & 1) ^ (y>>i & 1);
            if (d == 1) {
                result++;
            }
        }
        return result;
    }
}
