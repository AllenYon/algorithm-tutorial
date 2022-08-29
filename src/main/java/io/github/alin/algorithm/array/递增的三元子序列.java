package io.github.alin.algorithm.array;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 */
public class 递增的三元子序列 {

    /**
     *
     * 1,2,3,4,5
     *
     * 3,2,1,4,5
     * 先找到最小i，再找到第二小j, 如果 有大于j的数，就返回
     */
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        int k = 0;
        for (int l = 0; l < nums.length; l++) {

            int target = nums[l];
            if (target < i) {
                i = target;
            } else if (target > i && target < j) {
                j = target;
            }
            else if (target>j){
                return true;
            }
        }
        return false;
    }
}
