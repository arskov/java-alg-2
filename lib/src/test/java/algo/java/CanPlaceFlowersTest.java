package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class CanPlaceFlowersTest {
    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if (flowerbed == null || flowerbed.length == 0)
                return false;
            if (n == 0)
                return true;
            int ln = flowerbed.length;
            for (int i = 0; i < ln; i++) {
                if (flowerbed[i] == 1)
                    continue;
                if (i - 1 >= 0 && i + 1 < ln) {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                } else if (i - 1 < 0 && i + 1 >= ln) {
                    return true;
                } else if (i - 1 < 0) {
                    if (flowerbed[i + 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                } else {
                    if (flowerbed[i - 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                }
                if (n == 0)
                    return true;
            }
            return false;
        }
    }

    @Test
    public void canPlaceFlowersTest() {
        var solution = new Solution();

        Assert.assertEquals(true, solution.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
        Assert.assertEquals(false, solution.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
    }
}
