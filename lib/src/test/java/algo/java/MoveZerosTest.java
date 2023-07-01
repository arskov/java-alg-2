package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class MoveZerosTest {
    static class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0)
                return;
            int insertPointer = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[insertPointer] = nums[i];
                    if (i != insertPointer)
                        nums[i] = 0;
                    insertPointer++;
                }
            }
        }
    }

    @Test
    public void moveZerosTest() {
        var solution = new Solution();

        var sample1 = new int[] { 0, 1, 0, 3, 12 };
        solution.moveZeroes(sample1);
        Assert.assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, sample1);

        var sample2 = new int[] { 3, 4, 1 };
        solution.moveZeroes(sample2);
        Assert.assertArrayEquals(new int[] { 3, 4, 1 }, sample2);
    }
}
