package io.github.alin.algorithm.tree;

public class 二叉搜索树中第K小的元素 {


    int target = -1;
    int count ;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrderTraversal(root);
        return target;
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        if (--count == 0) {
            target = node.val;
            return;
        }
        inOrderTraversal(node.right);
    }
}
