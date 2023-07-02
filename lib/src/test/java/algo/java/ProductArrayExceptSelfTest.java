package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class ProductArrayExceptSelfTest {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length == 0)
                return new int[0];
            int len = nums.length;
            // int[] fwd = new int[len];
            int[] rev = new int[len];
            // for (int i = 0; i < len; i++) {
            // fwd[i] = i == 0 ? nums[i] : fwd[i-1] * nums[i];
            // }
            for (int i = len - 1; i >= 0; i--) {
                rev[i] = i == len - 1 ? nums[i] : rev[i + 1] * nums[i];
            }
            int[] res = new int[len];
            int tmp = 1;
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    res[i] = rev[i + 1];
                    tmp = nums[i];
                } else if (i == len - 1) {
                    res[i] = tmp;
                } else {
                    res[i] = rev[i + 1] * tmp;
                    tmp *= nums[i];
                }
            }
            return res;
        }
    }

    /*
     * 
     * 1, 2, 3, 4
     * 1, 2, 6, 24
     * 24,24,12, 4
     * 
     * 24, 12, 8, 6
     * 
     * 1,2,3,4,5,6,7
     * 1, 2, 6, 24, 120, 720, 5040
     * 5040, 5040, 2520, 840, 210, 42, 7
     * 
     * 5040, 2520, 1680, 1260, 1008, 840, 720
     */
    @Test
    public void productArrayExceptSelfTest() {
        var solution = new Solution();

        Assert.assertArrayEquals(new int[] { 24, 12, 8, 6 },
                solution.productExceptSelf(new int[] { 1, 2, 3, 4 }));
        Assert.assertArrayEquals(new int[] { 0, 0, 9, 0, 0 },
                solution.productExceptSelf(new int[] { -1, 1, 0, -3, 3 }));
    }
}
