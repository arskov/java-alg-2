package algo.java;

import org.junit.Assert;
import org.junit.Test;

import algo.java.TreeNodeUtils.TreeNode;

public class SearchBinarySearchTree {
    static class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null)
                return null;
            if (root.val == val)
                return root;
            else if (val < root.val)
                return searchBST(root.left, val);
            else
                return searchBST(root.right, val);
        }
    }

    @Test
    public void searchBinarySearchTreeTest() {
        var solution = new Solution();

        var tree = TreeNode.of(new Integer[] { 4, 2, 7, 1, 3 });
        var res = solution.searchBST(tree, 2);
        Assert.assertNotNull(res);
        Assert.assertEquals(2, res.val);

        tree = TreeNode.of(new Integer[] { 4, 2, 7, 1, 3 });
        res = solution.searchBST(tree, 5);
        Assert.assertNull(res);
    }
}
