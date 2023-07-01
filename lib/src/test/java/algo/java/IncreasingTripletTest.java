package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class IncreasingTripletTest {

    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums == null || nums.length < 3)
                return false;
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            for (int n : nums) {
                if (n < first) {
                    first = n;
                } else if (n < second && n != first) {
                    second = n;
                } else if (n > first && n > second) {
                    return true;
                }
            }
            return false;
        }
    }

    @Test
    public void increasingTripletTest() {
        var solution = new Solution();
        
        Assert.assertTrue(solution.increasingTriplet(new int[] { 1, 5, 0, 4, 1, 3 }));
        Assert.assertTrue(solution.increasingTriplet(new int[] { 5, 4, 3, 2, 1, 6, 7 }));
        Assert.assertTrue(solution.increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
        Assert.assertTrue(solution.increasingTriplet(new int[] { 9, 7, 8, 6, 9, 7, 8, 6, 9, 7, 8, 6 }));

        Assert.assertFalse(solution.increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
        Assert.assertFalse(solution.increasingTriplet(new int[] { 2, 1, 5, 0, 3 }));
        Assert.assertFalse(solution.increasingTriplet(new int[] { 1, 1, -2, 6 }));
    }

}
