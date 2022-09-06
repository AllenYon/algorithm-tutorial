package io.github.alin.algorithm.tree;

public class 平衡二叉树 {

    public static void main(String[] args) {
//        TreeNode root = TreeNode.deserialize("3,9,20,#,#,15,7");
        TreeNode root = TreeNode.deserialize("3,9,#,#,20,15,7");

        isBalanced(root);

    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }


//    public boolean isBalanced(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if (Math.abs(height(root.left) - height(root.right)) <= 1) {
//            if (isBalanced(root.left) && isBalanced(root.right)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public int height(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        return Math.max(height(node.left), height(node.right)) + 1;
//    }
}
