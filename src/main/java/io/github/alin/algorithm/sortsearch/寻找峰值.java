package io.github.alin.algorithm.sortsearch;

public class 寻找峰值 {
    public static void main(String[] args) {

        findPeakElement(new int[]{1, 2});
    }

    public static int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(i - 1 >=0 && nums[i - 1] > nums[i]) {
                continue;
            }
            if(i + 1 < nums.length && nums[i + 1] > nums[i]) {
                continue;
            }
            return i;
        }
        return -1;
    }
}
