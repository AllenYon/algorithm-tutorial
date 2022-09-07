package io.github.alin.algorithm.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 二叉树的所有路径 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,
                new TreeNode(2, new TreeNode(0), new TreeNode(4,
                        new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        List<String> paths = binaryTreePaths(root);

        for (int i = 0; i < paths.size(); i++) {
            System.out.println(paths.get(i));
        }
    }

    static List<String> paths;

    public static List<String> binaryTreePaths(TreeNode root) {
        paths = new ArrayList<>();
        dfs(root, "");
        return paths;
    }

    public static void dfs(TreeNode node, String path) {
        if (node.left == null && node.right == null) {
            paths.add(path + node.val);
            return;
        }
        if (node.left != null) {
            dfs(node.left, path + node.val + "->");
        }
        if (node.right != null) {
            dfs(node.right, path + node.val + "->");
        }
    }


}
