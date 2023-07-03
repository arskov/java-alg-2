package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class MaximumNumberVowelsSubstringGivenLengthTest {
    static class Solution {

        public int maxVowels(String s, int k) {
            if (s == null || s.length() == 0)
                return 0;
            int maxVowels = 0;
            int tmpVowels = 0;
            for (int i = 0; i < k; i++) {
                if (isVowel(s.charAt(i)))
                    tmpVowels++;
            }
            maxVowels = tmpVowels;
            for (int i = 0; i < s.length() - k; i++) {
                char a = s.charAt(i);
                char b = s.charAt(i + k);
                if (isVowel(a))
                    tmpVowels--;
                if (isVowel(b))
                    tmpVowels++;
                maxVowels = Math.max(maxVowels, tmpVowels);
            }
            return maxVowels;
        }

        private boolean isVowel(char c) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return true;
                default:
                    return false;
            }
        }
    }

    @Test
    public void maximumNumberVowelsSubstringGivenLengthTest() {
        var solution = new Solution();

        Assert.assertEquals(3, solution.maxVowels("abciiidef", 3));
        Assert.assertEquals(2, solution.maxVowels("aeiou", 2));
        Assert.assertEquals(2, solution.maxVowels("leetcode", 3));
    }
}
