package io.github.alin.algorithm.other;

public class 位1的个数 {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if (((n >>> 1) & 1) == 1) {
                result++;
            }
        }
        return result;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

}
