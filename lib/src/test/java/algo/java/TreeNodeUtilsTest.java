package algo.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import algo.java.TreeNodeUtils.TreeNode;

public class TreeNodeUtilsTest {

    private boolean validateTree(TreeNode root, Integer[] src) {
        if (root == null && (src == null || src.length == 0))
            return true;
        if (root == null && src.length > 0)
            return false;
        var result = new ArrayList<Integer>();
        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        result.add(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.pollFirst();
                if (node.left == null) {
                    result.add(null);
                } else {
                    result.add(node.left.val);
                    queue.add(node.left);
                }
                if (node.right == null) {
                    result.add(null);
                } else {
                    result.add(node.right.val);
                    queue.add(node.right);
                }
            }
        }
        var it = result.listIterator(result.size());
        while (it.hasPrevious()) {
            if (it.previous() == null) it.remove();
            else break;
        }
        System.out.println(result);
        Integer[] tmp = result.toArray(new Integer[0]);
        return Arrays.equals(src, tmp);
    }

    @Test
    public void treeNodeUtilsTest() {
        var test1 = new Integer[] {1, 2, 3};
        var tree1 = TreeNode.of(test1);
        Assert.assertTrue(validateTree(tree1, test1));
        var test2 = new Integer[] {5,4,7,3,null,2,null,-1,null,9};
        var tree2 = TreeNode.of(test2);
        Assert.assertTrue(validateTree(tree2, test2));
    }
}
