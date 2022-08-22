package io.github.alin.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(subList);
        }
        return res;
    }
}
