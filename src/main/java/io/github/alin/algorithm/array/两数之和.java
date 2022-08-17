package io.github.alin.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static void main(String[] args) {
        System.out.println(twoSum2(new int[]{2, 7, 11, 15}, 9));
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> x = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];
            if (x.get(m) != null) {
                return new int[]{x.get(m), i};
            }
            x.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    /**
     * nums = [2,7,11,15], target = 9
     * <p>
     * 7->0
     * 2->1
     * -2->2
     * -6->3
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> x = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];
            if (x.get(nums[i]) != null) {
                return new int[]{x.get(nums[i]), i};
            }
            x.put(m, i);
        }
        return new int[]{0, 0};
    }

    /**
     * 暴力法
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == m) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}
