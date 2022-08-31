package io.github.alin.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
        list.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(list, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
