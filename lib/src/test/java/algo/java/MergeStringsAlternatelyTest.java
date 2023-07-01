package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class MergeStringsAlternatelyTest {
    static class Solution {
        public String mergeAlternately(String word1, String word2) {
            if (word1 == null)
                return word2;
            if (word2 == null)
                return word1;
            int len = Math.min(word1.length(), word2.length());
            var res = new StringBuilder();
            for (int i = 0; i < len; i++) {
                res.append(word1.charAt(i)).append(word2.charAt(i));
            }
            if (len == word1.length()) {
                res.append(word2.substring(len));
            } else {
                res.append(word1.substring(len));
            }
            return res.toString();
        }
    }

    @Test
    public void mergeAlternatelyTest() {
        var solution = new Solution();

        Assert.assertEquals(solution.mergeAlternately("abc", "pqr"), "apbqcr");
        Assert.assertEquals(solution.mergeAlternately("ab", "pqrs"), "apbqrs");
        Assert.assertEquals(solution.mergeAlternately("abcd", "pq"), "apbqcd");
        
    }
}
