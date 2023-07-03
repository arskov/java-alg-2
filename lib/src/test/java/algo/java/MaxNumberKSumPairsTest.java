package algo.java;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaxNumberKSumPairsTest {
    static class Solution {
        public int maxOperations(int[] nums, int k) {
            if (nums == null || nums.length == 0)
                return 0;
            int count = 0;
            Arrays.sort(nums);
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int s = nums[left] + nums[right];
                if (s == k) {
                    count++;
                    left++;
                    right--;
                } else if (s < k) {
                    left++;
                } else {
                    right--;
                }
            }
            return count;
        }
    }

    @Test
    public void maxNumberKSumPairsTest() {
        var solution = new Solution();
        Assert.assertEquals(2, solution.maxOperations(new int[] { 1, 2, 3, 4 }, 5));
        Assert.assertEquals(1, solution.maxOperations(new int[] { 3, 1, 3, 4, 3 }, 6));
    }
}
