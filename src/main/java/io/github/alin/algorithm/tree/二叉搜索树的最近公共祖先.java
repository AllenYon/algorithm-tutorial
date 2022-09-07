package io.github.alin.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树的最近公共祖先 {
    /**
     * 6
     * 2,8
     * 0,4,7,9
     * #,#,3,5
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(6,
                new TreeNode(2, new TreeNode(0), new TreeNode(4,
                        new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, new TreeNode(7), new TreeNode(9)));

        TreeNode r = lowestCommonAncestor(root, root.left.right.right, root.right.left);
    }

    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = dfs(root, p);
        List<TreeNode> l2 = dfs(root, q);
        TreeNode result = root;
        for (int i = 0; i < l1.size() && i< l2.size(); i++) {
            if (l1.get(i)==l2.get(i)){
                result = l1.get(i);
            }
        }
        return result;
    }

    public static List<TreeNode> dfs(TreeNode root, TreeNode target) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            list.add(node);

            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        list.add(node);
        return list;
    }
}
