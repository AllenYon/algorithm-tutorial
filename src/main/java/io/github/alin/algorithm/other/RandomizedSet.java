package io.github.alin.algorithm.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    // 变长数组可以在O1内完成随机获取，但是无法在O1内判断元素是否存在，所以不能O1内插入和删除
    private ArrayList<Integer> list;
    // hashmap 可以在O1内插入和删除，但是无法在O1内随机获取
    private HashMap<Integer, Integer> map; //
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();

    }

    /**
     * 先判断map中是否存在，否则返回false
     * 获取list最后一个index+1
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int index = list.size();
        list.add(val);
        map.put(val, index);
        return true;
    }

    /**
     * 如果map中不存在val，返回false
     *
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        //将最后一个数字，复制到即将被删除到index上
        list.set(index, last);
        //map同步更新
        map.put(last, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
