package io.github.alin.algorithm.tree;

public class 相同的树 {

    public static void main(String[] args) {
        System.out.println();
//        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));

        System.out.println(isSameTree(root, root2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //前序遍历一样就是相同的树
        StringBuilder sb1 = new StringBuilder();
        preOrder(p, sb1);

        StringBuilder sb2 = new StringBuilder();
        preOrder(q, sb2);
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        if (sb1.toString().equals(sb2.toString())) {
            return true;
        }
        return false;
    }

    public static void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(node.val).append(",");
//        if (node.left != null) {
        preOrder(node.left, sb);
//        }
//        if (node.right != null) {
        preOrder(node.right, sb);
//        }

    }
}
