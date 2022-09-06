package io.github.alin.algorithm.dp;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class 跳跃游戏 {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 2, 4, 5, 6, 6, 7, 8, 4, 1, 2, 3, 4};
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * dp[0]=num[0]=2;
     * dp[1] = max(dp[0]-1,nums[1]) = 1,3 =3
     * dp[2] = max(dp[1]-1,nums[2]) = 2,1 =2
     * dp[3] = max(dp[2]-1,nums[3]) = 1,1 =1
     */
    public static boolean canJumpV2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] == 0) {
                return false;
            } else if (dp[i] + i >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


//    public static boolean canJump(int[] nums) {
//        return findMax(nums, 0);
//    }
//
//    public static boolean findMax(int[] nums, int i) {
//        if (nums[i]==0){
//            return false;
//        }
//        if ((nums.length - 1 - i) <= nums[i]) {
//            return true;
//        }
//        int max = nums[i + 1];
//        int maxIndex = i + 1;
//        for (int j = i + 1; j < i + nums[i] + 1; j++) {
//            if (nums[j] >= max) {
//                max = nums[j];
//                maxIndex = j;
//            }
//        }
//        if (max == 0) {
//            return false;
//        } else {
//            return findMax(nums, maxIndex);
//        }
//    }

}
