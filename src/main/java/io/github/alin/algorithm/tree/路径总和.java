package io.github.alin.algorithm.tree;

public class 路径总和 {


    /**
     * 5,4,8
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {

        return pathSum(root, root.val, targetSum);

    }

    public boolean pathSum(TreeNode node, int sum, int targetSum) {
        if (sum == targetSum) {
            return true;
        }
        boolean result = false;
        if (node.left != null) {
            result |= pathSum(node.left, sum + node.left.val, targetSum);
        }
        if (node.right != null) {
            result |= pathSum(node.right, sum + node.right.val, targetSum);
        }
        return result;
    }

}
