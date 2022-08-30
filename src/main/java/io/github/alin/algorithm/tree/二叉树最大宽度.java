package io.github.alin.algorithm.tree;

import apple.laf.JRSUIUtils;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * <p>
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 */
public class 二叉树最大宽度 {

    static Map<Integer, Integer> levelMin = new HashMap<>();

    public static int widthOfBinaryTreeV2(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public static int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        levelMin.putIfAbsent(depth, index);

        int maxWidth = index - levelMin.get(depth) + 1;

        int left = dfs(node.left, depth + 1, index * 2);
        int right = dfs(node.right, depth + 1, index * 2 + 1);
        int leftOrRight = Math.max(left, right);
        return Math.max(maxWidth, leftOrRight);
    }


    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 1;
        List<Pair<TreeNode, Integer>> list = new ArrayList<>();
        list.add(new Pair<>(root, 1));
        while (!list.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : list) {
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if (node.left != null) {
                    tmp.add(new Pair<>(node.left, index * 2));
                }
                if (node.right != null) {
                    tmp.add(new Pair<>(node.right, index * 2 + 1));
                }
            }
            maxWidth = Math.max(maxWidth, list.get(list.size() - 1).getValue() - list.get(0).getValue() + 1);
            list = tmp;
        }
        return maxWidth;
    }

}
