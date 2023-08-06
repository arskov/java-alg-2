package algo.java;

import org.junit.Assert;
import org.junit.Test;

import algo.java.TreeNodeUtils.TreeNode;

public class LongestZigZagPathBinaryTree {
    static class Solution {

        public int longestZigZag(TreeNode root) {
            return Math.max(
                    dfs(root.right, 0, 0),
                    dfs(root.left, 0, 1));

        }

        private int dfs(TreeNode root, int level, int dir) {
            if (root == null)
                return level;
            if (dir == 0) {
                return Math.max(
                        dfs(root.left, level + 1, dir ^ 1),
                        dfs(root.right, 0, 0));
            } else {
                return Math.max(
                        dfs(root.right, level + 1, dir ^ 1),
                        dfs(root.left, 0, 1));
            }
        }
    }

    @Test
    public void longestZigZagPathBinaryTreeTest() {
        var solution = new Solution();
        var tree1 = TreeNode.of(new Integer[] { 1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1 });
        Assert.assertEquals(3, solution.longestZigZag(tree1));
        var tree2 = TreeNode.of(new Integer[] { 1, 1, 1, null, 1, null, null, 1, 1, null, 1 });
        Assert.assertEquals(4, solution.longestZigZag(tree2));
        var tree3 = TreeNode.of(new Integer[] { 1 });
        Assert.assertEquals(0, solution.longestZigZag(tree3));
    }
}
