package algo.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class DetermineTwoStringsAreCloseTest {
    static class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1 == null || word2 == null)
                return false;
            if (word1.length() != word2.length())
                return false;
            var map1 = new HashMap<Character, Integer>();
            var map2 = new HashMap<Character, Integer>();
            for (int i = 0; i < word1.length(); i++) {
                map1.compute(word1.charAt(i), (k, v) -> (v == null) ? 1 : v + 1);
            }
            for (int i = 0; i < word2.length(); i++) {
                map2.compute(word2.charAt(i), (k, v) -> (v == null) ? 1 : v + 1);
            }
            if (!map1.keySet().equals(map2.keySet()))
                return false;
            var arr1 = new ArrayList<>(map1.values());
            Collections.sort(arr1);
            var arr2 = new ArrayList<>(map2.values());
            Collections.sort(arr2);
            return arr1.equals(arr2);
        }
    }

    @Test
    public void determineTwoStringsAreCloseTest() {
        var solution = new Solution();
        Assert.assertTrue(solution.closeStrings("abc", "bca"));
        Assert.assertFalse(solution.closeStrings("a", "aa"));
        Assert.assertTrue(solution.closeStrings("cabbba", "abbccc"));
    }
}
