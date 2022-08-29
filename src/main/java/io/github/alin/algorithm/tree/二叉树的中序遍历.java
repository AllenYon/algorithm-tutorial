package io.github.alin.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        help(root,ans);
        return ans;
    }
    public void help(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }
        help(root.left, ans);
        ans.add(root.val);
        help(root.right,ans);
    }

}
