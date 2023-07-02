package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class IsSubsequenceTest {
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s == null ||
                    t == null ||
                    s.length() > t.length())
                return false;
            if (s.isEmpty())
                return true;
            int j = 0;
            for (int i = 0; i < t.length(); i++) {
                if (j == s.length())
                    return true;
                if (t.charAt(i) == s.charAt(j)) {
                    j++;
                }
            }
            return j == s.length();
        }
    }

    @Test
    public void isSubsequenceTest() {
        var solution = new Solution();
        Assert.assertTrue(solution.isSubsequence("abc", "anbnc"));
        Assert.assertTrue(solution.isSubsequence("abc", "nanbnc"));
        Assert.assertTrue(solution.isSubsequence("", "anbnc"));
        Assert.assertTrue(solution.isSubsequence("", ""));
        Assert.assertFalse(solution.isSubsequence("adc", "anbnc"));
        Assert.assertFalse(solution.isSubsequence("cba", "anbnc"));
        Assert.assertFalse(solution.isSubsequence("nm", "anbnc"));
    }
}
