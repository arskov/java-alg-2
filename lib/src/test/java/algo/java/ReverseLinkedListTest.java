package algo.java;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static algo.java.ListNodeUtils.ListNode;
import static algo.java.ListNodeUtils.listNodeFromList;
import static algo.java.ListNodeUtils.listEquals;

public class ReverseLinkedListTest {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return null;
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                var tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            return prev;
        }
    }

    @Test
    public void oddEvenLinkedListTest() {
        var solution = new Solution();
        var sample = listNodeFromList(List.of(1, 2, 3, 4, 5, 6, 7));
        var expected = listNodeFromList(List.of(7, 6, 5, 4, 3, 2, 1));
        Assert.assertTrue(listEquals(expected, solution.reverseList(sample)));
    }
}
