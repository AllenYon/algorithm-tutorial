package io.github.alin.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class 从前序与中序遍历序列构造二叉树 {


    /**
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * <p>
     * ans: [3,9,20,null,null,15,7]
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }
        return helpr(preorderList, inorderList);
    }

    private TreeNode helpr(List<Integer> preorderList, List<Integer> inorderList) {
        if (inorderList.size() == 0) {
            return null;
        }
        int rootVal = preorderList.remove(0);
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderList.indexOf(rootVal);
        root.left = helpr(preorderList, inorderList.subList(0, mid));
        root.right = helpr(preorderList, inorderList.subList(mid + 1, inorderList.size()));
        return root;
    }

}
