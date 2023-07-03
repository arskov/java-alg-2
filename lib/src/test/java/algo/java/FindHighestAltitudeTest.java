package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class FindHighestAltitudeTest {
    static class Solution {
        public int largestAltitude(int[] gain) {
            if (gain == null || gain.length == 0)
                return 0;
            int max = 0;
            int alt = 0;
            for (int i = 0; i < gain.length; i++) {
                alt += gain[i];
                max = Math.max(alt, max);
            }
            return max;
        }
    }

    @Test
    public void findHighestAltitudeTest() {
        var solution = new Solution();

        Assert.assertEquals(1, solution.largestAltitude(new int[] { -5, 1, 5, 0, -7 }));
        Assert.assertEquals(0, solution.largestAltitude(new int[] { -4, -3, -2, -1, 4, 3, 2 }));

    }
}
