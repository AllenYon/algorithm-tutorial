package io.github.alin.algorithm.string;

public class 外观数列 {

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
        System.out.println(countAndSay(8));
    }

    public String countAndSayv2(int n) {
        // 递归出口
        if(n==1){
            return "1";
        }
        // 假设我们获得上一次的结果为 s1 = 112213
        String s1 = countAndSayv2(n - 1);
        // 定义结果
        StringBuilder result = new StringBuilder();
        // 对s1遍历处理获取值
        char local = s1.charAt(0);
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            // 设定计数器 计算同一个数字出现的次数 count
            if(s1.charAt(i) == local){
                count++;
            }else {
                // 不符合，记录下
                result.append(count);
                result.append(local);
                count = 1;
                local = s1.charAt(i);
            }
        }
        result.append(count);
        result.append(local);
        return result.toString();
    }


    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String result = "11";
        for (int i = 3; i <= n; i++) {
            result = countAndSay(result);
        }
        return result;
    }

    /**
     * 11 -> 21
     * 21 -> 1211
     * 111221 ->312211
     */
    public static String countAndSay(String s) {

        char[] x = s.toCharArray();
        String result = "";
        int count = 1;
        char num = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i - 1] == x[i]) {
                count++;
            } else {
                result += count + "" + num;
                count = 1;
                num = x[i];
            }
        }
        result += count + "" + num;
        return result;
    }
}
