package algo.java;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import algo.java.TreeNodeUtils.TreeNode;

public class LeafSimilarTreesTest {
    static class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            var leafs1 = new ArrayList<Integer>();
            var leafs2 = new ArrayList<Integer>();
            visit(root1, leafs1);
            visit(root2, leafs2);
            return leafs1.equals(leafs2);
        }

        private void visit(TreeNode root, ArrayList<Integer> leafs) {
            if (root == null)
                return;
            if (root.left == null && root.right == null)
                leafs.add(root.val);
            visit(root.left, leafs);
            visit(root.right, leafs);
        }
    }

    @Test
    public void leafSimilarTreesTest() {
        var solution = new Solution();
        var tree1 = TreeNode.of(new Integer[] { 3, 5, 1, 6, 2, 9, 8, null, null, 7, 4 });
        var tree2 = TreeNode.of(new Integer[] { 3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8 });
        Assert.assertTrue(solution.leafSimilar(tree1, tree2));

        var tree3 = TreeNode.of(new Integer[] { 1, 2, 3 });
        var tree4 = TreeNode.of(new Integer[] { 1, 3, 2 });
        Assert.assertFalse(solution.leafSimilar(tree3, tree4));
    }
}
