package io.github.alin.algorithm.other;

import javafx.scene.control.RadioMenuItem;

import java.util.Arrays;
import java.util.Random;

public class 打乱数组 {

    private int[] nums;

    public 打乱数组(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] x = nums.clone();
        Random random = new Random();
        for (int i = 0; i < x.length; i++) {
            int j = random.nextInt(i + 1);
            if (i != j) {
                x[i] = x[i] + x[j];
                x[j] = x[i] - x[j];
                x[i] = x[i] - x[j];
            }
        }
        return x;
    }
}