package io.github.alin.algorithm.array;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素 {

    public static void main(String[] args) {
        存在重复元素 a =new 存在重复元素();
        System.out.println(a.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(a.containsDuplicate(new int[]{1,2,3,4}));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() == nums.length) {
            return false;
        } else {
            return true;
        }
    }
}
