package io.github.alin.algorithm.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 分数到小数 {

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(4,2));
        System.out.println(fractionToDecimal(1,2));
        System.out.println(fractionToDecimal(1,3));
    }
    /**
     * 4/2
     * 1/2 0,0., 1*10/2->5 1*10%2=0
     * 1/3
     */
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        Map<Integer,Integer> set = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int m = numerator / denominator;
        sb.append(m);
        int mo = numerator % denominator;
        set.put(mo,1);
        if (mo == 0) {
            return sb.toString();
        }
        sb.append(".");
        StringBuilder y = new StringBuilder();
        while (mo != 0) {
            int divide = numerator * 10 / denominator;
            y.append(divide);
            mo = numerator * 10 % denominator;
            if (set.containsKey(mo)){
                return sb.append("("+y+")").toString();
            }
        }
        return sb.append(y).toString();
    }

}
