package io.github.alin.algorithm.sortsearch;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 */
public class 搜索旋转排序数组 {

    /**
     * 4,5,6,7,0,1,2
     * .....mid
     * 6,7,0,1,2,4,5
     * .....mid
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = -1;

        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[left]) {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return mid;
    }
}

