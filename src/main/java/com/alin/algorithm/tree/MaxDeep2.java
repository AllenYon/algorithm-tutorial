package com.alin.algorithm.tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDeep2 {


    static class TreeNode {
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {

        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 采用层次遍历的方法，类似bfs的解法
     * 每遍历一层，depth++;
     * 每一层，需使用一个变量len记录该层的结点个数，也就是队列的当前长度，
     * 然后依次在队列中访问该层的len个结点（将队列中len个元素出队列），并将下一层如队列。
     */
    public static int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            level++;
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return level;
    }


    public static void main(String[] args) {
        TreeNode root =new TreeNode(
                new TreeNode(
                        new TreeNode(
                                new TreeNode(),new TreeNode()
                        ),new TreeNode()
                ) ,
                new TreeNode(new TreeNode(),new TreeNode())
        );
        int max = maxDepth2(root);
    }
}
