package io.github.alin.algorithm.array;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
        }
        return 0;
    }

    public static int lengthOfLongestSubstringV2(String s) {
        Queue<Character> queue = new LinkedList<>();
        int max = 0;
        for (char item : s.toCharArray()) {
            while (queue.contains(item)) {
                queue.poll();
            }
            queue.add(item);
            max = Math.max(max, queue.size());
        }
        return max;
    }

}
