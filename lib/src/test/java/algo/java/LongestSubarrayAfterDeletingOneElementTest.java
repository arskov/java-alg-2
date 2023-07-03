package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubarrayAfterDeletingOneElementTest {
    static class Solution {
        public int longestSubarray(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            boolean deleted = false;
            int maxCount = 0;
            int i = 0, j = 0;
            while (j < nums.length) {
                if (nums[j] == 0 && !deleted) {
                    deleted = true;
                    j++;
                } else if (nums[j] == 0 && deleted) {
                    if (nums[i] == 0)
                        deleted = false;
                    i++;
                } else {
                    j++;
                }
                maxCount = Math.max(maxCount, j - i);
            }
            return maxCount - 1;
        }
    }

    @Test
    public void longestSubarrayAfterDeletingOneElementTest() {
        var solution = new Solution();

        Assert.assertEquals(3, solution.longestSubarray(new int[] { 1, 1, 0, 1 }));
        Assert.assertEquals(5, solution.longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 }));
        Assert.assertEquals(2, solution.longestSubarray(new int[] { 1, 1, 1 }));
    }
}
