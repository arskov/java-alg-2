package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class DecodeStringTest {
    static class Solution {
        int idx;

        public String decodeString(String s) {
            if (s == null || s.length() == 0)
                return "";
            idx = 0;
            return deep(s);
        }

        private String deep(String s) {
            var tmpStr = new StringBuilder();
            var numStr = new StringBuilder();
            for (; idx < s.length(); idx++) {
                char c = s.charAt(idx);
                if (Character.isAlphabetic(c)) {
                    tmpStr.append(c);
                } else if (Character.isDigit(c)) {
                    numStr.append(c);
                } else if (c == '[') {
                    int mul = numStr.length() == 0 ? 1 : Integer.parseInt(numStr.toString());
                    numStr.setLength(0);
                    idx++;
                    String r = deep(s);
                    for (int j = 0; j < mul; j++) {
                        tmpStr.append(r);
                    }
                } else if (c == ']') {
                    return tmpStr.toString();
                }
            }
            return tmpStr.toString();
        }
    }

    @Test
    public void decodeStringTest() {
        var solution = new Solution();
        Assert.assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"));
        Assert.assertEquals("accaccacc", solution.decodeString("3[a2[c]]"));
        Assert.assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"));
        var expected = "abc" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "abrrrrrrrrrrrrrrrrrrrr" +
                "bcbc";
        Assert.assertEquals(expected, solution.decodeString("abc30[ab20[r]]2[bc]"));
    }
}
