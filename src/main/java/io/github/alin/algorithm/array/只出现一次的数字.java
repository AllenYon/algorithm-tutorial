package io.github.alin.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class 只出现一次的数字 {

    public static void main(String[] args) {
        只出现一次的数字 a = new 只出现一次的数字();
        System.out.println(a.singleNumber(new int[]{2, 2, 11, 11, 4, 3, 3}));
        System.out.println(a.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            if (map.containsKey(i)) {
                int a = map.get(i);
                map.put(i, ++a);
            } else {
                map.put(i, 1);
            }
        }
        for (Integer item : map.keySet()) {
            if (map.get(item) == 1) {
                return item;
            }
        }
        return -1;
    }
}
