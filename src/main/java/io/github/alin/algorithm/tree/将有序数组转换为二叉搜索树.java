package io.github.alin.algorithm.tree;


import com.oracle.javafx.jmx.json.impl.JSONStreamReaderImpl;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 */
public class 将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{-10,-3,0,5,9});

//        TreeNode.preorder(root);
//        System.out.println(TreeNode.preorder(root));
        System.out.println(二叉树的层序遍历.levelOrder(root));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = nums.length / 2;
        return new TreeNode(nums[mid],
                sortedArrayToBST(nums, left, mid - 1),
                sortedArrayToBST(nums, mid + 1, right));
    }

    public static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        return new TreeNode(nums[mid],
                sortedArrayToBST(nums, left, mid - 1),
                sortedArrayToBST(nums, mid + 1, right));
    }

}
