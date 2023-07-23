package algo.java;

import java.util.ArrayDeque;

public final class TreeNodeUtils {
    private TreeNodeUtils() {
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static TreeNode of(Integer[] tree) {
            if (tree == null || tree.length == 0)
                return null;
            var root = new TreeNode(tree[0]);
            var queue = new ArrayDeque<TreeNode>();
            queue.add(root);
            int idx = 0;
            while (!queue.isEmpty()) {
                int prevLevelSize = queue.size();
                for (int i = 0; i < prevLevelSize; i++) {
                    var node = queue.pollFirst();
                    if (idx + 1 < tree.length) {
                        var val = tree[idx + 1];
                        if (val != null) {
                            var leftNode = new TreeNode(val);
                            node.left = leftNode;
                            queue.add(leftNode);
                        }
                    }
                    if (idx + 2 < tree.length) {
                        var val = tree[idx + 2];
                        if (val != null) {
                            var rightNode = new TreeNode(tree[idx + 2]);
                            node.right = rightNode;
                            queue.add(rightNode);
                        }
                    }
                    idx += 2;
                }
            }
            return root;
        }

    }

}
