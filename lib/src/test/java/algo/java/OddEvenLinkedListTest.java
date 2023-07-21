package algo.java;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static algo.java.ListNodeUtils.ListNode;
import static algo.java.ListNodeUtils.listNodeFromList;
import static algo.java.ListNodeUtils.listEquals;

public class OddEvenLinkedListTest {
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null)
                return head;
            ListNode oddTail = null;
            ListNode evenTail = null;
            ListNode oddHead = head.next;
            ListNode next = head;
            int counter = 0;
            while (next != null) {
                if (counter % 2 == 0) {
                    if (evenTail == null) {
                        evenTail = next;
                    } else {
                        evenTail.next = next;
                        evenTail = evenTail.next;
                    }
                } else {
                    if (oddTail == null) {
                        oddTail = next;
                    } else {
                        oddTail.next = next;
                        oddTail = oddTail.next;
                    }
                }
                next = next.next;
                counter++;
            }
            oddTail.next = null;
            evenTail.next = oddHead;
            return head;
        }
    }

    @Test
    public void oddEvenLinkedListTest() {
        var solution = new Solution();
        var sample = listNodeFromList(List.of(1, 2, 3, 4, 5, 6, 7));
        var expected = listNodeFromList(List.of(1, 3, 5, 7, 2, 4, 6));
        Assert.assertTrue(listEquals(expected, solution.oddEvenList(sample)));
    }

}
