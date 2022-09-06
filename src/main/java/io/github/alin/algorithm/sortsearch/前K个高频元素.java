package io.github.alin.algorithm.sortsearch;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素 {

    /**
     * [1,1,1,2,2,3]
     * <p>
     * 1:3,2:2,3:1
     * 1.使用hashmap统计个数
     * 2. 使用priorityQueue 最大堆，进行排序
     * 3。取出前k个数
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
        }

        // [key,count]
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int key : map.keySet()) {
            priorityQueue.add(new int[]{key, map.get(key)});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }

}
