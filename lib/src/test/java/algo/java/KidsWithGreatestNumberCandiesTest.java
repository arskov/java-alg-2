package algo.java;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class KidsWithGreatestNumberCandiesTest {
    static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            if (candies == null || candies.length == 0)
                return List.of();
            var res = new ArrayList<Boolean>(candies.length);
            int max = candies[0];
            for (int i = 0; i < candies.length; i++) {
                max = Math.max(max, candies[i]);
                candies[i] += extraCandies;
            }
            for (int i = 0; i < candies.length; i++) {
                res.add(candies[i] >= max);
            }
            return res;
        }
    }

    @Test
    public void kidsWithGreatestNumberCandiesTest() {
        var solution = new Solution();

        Assert.assertEquals(List.of(true, true, true, false, true),
                solution.kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3));
        Assert.assertEquals(List.of(true, false, false, false, false),
                solution.kidsWithCandies(new int[] { 4, 2, 1, 1, 2 }, 1));
        Assert.assertEquals(List.of(true, false, true),
                solution.kidsWithCandies(new int[] { 12, 1, 12 }, 10));
    }
}
