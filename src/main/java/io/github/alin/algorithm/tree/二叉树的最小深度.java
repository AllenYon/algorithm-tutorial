package io.github.alin.algorithm.tree;

public class 二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return l + r + 1;
        }
        return Math.min(l, r) + 1;
    }

}
