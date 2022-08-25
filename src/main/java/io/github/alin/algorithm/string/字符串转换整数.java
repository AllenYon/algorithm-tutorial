package io.github.alin.algorithm.string;

public class 字符串转换整数 {

    public int myAtoi(String s) {
        s = s.trim();

        int result = 0;
        int sign = 1;
        int length = s.length();
        int index = 0;
        if (s.charAt(index) == '-' || s.charAt(index) == '+')
            sign = s.charAt(index++) == '+' ? 1 : -1;

        for (; index < length; ++index) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                result = result * 10 + digit;
            }
        }
        return sign * result;
    }
}
