//package io.github.alin.algorithm.tree;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
// * <p>
// * 如果树中有不止一个众数，可以按 任意顺序 返回。
// * <p>
// * 假定 BST 满足如下定义：
// * <p>
// * 结点左子树中所含节点的值 小于等于 当前节点的值
// * 结点右子树中所含节点的值 大于等于 当前节点的值
// * 左子树和右子树都是二叉搜索树
// * <p>
// * ....1
// * ..0...2
// * -1.0.2.3
// *
// * -1,0,0,1,2,2,3
// */
//public class 二叉搜索树中的众数 {
//
//    public int[] findMode(TreeNode root) {
//        if (root == null) {
//            return new int[0];
//        }
//        List<Integer> list = new ArrayList<>();
//        dfs(root, list);
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i : list) {
//            if (!map.containsKey(i)) {
//                map.put(i, 1);
//            } else {
//                map.put(i, map.getOrDefault(i, 1) + 1);
//            }
//        }
//
//    }
//
//    public void dfs(TreeNode root, List<Integer> list) {
//        if ()
//        if (root.left != null) {
//            dfs(root.left, list);
//        }
//        list.add(root.val);
//        if (root.right != null) {
//            dfs(root.right, list);
//        }
//    }
//
//}
