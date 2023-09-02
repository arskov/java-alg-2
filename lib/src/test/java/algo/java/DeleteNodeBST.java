package algo.java;

import org.junit.Assert;
import org.junit.Test;

import algo.java.TreeNodeUtils.TreeNode;

public class DeleteNodeBST {

    class Solution {

        private int successor(TreeNode root) {
            var next = root.right;
            while (next.left != null)
                next = next.left;
            return next.val;
        }

        private int predecessor(TreeNode root) {
            var next = root.left;
            while (next.right != null)
                next = next.right;
            return next.val;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;
            if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else {
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.right != null) {
                    root.val = successor(root);
                    root.right = deleteNode(root.right, root.val);
                } else {
                    root.val = predecessor(root);
                    root.left = deleteNode(root.left, root.val);
                }
            }
            return root;
        }
    }

    @Test
    public void deleteNodeBSTTest() {
        var solution = new Solution();

        var test1 = TreeNode.of(new Integer[] { 5, 3, 6, 2, 4, null, 7 });
        var expected1 = TreeNode.of(new Integer[] { 5, 4, 6, 2, null, null, 7 });
        Assert.assertEquals(null, expected1, solution.deleteNode(test1, 3));

        var test2 = TreeNode.of(new Integer[] { 5, 3, 6, 2, 4, null, 7 });
        var expected2 = TreeNode.of(new Integer[] { 5, 3, 6, 2, 4, null, 7 });
        Assert.assertEquals(null, expected2, solution.deleteNode(test2, 0));

        var test3 = TreeNode.of(new Integer[0]);
        var expected3 = TreeNode.of(new Integer[0]);
        Assert.assertEquals(null, expected3, solution.deleteNode(test3, 0));
    }
}
