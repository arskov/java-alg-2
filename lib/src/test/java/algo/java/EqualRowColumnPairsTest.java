package algo.java;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class EqualRowColumnPairsTest {
    static class Solution {
        public int equalPairs(int[][] grid) {
            if (grid == null || grid.length == 0)
                return 0;
            if (grid.length != grid[0].length)
                return 0;

            var rows = new HashMap<Integer, Integer>();
            var cols = new HashMap<Integer, Integer>();

            for (int i = 0; i < grid.length; i++) {
                int num1 = 0;
                int num2 = 0;
                for (int j = 0; j < grid.length; j++) {
                    num1 += grid[i][j] * (j == 0 ? 1 : 10 * j);
                    num2 += grid[j][i] * (j == 0 ? 1 : 10 * j);
                }
                rows.compute(num1, (k, v) -> (v == null) ? 1 : v + 1);
                cols.compute(num2, (k, v) -> (v == null) ? 1 : v + 1);
            }

            int counter = 0;
            for (var entry : rows.entrySet()) {
                var key = entry.getKey();
                var value = entry.getValue();
                if (cols.containsKey(key)) {
                    counter += cols.get(key) * value;
                }
            }
            return counter;
        }
    }

    @Test
    public void equalRowColumnPairsTest() {
        var solution = new Solution();
        Assert.assertEquals(1, solution.equalPairs(new int[][] { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } }));
        Assert.assertEquals(3,
                solution.equalPairs(new int[][] { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } }));
    }
}
