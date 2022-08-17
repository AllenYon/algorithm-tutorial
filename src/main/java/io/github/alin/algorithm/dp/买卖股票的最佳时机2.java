package io.github.alin.algorithm.dp;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2zsx1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 买卖股票的最佳时机2 {

    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int length = prices.length;
        int[][] dp = new int[length][2];
        //初始条件
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < length; i++) {
            //递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候，利润才会最大，
        //只需要返回dp[length - 1][0]即可
        return dp[length - 1][0];
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int length = prices.length;
        int hold = -prices[0];
        int noHold = 0;
        for (int i = 1; i < length; i++) {
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }
        return noHold;
    }

    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int total = 0;
        int index = 0;
        int length = prices.length;
        while (index < length) {
            while (index < length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            int min = prices[index];
            while (index < length - 1 && prices[index] <= prices[index + 1]) {
                index++;
            }
            total += prices[index] - min;

        }
        return total;
    }

    public static int maxProfit4(int[] prices){
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1]) {
                max = max + prices[i+1] - prices[i];
            }
        }
        return max;
    }
}
