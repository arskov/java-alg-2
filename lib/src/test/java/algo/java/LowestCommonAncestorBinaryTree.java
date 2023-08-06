package algo.java;

import org.junit.Assert;
import org.junit.Test;

import algo.java.TreeNodeUtils.TreeNode;

public class LowestCommonAncestorBinaryTree {
    static class Solution {

        private Integer lca;

        public Integer lowestCommonAncestor(TreeNode root, Integer p, Integer q) {
            lca = null;
            dfs(root, p, q);
            return lca;
        }

        private boolean dfs(TreeNode root, Integer p, Integer q) {
            if (root == null)
                return false;
            if (p.equals(root.val) || q.equals(root.val)) {
                if (lca == null)
                    lca = root.val;
                return true;
            }
            var l = dfs(root.left, p, q);
            var r = dfs(root.right, p, q);
            if (l && r)
                lca = root.val;
            return l || r;
        }
    }

    @Test
    public void lowestCommonAncestorBinaryTreeTest() {
        var solution = new Solution();
        var tree1 = TreeNode.of(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
        Assert.assertEquals(Integer.valueOf(3), solution.lowestCommonAncestor(tree1, 5, 1));
        Assert.assertEquals(Integer.valueOf(5), solution.lowestCommonAncestor(tree1, 5, 4));
        var tree2 = TreeNode.of(new Integer[] { 1, 2 });
        Assert.assertEquals(Integer.valueOf(1), solution.lowestCommonAncestor(tree2, 1, 2));
    }
}
