package algo.java;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

public class AsteroidCollisionTest {
    static class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            if (asteroids == null)
                return new int[] {};
            if (asteroids.length <= 1)
                return asteroids;

            var stack = new ArrayDeque<Integer>();
            for (int i = 0; i < asteroids.length; i++) {
                int right = asteroids[i];
                while (stack.size() > 0) {
                    if (stack.peek() > 0 && right < 0) {
                        int left = stack.pop();
                        int leftMass = Math.abs(left);
                        int rightMass = Math.abs(right);
                        if (rightMass < leftMass) {
                            right = left;
                        } else if (rightMass == leftMass) {
                            right = 0;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (right != 0)
                    stack.push(right);
            }
            int[] result = new int[stack.size()];
            for (int i = result.length - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }
            return result;
        }
    }

    @Test
    public void asteroidCollisionTest() {
        var solution = new Solution();
        Assert.assertArrayEquals(new int[] { 5, 10 }, solution.asteroidCollision(new int[] { 5, 10, -5 }));
        Assert.assertArrayEquals(new int[] {}, solution.asteroidCollision(new int[] { 8, -8 }));
        Assert.assertArrayEquals(new int[] { 10 }, solution.asteroidCollision(new int[] { 10, 2, -5 }));
        Assert.assertArrayEquals(new int[] {}, solution.asteroidCollision(new int[] { 1, 2, -2, -1 }));
    }
}
