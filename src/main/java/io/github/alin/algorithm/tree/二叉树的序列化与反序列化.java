package io.github.alin.algorithm.tree;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * 1,2,3,null,null,4,5
 */
public class 二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        二叉树的序列化与反序列化 a = new 二叉树的序列化与反序列化();
        TreeNode root = a.deserialize("1,#,3,4,5");
        System.out.println(a.serialize(root));
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        Collections.addAll(nodes, data.split(","));
        return deserialize(nodes);
    }

    public TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String val = nodes.removeFirst();
        if ("#".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
