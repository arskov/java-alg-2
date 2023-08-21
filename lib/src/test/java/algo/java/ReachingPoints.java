package algo.java;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ReachingPoints {
    static class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            // return dp(sx, sy, tx, ty, new HashMap<>());
            while (tx >= sx && ty >= sy) {
                if (tx > ty) {
                    if (ty > sy) {
                        tx %= ty;
                    } else {
                        return (tx - sx) % ty == 0;
                    }
                } else if (ty > tx) {
                    if (tx > sx) {
                        ty %= tx;
                    } else {
                        return (ty - sy) % tx == 0;
                    }
                } else {
                    break;
                }
            }
            return tx == sx && ty == sy;
        }

        @SuppressWarnings("unused")
        private boolean dp(int sx, int sy, int tx, int ty, Map<List<Integer>, Boolean> cache) {
            var key = List.of(sx, sy);
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
            if (sx == tx && sy == ty) {
                cache.put(key, true);
                return true;
            }
            if (sx > tx || sy > ty) {
                return false;
            }
            boolean a = dp(sx, sx + sy, tx, ty, cache);
            boolean b = dp(sx + sy, sy, tx, ty, cache);
            cache.put(key, a || b);
            return a || b;
        }
    }

    @Test
    public void reachingPointsTest() {
        var solution = new Solution();
        Assert.assertEquals(true, solution.reachingPoints(1, 1, 3, 5));
        Assert.assertEquals(false, solution.reachingPoints(1, 1, 2, 2));
        Assert.assertEquals(true, solution.reachingPoints(1, 1, 1, 1));
        Assert.assertEquals(false, solution.reachingPoints(35, 13, 455955547, 420098884));
    }
}
