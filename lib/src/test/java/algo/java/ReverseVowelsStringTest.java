package algo.java;

import org.junit.Assert;
import org.junit.Test;

public class ReverseVowelsStringTest {
    static class Solution {
        public String reverseVowels(String s) {
            if (s == null || s.length() == 0)
                return "";
            char[] arr = s.toCharArray();
            int j = arr.length - 1;
            for (int i = 0; i < j; i++, j--) {
                while (i < arr.length && !isVowel(arr[i]))
                    i++;
                while (j > 0 && !isVowel(arr[j]))
                    j--;
                if (i < j) {
                    swap(arr, i, j);
                }
            }
            return new String(arr);
        }

        private boolean isVowel(char a) {
            switch (a) {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    return true;
                default:
                    return false;
            }
        }

        private void swap(char[] arr, int i, int j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    @Test public void reverseVowelsStringTest() {
        var solution = new Solution();

        Assert.assertEquals("holle", solution.reverseVowels("hello"));
        Assert.assertEquals("leotcede", solution.reverseVowels("leetcode"));
    }
}
