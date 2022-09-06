package io.github.alin.algorithm.sortsearch;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 */
public class 数组中的第K个最大元素 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }

    /**
     * 1. heapify
     * 2。 heapsort
     * 3。 return kth
     * <p>
     * 30
     * 20,10
     * 50,60,15,9
     * <p>
     * 30,20,10,50,60,15,9
     * 0..1..2..3..4..5..6
     * <p>
     * 30,20,15,50,60,10,9
     * 30,60,15,50,20,10,9
     * 30
     * 60,15,
     * 50,20,10,9
     * <p>
     * 60,
     * 30,15,
     * 50,20,10,9
     * 60,
     * 50,15,
     * 30,20,10,9
     * <p>
     * 60,50,15,30,20,10,9
     */
    public static int findKthLargest(int[] nums, int k) {

        for (int i = nums.length - 1; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }

        int length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            //swap 0~lenght-1
            int t = nums[0];
            nums[0] = nums[i];
            nums[i] = t;
            heapify(nums, 0, --length);
        }
        return nums[nums.length - 1 - (k - 1)];
    }

    public static void heapify(int[] nums, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;  //lenght=7
        int lastIndex = i;
        if (left > length) {
            return;
        }

        if (left < length && nums[left] > nums[lastIndex]) {
            lastIndex = left;
        }
        if (right < length && nums[right] > nums[lastIndex]) {
            lastIndex = right;
        }

        if (lastIndex != i) {
            //swap
            int t = nums[i];
            nums[i] = nums[lastIndex];
            nums[lastIndex] = t;
            heapify(nums, lastIndex, length);
        }
    }


}
