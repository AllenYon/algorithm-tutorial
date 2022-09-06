package io.github.alin.algorithm.sortsearch;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 */
public class 颜色分类 {

    public static void main(String[] args) {
//        int[] nums=new int[]{2,0,2,1,1,1};
//        int[] nums=new int[]{2,0,1};
        int[] nums = new int[]{1, 2, 0};
        sortColors(nums);
        System.out.println(SortHelper.printInt(nums));
    }

    /**
     * 原地排序
     * ki         j
     * 2,0,2,1,1,1
     * k i     j
     * 1,0,2,1,1,2
     * ki    j
     * 0,1,2,1,1,2
     * <p>
     * 0,1,1,1,2,2
     */
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                int t = nums[i];
                nums[i] = nums[left];
                nums[left] = t;
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                int t = nums[i];
                nums[i] = nums[right];
                nums[right] = t;
                right--;
            }
        }
    }

}
