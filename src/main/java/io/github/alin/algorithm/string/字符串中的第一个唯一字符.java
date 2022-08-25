package io.github.alin.algorithm.string;


public class 字符串中的第一个唯一字符 {


    /**
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     * 示例 1：
     * 输入: s = "leetcode"
     * 输出: 0
     */
    public int firstUniqChar(String s) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            c[x]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            if (c[x]==1){
                return i;
            }
        }
        return -1;
    }
}
