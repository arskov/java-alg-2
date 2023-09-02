package algo.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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

        private void dfs(TreeNode node, List<Integer> res) {
            if (node == null) return;
            dfs(node.left, res);
            res.add(node.val);
            dfs(node.right, res);
        }

        private List<Integer> toInOrderArray() {
            var res = new ArrayList<Integer>();
            dfs(this, res);
            return res;
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof TreeNode) {
                var otherTree = (TreeNode) other;
                var a = this.toInOrderArray();
                var b = otherTree.toInOrderArray();
                return a.equals(b);
            }
            return false;
        }

    }

}
