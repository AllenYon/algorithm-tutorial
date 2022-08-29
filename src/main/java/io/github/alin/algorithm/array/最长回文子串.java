package io.github.alin.algorithm.array;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    /**
     * 中心扩散法, 偶数跳过
     */
    public static String longestPalindrome(String s) {
        //1.边界判断
        if (s.length() < 2) {
            return s;
        }

        int start = 0;
        int max = 0;
        int length = s.length();

        for (int i = 0; i < length;) {

            //2. 过滤不必要计算
            if (length - i < max / 2) {
                break;
            }

            int left = i;
            int right = i;

            //3. 奇数偶数 条件
            while (right < length - 1 && s.charAt(right) == s.charAt(right + 1)) {
                ++right;
            }
            i = right + 1;

            //4. 从中心扩散查询
            while (left > 0 &&
                    right < length - 1 &&
                    s.charAt(left - 1) == s.charAt(right + 1)) {
                ++right;
                --left;
            }

            //5. 判断扩散距离是否 大于缓存max
            if (right - left + 1 > max) {
                start = left;
                max = right - left + 1;
            }

        }

        return s.substring(start, start + max);
    }
}
