package io.github.alin.algorithm.math;

public class Excel表列序号 {

    public static void main(String[] args) {
        System.out.println(titleToNumberV2("ZABCY"));
//        System.out.println(titleToNumberV2("ZY"));
//        System.out.println(titleToNumber("A"));
//        System.out.println(titleToNumber("AB"));
//        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumberV2(String columnTitle) {
        char[] target = columnTitle.toCharArray();
        int res = 0;
        for(char c:target){
            int curNum = c-'A'+1;
            res = res*26+curNum;
        }
        return res;
    }

    public static int titleToNumber(String columnTitle) {
        String reverse = new StringBuilder(columnTitle).reverse().toString();
        int result = 0;
        for (int i = 0; i < reverse.length(); i++) {
            char c = reverse.charAt(i);
            int ci = c - 'A' + 1;
            result += Math.pow(26,i) * ci;
        }
        return result;
    }
}
