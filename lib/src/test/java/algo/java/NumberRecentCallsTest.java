package algo.java;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

public class NumberRecentCallsTest {
    static class RecentCounter {
        ArrayDeque<Integer> range;

        public RecentCounter() {
            range = new ArrayDeque<Integer>();
        }

        public int ping(int t) {
            range.add(t);
            while (t - range.peekFirst() > 3000)
                range.pollFirst();
            return range.size();
        }
    }

    @Test
    public void numberRecentCallsTest() {
        var solution = new RecentCounter();
        int[] input = { 1, 100, 3001, 3002 };
        int[] expected = { 1, 2, 3, 3 };
        for (int i = 0; i < input.length; i++) {
            Assert.assertEquals(expected[i], solution.ping(input[i]));
        }
    }
}
