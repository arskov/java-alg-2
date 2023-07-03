package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class FindPivotIndexTest {
    static class Solution {
        public int pivotIndex(int[] nums) {
            if (nums == null || nums.length == 0)
                return -1;
            int[] rightSum = new int[nums.length + 1];
            rightSum[nums.length] = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                rightSum[i] = rightSum[i + 1] + nums[i];
            }
            int leftSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (leftSum == rightSum[i + 1])
                    return i;
                leftSum += nums[i];
            }
            return -1;
        }
    }

    @Test
    public void findPivotIndexTest() {
        var solution = new Solution();
        Assert.assertEquals(3, solution.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
        Assert.assertEquals(-1, solution.pivotIndex(new int[] { 1, 2, 3 }));
        Assert.assertEquals(0, solution.pivotIndex(new int[] { 2, 1, -1 }));
    }
}
