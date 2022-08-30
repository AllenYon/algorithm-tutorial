package io.github.alin.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        dfs(result, 0, digits, tab, "");
        return result;
    }

    public static void dfs(List<String> result, int index, String digits, char[][] tab, String path) {
        if (path.length() == digits.length()) {
            result.add(path);
            return;
        }
        char[] chars = tab[digits.charAt(index) - '2'];
        for (int i = 0; i < chars.length; i++) {
            dfs(result, index + 1, digits, tab, path + chars[i]);
        }
    }

    public static List<String> letterCombinationsV2(String digits) {
        LinkedList<String> result = new LinkedList<>();
        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        result.add("");
        while (result.peek().length() != digits.length()) {
            String remove = result.poll();
            char[] chars = tab[digits.charAt(remove.length()) - '2'];
            for (int i = 0; i < chars.length; i++) {
                result.add(remove + chars[i]);
            }
        }
        return result;
    }
}
