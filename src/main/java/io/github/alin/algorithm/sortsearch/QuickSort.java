package io.github.alin.algorithm.sortsearch;

public class QuickSort {

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 1, 7, 9, 10, 5, 6, 4};
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 30, 40, 50, 3, 2, 1, 7, 9, 10, 5, 6, 4};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(SortHelper.printInt(nums));
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        nums[left] = nums[j];
        nums[j] = pivot;
        return j;
    }

    public static int partitionV2(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
