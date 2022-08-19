package io.github.alin.algorithm.other;

public class 颠倒二进制位 {

    public static void main(String[] args) {
        System.out.println(reverseBits(964176192));
    }

    /**
     * input: 0001101
     * output: 1011000
     */
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }
        return res;
    }
}
