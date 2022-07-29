package io.github.alin.algorithm;

public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3};
        删除排序数组中的重复项 a = new 删除排序数组中的重复项();
        int length = a.removeDuplicates(nums);
        System.out.println("length:" + length);
    }

    /**
     * [0,0,1,1,2,2,3]
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] == nums[right]) {
            } else {
                ++left;
                nums[left] = nums[right];
            }
        }
        return ++left;
    }
}
