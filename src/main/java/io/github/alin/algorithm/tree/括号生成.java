package io.github.alin.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class 括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, n, "");
        return result;
    }

    private void dfs(List<String> result, int left, int right, String path) {
        // 终止条件
        if (left == 0 && right == 0) {
            result.add(path);
            return;
        }
        if (left < 0) {
            return;
        }
        if (right < left) {
            return;
        }

        dfs(result, left - 1, right, path + "(");
        dfs(result, left, right - 1, path + ")");
    }
}
