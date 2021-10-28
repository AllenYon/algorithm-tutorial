package com.alin.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDeep {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }


    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        int max = 0;
        for (Node node : root.children) {
            int tmp = maxDepth(node);
            if (tmp > max) {
                max = tmp;
            }
        }
        return max + 1;
    }


    public static void main(String[] args) {

        Node root = new Node(1, new ArrayList<>());
        root.children.add(new Node());
        root.children.add(new Node());
        Node child = new Node(1, new ArrayList<>());
        child.children.add(new Node());
        root.children.add(child);

        int max = maxDepth(root);
    }
}
