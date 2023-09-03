package algo.java;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

public class RottingOranges {
    static class Solution {

        private int[][] dir = new int[][] {
                { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }
        };

        public int orangesRotting(int[][] grid) {
            var queue = new ArrayDeque<int[]>();
            int m = grid.length;
            int n = grid[0].length;
            int freshCount = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new int[] { i, j, 0 });
                    } else if (grid[i][j] == 1) {
                        freshCount++;
                    }
                }
            }
            if (freshCount == 0)
                return 0;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    var point = queue.pollFirst();
                    var r = point[0];
                    var c = point[1];
                    var curLevel = point[2];
                    for (var d : dir) {
                        var newR = r + d[0];
                        var newC = c + d[1];
                        if (newR < 0 || newC < 0 || newR >= m || newC >= n)
                            continue;
                        if (grid[newR][newC] == 1) {
                            if (freshCount == 1)
                                return curLevel + 1;
                            freshCount--;
                            grid[newR][newC] = 2;
                            queue.add(new int[] { newR, newC, curLevel + 1 });
                        }
                    }
                }
            }
            return -1;
        }
    }

    @Test
    public void testRottingOranges() {
        var solution = new Solution();

        var test1 = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        Assert.assertEquals(4, solution.orangesRotting(test1));

        var test2 = new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        Assert.assertEquals(-1, solution.orangesRotting(test2));

        var test3 = new int[][] { { 0, 2 } };
        Assert.assertEquals(0, solution.orangesRotting(test3));

    }
}
