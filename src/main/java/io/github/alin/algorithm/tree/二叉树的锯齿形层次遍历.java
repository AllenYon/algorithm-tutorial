package io.github.alin.algorithm.tree;

import jdk.nashorn.internal.runtime.regexp.joni.ast.QuantifierNode;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 */
public class 二叉树的锯齿形层次遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeftToRight = true;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int count = queue.size();

            for (int i = 0; i < count; i++) {
                TreeNode treeNode = queue.poll();
                if (isLeftToRight) {
                    level.add(treeNode.val);
                } else {
                    level.add(0, treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            ans.add(level);
            isLeftToRight = !isLeftToRight;
        }
        return ans;
    }
}
