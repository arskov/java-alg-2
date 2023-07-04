package algo.java;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

public class RemovingStarsFromStringTest {
    static class Solution {
        public String removeStars(String s) {
            if (s == null || s.length() == 0)
                return "";
            var stack = new ArrayDeque<Character>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '*') {
                    stack.pop();
                    continue;
                }
                stack.push(c);
            }
            var builder = new StringBuilder();
            while (stack.size() > 0) {
                builder.append(stack.pollLast());
            }
            return builder.toString();
        }
    }

    @Test
    public void removingStarsFromStringTest() {
        var solution = new Solution();
        Assert.assertEquals("lecoe", solution.removeStars("leet**cod*e"));
        Assert.assertEquals("", solution.removeStars("erase*****"));
    }
}
