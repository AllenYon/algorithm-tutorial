package io.github.alin.algorithm.tree;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn08xg/
 */
public class 验证二叉搜索树 {


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }

        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);

    }
}
