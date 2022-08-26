package io.github.alin.algorithm.other;

import java.util.HashMap;
import java.util.Map;

public class 快乐数 {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        return isHappy(n, new HashMap<>());
    }

    /**
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    public static boolean isHappy(int n, Map<Integer, Integer> map) {
        if (n == 1) {
            return true;
        }
        int result = 0;
        while (n != 0) {  //19  //1
            int x = n % 10; //x=9   //x=1
            result += x * x;  //result = 81  //82
            n = n / 10;  //n = 1  //n =0
        }
        if (map.containsKey(result)) {
            return false;
        } else {
            map.put(result, 1);
        }

        return isHappy(result, map);
    }

}
