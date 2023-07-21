package algo.java;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static algo.java.ListNodeUtils.ListNode;
import static algo.java.ListNodeUtils.listNodeFromList;
import static algo.java.ListNodeUtils.listEquals;

public class DeleteMiddleNodeLinkedListTest {

    static class Solution {
        public ListNode deleteMiddle(ListNode head) {
            if (head == null || head.next == null)
                return null;
            ListNode preSlow = null;
            var slow = head;
            var fast = head;
            while (fast != null && fast.next != null) {
                preSlow = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            preSlow.next = slow.next;
            return head;
        }
    }

    @Test
    public void deleteMiddleNodeLinkedListTest() {
        var solution = new Solution();
        var sample = listNodeFromList(List.of(1, 2, 3, 4, 5, 6, 7));
        var expected = listNodeFromList(List.of(1, 2, 3, 5, 6, 7));
        Assert.assertTrue(listEquals(expected, solution.deleteMiddle(sample)));
    }
}
