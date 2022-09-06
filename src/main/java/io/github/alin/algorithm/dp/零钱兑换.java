package io.github.alin.algorithm.dp;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class 零钱兑换 {

    public static void main(String[] args) {
//        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(coinChange(new int[]{83, 186, 408, 419}, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        queue.add(new int[]{0, 0});
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            // step,num
            int[] q = queue.poll();
            if (q[1] == amount) {
                return q[0];
            }
            if (q[1] > amount) {
                continue;
            }

            for (int c : coins) {
                int subAmount = q[1] + c;
                if (!set.add(subAmount)) {
                    continue;
                }
                if (subAmount <= amount) {
                    queue.add(new int[]{q[0] + 1, subAmount});
                }
            }
        }
        if (!set.contains(amount)) {
            return -1;
        }
        return -1;
    }

}
