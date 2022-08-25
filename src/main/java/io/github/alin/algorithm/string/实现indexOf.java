package io.github.alin.algorithm.string;

public class 实现indexOf {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("lello", "ll"));
        System.out.println(strStr("bbb", "aa"));
    }

    public static int sttStr2(String haystack, String needle) {
        int length = needle.length();
        int total = haystack.length() - length + 1;
        for (int i = 0; i < total; i++) {
            if (haystack.substring(i, i + length).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || haystack.equals("") || needle == null || needle.equals("")) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == needle.length()) {
                return i - j;
            }

        }
        return -1;
    }
}
