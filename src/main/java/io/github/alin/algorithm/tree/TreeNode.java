package io.github.alin.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;

    }


    public static List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder2(root, list);
        return list;
    }

    private static void preorder2(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder2(root.left, result);
        preorder2(root.right, result);
    }

}