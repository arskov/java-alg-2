package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class MaximumAverageSubarray1Test {
    static class Solution {
        public double findMaxAverage(int[] nums, int k) {
            if (nums == null || nums.length == 0)
                return 0.0;
            double tmpSum = 0;
            double maxSum = 0;
            for (int i = 0; i < k; i++) {
                tmpSum += nums[i];
            }
            maxSum = tmpSum;
            for (int i = 1; i < nums.length - k + 1; i++) {
                tmpSum -= nums[i - 1];
                tmpSum += nums[i + k - 1];
                maxSum = Math.max(tmpSum, maxSum);
            }
            return maxSum / k;
        }
    }

    @Test
    public void maximumAverageSubarray1Test() {
        var solution = new Solution();

        Assert.assertEquals(12.75000, solution.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4), 0.00001);
        Assert.assertEquals(5.0, solution.findMaxAverage(new int[] { 5 }, 1), 0.00001);
    }
}
