package algo.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import algo.java.TreeNodeUtils.TreeNode;

public class BinaryTreeRightSideView {

    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null)
                return List.of();
            var result = new ArrayList<Integer>();
            var queue = new ArrayDeque<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    var node = queue.poll();
                    if (i == size - 1)
                        result.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }
            return result;
        }
    }

    @Test
    public void binaryTreeRightSideViewTest() {
        var solution = new Solution();
        var tree = TreeNode.of(new Integer[] { 1, 2, 3, null, 5, null, 4 });
        Assert.assertEquals(List.of(1, 3, 4), solution.rightSideView(tree));
        tree = TreeNode.of(new Integer[] { 1, null, 3 });
        Assert.assertEquals(List.of(1, 3), solution.rightSideView(tree));
        tree = TreeNode.of(new Integer[] {});
        Assert.assertEquals(List.of(), solution.rightSideView(tree));
    }

}
