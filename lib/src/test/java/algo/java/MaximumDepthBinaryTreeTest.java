package algo.java;

import org.junit.Assert;
import org.junit.Test;

import algo.java.TreeNodeUtils.TreeNode;

public class MaximumDepthBinaryTreeTest {
    static class Solution {

        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            int max = Math.max(left, right) + 1;
            return max;
        }
    }

    @Test
    public void maximumDepthBinaryTreeTest() {
        var solution = new Solution();
        var tree1 = TreeNode.of(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        Assert.assertEquals(3, solution.maxDepth(tree1));

        var tree2 = TreeNode.of(new Integer[] { 1, null, 2 });
        Assert.assertEquals(2, solution.maxDepth(tree2));
    }
}
