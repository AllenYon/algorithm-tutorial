package io.github.alin.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {

    public static void main(String[] args) {
        System.out.println(permuteV2(new int[]{1, 2, 3}));
//        System.out.println(permute(new int[]{1, 2, 3}));
    }


    public static List<List<Integer>> permuteV2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackV2(nums, 0, res);
        return res;
    }

    private static void backtrackV2(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length - 1) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) {
                tempList.add(num);
            }
            res.add(tempList);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            backtrackV2(nums, index + 1, res);
            swap(nums, index, i);
        }

    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }

    }
}
