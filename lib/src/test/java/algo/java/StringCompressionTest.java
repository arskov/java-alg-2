package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class StringCompressionTest {
    static class Solution {
        public int compress(char[] chars) {
            if (chars == null || chars.length == 0)
                return 0;
            int movePointer = 0;
            char curChar = chars[0];
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                char tmp = chars[i];
                if (curChar == tmp) {
                    count++;
                    continue;
                }
                if (count > 1) {
                    var countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[++movePointer] = c;
                    }
                }
                chars[++movePointer] = tmp;
                curChar = tmp;
                count = 1;
            }
            if (count > 1) {
                var countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[++movePointer] = c;
                }
            }

            return movePointer + 1;
        }
    }

    @Test
    public void stringCompressionTest() {
        var solution = new Solution();

        var mutArray = "abcdef".toCharArray();
        int len = solution.compress(mutArray);
        Assert.assertEquals("abcdef", new String(mutArray, 0, len));

        mutArray = "aabbccc".toCharArray();
        len = solution.compress(mutArray);
        Assert.assertEquals("a2b2c3", new String(mutArray, 0, len));

        mutArray = "abbbbbbbbbb".toCharArray();
        len = solution.compress(mutArray);
        Assert.assertEquals("ab10", new String(mutArray, 0, len));

        mutArray = "abcdefggggggggggggabc".toCharArray();
        len = solution.compress(mutArray);
        Assert.assertEquals("abcdefg12abc", new String(mutArray, 0, len));

    }

}
