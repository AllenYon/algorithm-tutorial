package io.github.alin.algorithm.array;

public class 移动零 {

    public static void main(String[] args) {
        System.out.println(moveZeroes(new int[]{1, 0, 3, 0, 12}));
    }

    /**
     * 1,0,3,0,12
     *
     * @param nums
     * @return
     */
    public static boolean moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        return false;
    }
}
