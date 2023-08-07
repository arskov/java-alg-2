package algo.java;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

import algo.java.TreeNodeUtils.TreeNode;

public class MaximumLevelSumBinaryTree {
    static class Solution {
        public int maxLevelSum(TreeNode root) {
            if (root == null)
                return 0;
            var queue = new ArrayDeque<TreeNode>();
            int maxSum = root.val;
            int maxSumLevel = 1;
            int level = 1;
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int sum = 0;
                for (int i = 0; i < size; i++) {
                    var node = queue.poll();
                    sum += node.val;
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    maxSumLevel = level;
                }
                level++;
            }
            return maxSumLevel;
        }
    }

    @Test
    public void maximumLevelSumBinaryTreeTest() {
        var solution = new Solution();
        var tree = TreeNode.of(new Integer[] { 1, 7, 0, 7, -8, null, null });
        Assert.assertEquals(2, solution.maxLevelSum(tree));
        tree = TreeNode.of(new Integer[] { 989, null, 10250, 98693, -89388, null, null, null, -32127 });
        Assert.assertEquals(2, solution.maxLevelSum(tree));
    }
}
