package algo.java;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static boolean equals(ListNode a, ListNode b) {
        while (a != null) {
            if (b == null || b.val != a.val)
                return false;
            a = a.next;
            b = b.next;
        }
        return true;
    }

    static ListNode fromList(List<Integer> list) {
        if (list == null || list.isEmpty())
            return null;
        var it = list.iterator();
        ListNode head = new ListNode(it.next());
        ListNode next = head;
        while (it.hasNext()) {
            var i = it.next();
            next.next = new ListNode(i);
            next = next.next;
        }
        return head;
    }

    @Test
    public void oddEvenLinkedListTest() {
        var solution = new Solution();
        var sample = fromList(List.of(1, 2, 3, 4, 5, 6, 7));
        var expected = fromList(List.of(1, 3, 5, 7, 2, 4, 6));
        Assert.assertTrue(equals(expected, solution.oddEvenList(sample)));
    }

}
