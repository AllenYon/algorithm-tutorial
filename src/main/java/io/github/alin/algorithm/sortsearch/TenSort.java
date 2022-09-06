package io.github.alin.algorithm.sortsearch;

public class TenSort {


    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 1, 7, 9, 10, 5, 6, 4};
        //1.
        //selectSort(nums);
        //2.插入排序
//        insertSort(nums);
        //3.
//        bubbleSort(nums);
//        bubbleSortV2(nums);
        //4
//        shellSort(nums);
        //合并排序
//        mergeSort(nums);
        System.out.println(printInt(nums));
    }

    /**
     * 选择排序
     * 选择 i 到 size-1 中最小的值，与i进行交换，i++
     * 找到最小值与第0位交换，再找到最小值与第1位交换，以此类推
     * <p>
     * 时间复杂度：On2
     * 空间复杂度: O1
     * 非稳定排序，原地排序
     */
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            //swap
            swap(nums, i, min);
        }
    }

    /**
     * 3,1,2,4,5,
     * 1,3,2,4,5
     * <p>
     * 5,4,1,2,3
     * 4,5,1,2,3
     * 4,1,5,2,3,
     * 4,1,2,5,3
     * 4,1,2,3,5
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSortV2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                    swap(nums, j, j + 1);
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * <p>
     * 3,2,1,5
     * 2,3,1,5
     * T:On2
     * S:O1
     */
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j;
            for (j = i - 1; j >= 0 && nums[j] > tmp; j = j - 1) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = tmp;
        }
    }

    public static void shellSort(int[] nums) {
        for (int h = nums.length / 2; h > 0; h /= 2) {
            for (int i = h; i < nums.length; i++) {
                int tmp = nums[i];
                int j;
                for (j = i - h; j >= 0 && nums[j] > tmp; j = j - h) {
                    nums[j + h] = nums[j];
                }
                nums[j + h] = tmp;
            }
        }
    }


    public static void mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
    }

    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            mergeArray(array, left, mid, right, temp);
        }
    }

    public static void mergeArray(int[] array, int left, int mid, int right, int[] temp) {
        int originLeft = left;
        int mid1 = mid + 1;
        int k = 0;
        while (left <= mid && mid1 <= right) {
            if (array[left] <= array[mid1]) {
                temp[k++] = array[left++];
            } else {
                temp[k++] = array[mid1++];
            }
        }
        while (left <= mid) {
            temp[k++] = array[left++];
        }
        while (mid1 <= right) {
            temp[k++] = array[mid1++];
        }
        for (int i = 0; i < k; i++) {
            array[originLeft + i] = temp[i];
        }
    }


    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static String printInt(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append(",");
        }
        return sb.toString();
    }

}
