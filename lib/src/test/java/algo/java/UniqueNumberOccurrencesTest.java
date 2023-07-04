package algo.java;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class UniqueNumberOccurrencesTest {
    static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            if (arr == null || arr.length == 0)
                return false;
            var map = new HashMap<Integer, Integer>();
            for (int n : arr) {
                map.compute(n, (k, v) -> (v == null) ? 1 : v + 1);
            }
            var set = new HashSet<Integer>(map.values());
            return set.size() == map.size();
        }
    }

    @Test
    public void uniqueNumberOccurrencesTest() {
        var solution = new Solution();
        Assert.assertTrue(solution.uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
        Assert.assertFalse(solution.uniqueOccurrences(new int[] { 1, 2 }));
        Assert.assertTrue(solution.uniqueOccurrences(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 }));
    }
}
