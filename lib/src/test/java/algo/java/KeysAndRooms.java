package algo.java;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class KeysAndRooms {
    static class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms == null || rooms.size() == 0)
                return true;
            var visited = new HashSet<Integer>();
            var queue = new ArrayDeque<Integer>();
            queue.add(0);
            while (!queue.isEmpty()) {
                var key = queue.pollFirst();
                visited.add(key);
                for (var newKey : rooms.get(key)) {
                    if (!visited.contains(newKey))
                        queue.add(newKey);
                }
            }
            return visited.size() == rooms.size();
        }
    }

    @Test
    public void keysAndRoomsTest() {
        var solution = new Solution();
        List<List<Integer>> testl = List.of(List.of(1, 3), List.of(2), List.of(3), List.of());
        Assert.assertEquals(true, solution.canVisitAllRooms(testl));
        List<List<Integer>> test2 = List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0));
        Assert.assertEquals(false, solution.canVisitAllRooms(test2));
    }
}
