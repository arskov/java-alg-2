package algo.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import algo.java.TreeNodeUtils.TreeNode;

public class PathSum3 {
    static class Solution1 {

        int result = 0;
        int target = 0;
        Map<Long, Integer> map = new HashMap<>();

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null)
                return 0;
            result = 0;
            target = targetSum;
            map.clear();
            dfs(root, 0L);
            return result;
        }

        private void dfs(TreeNode root, long sum) {
            if (root == null)
                return;
            long cur = sum + root.val;
            if (cur == target)
                result++;
            long tmp = cur - target;
            result += map.getOrDefault(tmp, 0);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            dfs(root.left, cur);
            dfs(root.right, cur);
            map.put(cur, map.get(cur) - 1);
        }

    }

    static class Solution2 {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null)
                return 0;
            return dfs(root, new ArrayList<Integer>(), targetSum);
        }

        private int dfs(TreeNode root, ArrayList<Integer> arr, int k) {
            if (root == null)
                return 0;
            arr.add(root.val);
            long sum = 0;
            int res = 0;
            for (int i = arr.size() - 1; i >= 0; i--) {
                sum += arr.get(i);
                if (sum == k)
                    res++;
            }
            res += dfs(root.left, arr, k);
            res += dfs(root.right, arr, k);
            arr.remove(arr.size() - 1);
            return res;
        }
    }

    @Test
    public void pathSum3Test() {
        var solution1 = new Solution1();
        var solution2 = new Solution2();

        var tree1 = TreeNode.of(new Integer[] { 10, 5, -3, 3, 2, null, 11, 3, -2, null, 1 });
        var tree2 = TreeNode.of(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 });

        Assert.assertEquals(3, solution1.pathSum(tree1, 8));
        Assert.assertEquals(3, solution2.pathSum(tree1, 8));

        Assert.assertEquals(3, solution1.pathSum(tree2, 22));
        Assert.assertEquals(3, solution2.pathSum(tree2, 22));
    }
}
