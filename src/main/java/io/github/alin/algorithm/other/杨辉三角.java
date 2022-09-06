package io.github.alin.algorithm.other;

import java.util.*;

public class 杨辉三角 {

    public static void main(String[] args) {
        System.out.println(11);
        System.out.println(Arrays.toString(generate(5).toArray()));
        System.out.println(Arrays.toString(generate(5).get(3).toArray()));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            res.add(new ArrayList<>(row));
        }

        String s ="";
        String[] ss = s.trim().split(" ");
        int a =  ss[ss.length-1].length();

        Map<String,String> m =new HashMap<>();
//        m.get("").equals(c)
//        m.put()
        return res;
    }

//    public static void xx(int numRows) {
//        int[] f = new int[1];
//        f[0] = 1;
//        for (int i = 0; i < numRows; i++) {
//            int[] n = sanjiao(f);
//        }
//    }
//
//    public static int[] sanjiao(int[] s) {
//        int[] r = new int[s.length + 1];
//        if (s.length <= 1) {
//            r[0] = 1;
//            r[1] = 1;
//            return r;
//        }
//        for (int i = 0; i < s.length; i++) {
//            if (i == 0 || i == (s.length - 1)) {
//                r[i] = 1;
//            }
//            r[i] = s[i - 1] + s[i];
//        }
//        return r;
//    }
}
