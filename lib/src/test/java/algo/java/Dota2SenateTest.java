package algo.java;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

public class Dota2SenateTest {
    static class Solution {
        public String predictPartyVictory(String senate) {
            if (senate == null || senate.length() == 0)
                return "";
            var queue1 = new ArrayDeque<Character>();
            int dVotes = 0;
            int rVotes = 0;
            for (int i = 0; i < senate.length(); i++) {
                queue1.add(senate.charAt(i));
            }
            while (true) {
                int s = queue1.size();
                int rCount = 0;
                int dCount = 0;
                for (int i = 0; i < s; i++) {
                    var c = queue1.pollFirst();
                    if (c == 'R' && dVotes == 0) {
                        queue1.add(c);
                        rCount++;
                        rVotes++;
                    } else if (c == 'R' && dVotes > 0) {
                        dVotes--;
                    } else if (c == 'D' && rVotes == 0) {
                        queue1.add(c);
                        dCount++;
                        dVotes++;
                    } else if (c == 'D' && rVotes > 0) {
                        rVotes--;
                    }
                }
                if (rCount == queue1.size() || dCount == queue1.size())
                    break;
            }
            var c = queue1.pollFirst();
            if (c == 'R')
                return "Radiant";
            else
                return "Dire";
        }
    }

    @Test
    public void dota2SenateTest() {
        var solution = new Solution();
        Assert.assertEquals("Radiant", solution.predictPartyVictory("RD"));
        Assert.assertEquals("Dire", solution.predictPartyVictory("RDD"));
        Assert.assertEquals("Dire", solution.predictPartyVictory("D"));
        Assert.assertEquals("Radiant", solution.predictPartyVictory("RRRD"));
    }
}
