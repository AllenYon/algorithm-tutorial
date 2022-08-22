package io.github.alin.algorithm.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋
 * 装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class 打家劫舍 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    /**
     * 定义 int[][] dp = new int[length][2]
     * dp[][0] 表示没有
     * dp[][1] 表示偷了
     * <p>
     * 如果 第i家没有偷， i-1 家 可能偷或没偷， 取 dp[i-1][0]和dp[i-1][1] 的最大值
     * dp[i][0] = max( dp[i-1][0], dp[i-1][1] )
     * <p>
     * 如果第i家偷了，第 i-1家没有偷，最大值等于 第dp[i-1]没偷最大值+i家可偷金额 dp[i-1][0]+nums[i]
     * dp[i][1] = dp[i-1][0]+nums[i]
     * <p>
     * 结果 从 dp[length-1][0], dp[length-1][1] 中取最大值
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }


    public static int robRecursion(int[] nums) {
        return robRecursion(nums, nums.length - 1);
    }

    public static int robRecursion(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        int i2 = robRecursion(nums, i - 2);
        int i1 = robRecursion(nums, i - 1);
        int i0 = i2 + nums[i];
        return Math.max(i1, i0);
    }

}
