package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class ContainerWithMostWaterTest {
    static class Solution {
        public int maxArea(int[] height) {
            if (height == null || height.length < 1)
                return 0;
            int maxVol = Integer.MIN_VALUE;
            int left = 0;
            int right = height.length - 1;
            while (left < right) {
                int vol = (right - left) * Math.min(height[left], height[right]);
                maxVol = Math.max(maxVol, vol);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxVol;
        }
    }

    @Test
    public void containerWithMostWaterTest() {
        var solution = new Solution();
        Assert.assertEquals(1, solution.maxArea(new int[] { 1, 1 }));
        Assert.assertEquals(25, solution.maxArea(new int[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 }));
        Assert.assertEquals(4, solution.maxArea(new int[] { 1, 2, 4, 3 }));
        Assert.assertEquals(49, solution.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        Assert.assertEquals(42, solution.maxArea(new int[] { 1, 1, 1, 10, 1, 1, 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
    }
}
