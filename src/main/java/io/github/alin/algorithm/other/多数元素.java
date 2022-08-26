package io.github.alin.algorithm.other;

import java.util.Arrays;

public class 多数元素 {


    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 输入：nums = [3,2,3]
     * 输出：3
     * <p>
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElementV2(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result = nums[i + 1];
                }
            }
        }
        return result;
    }

}

