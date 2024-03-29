package io.github.alin.algorithm.sortsearch;

import sun.plugin2.ipc.windows.WindowsIPCFactory;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {

//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
//        int[] nums = new int[]{5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 10, 10, 10, 10};
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 7);
        System.out.println(SortHelper.printInt(result));

    }

    /**
     * 二分查找
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        int first = -1;

        while (left <= right) {
//            int mid = left + (right - left) / 2;
            int mid = (left+right)>>1;
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (first == -1) {
            return new int[]{-1, -1};
        }

        left = 0;
        right = nums.length - 1;
        int last = -1;
        while (left <= right) {
            int mid = (left+right)>>1;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return new int[]{first, last};
    }


}
