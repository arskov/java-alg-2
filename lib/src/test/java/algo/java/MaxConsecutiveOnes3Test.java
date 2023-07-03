package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class MaxConsecutiveOnes3Test {
    static class Solution {
        public int longestOnes(int[] nums, int k) {
            if (nums == null || nums.length == 0)
                return 0;
            int count = 0;
            int max = 0;
            int i = 0, j = 0;
            while (j < nums.length) {
                if (nums[j] == 0 && count < k) {
                    count++;
                    j++;
                } else if (nums[j] == 0) {
                    if (nums[i] == 0)
                        count--;
                    i++;
                } else {
                    j++;
                }
                max = Math.max(max, j - i);
            }
            max = Math.max(max, j - i);
            return max;
        }
    }

    @Test
    public void maxConsecutiveOnes3Test() {
        var solution = new Solution();

        Assert.assertEquals(6, solution.longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
        Assert.assertEquals(10,
                solution.longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));
    }
}
