package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class GreatestCommonDivisorStringsTest {
    static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if (str1 == null || str2 == null)
                return "";
            String sh;
            String ln;
            if (str1.length() >= str2.length()) {
                ln = str1;
                sh = str2;
            } else {
                ln = str2;
                sh = str1;
            }
            if (!(ln + sh).equals((sh + ln)))
                return "";
            var res = "";
            var tmp = sh;
            while (tmp.length() > 0) {
                if (devides(ln, tmp) && devides(sh, tmp)) {
                    res = tmp;
                    break;
                }
                tmp = tmp.substring(0, tmp.length() - 1);
            }
            return res;
        }

        private boolean devides(String a, String b) {
            int times = a.length() / b.length();
            var sb = new StringBuilder();
            for (int i = 0; i < times; i++) {
                sb.append(b);
            }
            return a.equals(sb.toString());
        }
    }

    @Test
    public void greatestCommonDivisorStringsTest() {
        var solution = new Solution();

        Assert.assertEquals("ABC", solution.gcdOfStrings("ABCABC", "ABC"));
        Assert.assertEquals("AB", solution.gcdOfStrings("ABABAB", "ABAB"));
        Assert.assertEquals("", solution.gcdOfStrings("F**K", "THIS"));
    }

}
