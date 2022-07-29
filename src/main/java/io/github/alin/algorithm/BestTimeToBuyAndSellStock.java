package io.github.alin.algorithm;


public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices2));
    }


    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int max = 0;

        // 一维表示第i天
        // 二维表示交易状态: 0没有买卖， 1买入 ,2卖出
        int[][] mp = new int[n][3];
        mp[0][0] = 0;
        mp[0][1] = -prices[0];
        mp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            mp[i][0] = mp[i - 1][0];
            mp[i][1] = Math.max(mp[i - 1][1], mp[i - 1][0] - prices[i]);
            mp[i][2] = mp[i - 1][1] + prices[i];
            for (int j = 0; j <= 2; j++) {
                if (max < mp[i][j]) {
                    max = mp[i][j];
                }
            }
        }
        return max;
    }
}
