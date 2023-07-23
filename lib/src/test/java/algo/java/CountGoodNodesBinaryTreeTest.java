package algo.java;

import org.junit.Assert;
import org.junit.Test;

import algo.java.TreeNodeUtils.TreeNode;

public class CountGoodNodesBinaryTreeTest {
    static class Solution {
        public int goodNodes(TreeNode root) {
            if (root == null)
                return 0;
            return dfs(root, Integer.MIN_VALUE);
        }

        private int dfs(TreeNode root, int max) {
            if (root == null)
                return 0;
            int maxSoFar = Math.max(max, root.val);
            int left = dfs(root.left, maxSoFar);
            int right = dfs(root.right, maxSoFar);
            if (root.val >= maxSoFar) {
                return 1 + left + right;
            } else {
                return left + right;
            }
        }
    }

    @Test
    public void countGoodNodesBinaryTreeTest() {
        var solution = new Solution();

        var test1 = new Integer[] { 3, 1, 4, 3, null, 1, 5 };
        Assert.assertEquals(4, solution.goodNodes(TreeNode.of(test1)));

        var test2 = new Integer[] { 3, 3, null, 4, 2 };
        Assert.assertEquals(3, solution.goodNodes(TreeNode.of(test2)));

        var test3 = new Integer[] { 1 };
        Assert.assertEquals(1, solution.goodNodes(TreeNode.of(test3)));
    }

}
