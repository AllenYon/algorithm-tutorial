package io.github.alin.algorithm.other;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {

    public static void main(String[] args) {
//        System.out.println(romanToInt("MCMXCIV"));
//        System.out.println(romanToInt("III"));

        System.out.println(romanToIntV2("MCMXCIV"));
    }


    public static int romanToIntV2(String s) {
        int sum = 0;
        //前一个数字表示的值
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            //如果前一个数字比现在数字小，说明
            //前一个字符和现在字符组合成一个有效数字，
            if (preNum < num) {
                sum -= preNum;
            } else {
                //如果前一个数字不比现在数字小，说明
                //每个字符都是一个有效的数字
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }


    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        char[] chars = s.toCharArray();

        int result = 0;
        for (int i = 0; i < chars.length;) {

            result += m.get(chars[i]);
            if (chars[i] == 'I' && (i + 1) < chars.length) {
                if (chars[i + 1] == 'V' || chars[i + 1] == 'X') {
                    result = result + m.get(chars[i + 1]) - 2 * m.get(chars[i]);
                    i+=2;
                    continue;
                }
            }

            if (chars[i] == 'X' && (i + 1) < chars.length) {
                if (chars[i + 1] == 'L' || chars[i + 1] == 'C') {
                    result = result + m.get(chars[i + 1]) - 2 * m.get(chars[i]);
                    i+=2;
                    continue;
                }
            }
            if (chars[i] == 'C' && (i + 1) < chars.length) {
                if (chars[i + 1] == 'D' || chars[i + 1] == 'M') {
                    result = result + m.get(chars[i + 1]) - 2 * m.get(chars[i]);
                    i+=2;
                    continue;
                }
            }
            i++;
        }

        return result;
    }

}
