package algo.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SubarraySumEqualsK {
    static class Solution {
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0)
                return 0;
            int count = 0;
            int sum = 0;
            var map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum == k) count++;
                if (map.containsKey(sum - k))
                    count += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }

        public int subarraySum(ArrayList<Integer> arr, int k) {
            int sum = 0;
            int count = 0;
            var map = new HashMap<Integer, Integer>();
            for (int i = 0; i < arr.size(); i++) {
                sum += arr.get(i);
                if (sum == k) count++;
                if (map.containsKey(sum - k))
                    count += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }

    @Test
    public void subarraySumEqualsKTest() {
        var solution = new Solution();
        Assert.assertEquals(2, solution.subarraySum(new int[] { 1, 1, 1 }, 2));
        Assert.assertEquals(2, solution.subarraySum(new int[] { 1, 2, 3 }, 3));

        Assert.assertEquals(2, solution.subarraySum(new ArrayList<>(List.of(1, 1, 1)), 2));
        Assert.assertEquals(2, solution.subarraySum(new ArrayList<>(List.of(1, 2, 3)), 3));
    }
}
