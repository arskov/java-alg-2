package algo.java;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfProvinces {

    static class Solution {
        public int findCircleNum(int[][] isConnected) {
            if (isConnected == null || isConnected.length == 0)
                return 0;
            int cities = isConnected.length;
            var queue = new ArrayDeque<Integer>();
            int counter = 0;
            for (int i = 0; i < cities; i++) {
                if (isConnected[i][0] != 2) {
                    for (int j = 0; j < cities; j++) {
                        if (isConnected[i][j] == 1) {
                            counter++;
                            isConnected[i][j] = 2;
                            isConnected[j][i] = 2;
                            queue.add(j);
                            while (!queue.isEmpty()) {
                                int k = queue.pollFirst();
                                for (int l = 0; l < cities; l++) {
                                    if (isConnected[k][l] == 1) {
                                        isConnected[k][l] = 2;
                                        isConnected[l][k] = 2;
                                        queue.add(l);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return counter;
        }
    }

    @Test
    public void numberOfProvincesTest() {
        var solution = new Solution();

        var test1 = new int[][] {
                new int[] { 1, 1, 0 },
                new int[] { 1, 1, 0 },
                new int[] { 0, 0, 1 },
        };
        Assert.assertEquals(2, solution.findCircleNum(test1));

        var test2 = new int[][] {
                new int[] { 1, 0, 0 },
                new int[] { 0, 1, 0 },
                new int[] { 0, 0, 1 },
        };
        Assert.assertEquals(3, solution.findCircleNum(test2));
    }
}
