package io.github.alin.algorithm.other;

import java.util.Arrays;

public class 缺失数字 {


    public int missingNumber(int[] nums) {
        int[] n = new int[nums.length + 1];
        Arrays.fill(n, 0);
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            n[index] = 1;
        }
        for (int j = 0; j < n.length; j++) {
            if (n[j] == 0) {
                return j;
            }
        }
        return 0;
    }

}
