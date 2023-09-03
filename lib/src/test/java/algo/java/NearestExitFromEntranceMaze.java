package algo.java;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

public class NearestExitFromEntranceMaze {
    static class Solution {
        static int[][] DIR = new int[][] {
                { -1, 0 },
                { 0, 1 },
                { 1, 0 },
                { 0, -1 }
        };

        public int nearestExit(char[][] maze, int[] entrance) {
            int rows = maze.length;
            int cols = maze[0].length;
            var queue = new ArrayDeque<int[]>();
            maze[entrance[0]][entrance[1]] = '+';
            queue.add(new int[] { entrance[0], entrance[1], 0 });
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    int[] point = queue.pollFirst();
                    for (int[] way : DIR) {
                        int nextRow = point[0] + way[0];
                        int nextCol = point[1] + way[1];
                        int level = point[2];
                        if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols)
                            continue;
                        if (maze[nextRow][nextCol] == '+')
                            continue;
                        if (nextRow == 0 || nextCol == 0 || nextRow == rows - 1 || nextCol == cols - 1)
                            return level + 1;
                        maze[nextRow][nextCol] = '+';
                        queue.add(new int[] { nextRow, nextCol, level + 1 });
                    }
                }
            }
            return -1;
        }
    }

    @Test
    public void testNearestExitFromEntranceMaze() {
        var solution = new Solution();
        var test1 = new char[][] { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };
        Assert.assertEquals(1, solution.nearestExit(test1, new int[] { 1, 2 }));
        var test2 = new char[][] { { '+', '+', '+', }, { '.', '.', '.' }, { '+', '+', '+' } };
        Assert.assertEquals(2, solution.nearestExit(test2, new int[] { 1, 0 }));
        var test3 = new char[][] { { '.', '+' } };
        Assert.assertEquals(-1, solution.nearestExit(test3, new int[] { 0, 0 }));
    }
}
