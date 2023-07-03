package algo.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FindDifferenceTwoArraysTest {
    static class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            var s1 = new HashSet<Integer>();
            var s2 = new HashSet<Integer>();
            for (int n : nums1)
                s1.add(n);
            for (int n : nums2)
                s2.add(n);
            var ans1 = new ArrayList<Integer>();
            var ans2 = new ArrayList<Integer>();
            for (var n : s1)
                if (!s2.contains(n))
                    ans1.add(n);
            for (var n : s2)
                if (!s1.contains(n))
                    ans2.add(n);
            return List.of(ans1, ans2);
        }
    }

    @Test
    public void findDifferenceTwoArraysTest() {
        var solution = new Solution();

        var expected1 = List.of(List.of(1, 3), List.of(4, 6));
        Assert.assertEquals(expected1, solution.findDifference(new int[] { 1, 2, 3 }, new int[] { 2, 4, 6 }));

        var expected2 = List.of(List.of(3), List.of());
        Assert.assertEquals(expected2, solution.findDifference(new int[] { 1, 2, 3, 3 }, new int[] { 1, 1, 2, 2 }));
    }
}
