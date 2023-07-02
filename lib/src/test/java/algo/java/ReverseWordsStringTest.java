package algo.java;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsStringTest {
    static class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0)
                return "";
            var wordStack = new ArrayDeque<String>();
            var word = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    if (word.length() > 0) {
                        wordStack.push(word.toString());
                        word.setLength(0);
                    }
                } else {
                    word.append(s.charAt(i));
                }
            }
            if (word.length() > 0)
                wordStack.push(word.toString());
            var res = new StringBuilder();
            int total = wordStack.size();
            for (int i = 0; i < total; i++) {
                res.append(wordStack.pop());
                if (i < total - 1)
                    res.append(' ');
            }
            return res.toString();
        }
    }

    @Test
    public void reverseWordsStringTest() {
        var solution = new Solution();

        Assert.assertEquals("blue is sky the", solution.reverseWords("the sky is blue"));
        Assert.assertEquals("world hello", solution.reverseWords("  hello world  "));
        Assert.assertEquals("example good a", solution.reverseWords("a good   example"));
    }
}
