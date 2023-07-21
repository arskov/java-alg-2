package algo.java;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DeleteMiddleNodeLinkedListTest {
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
    public void deleteMiddleNodeLinkedListTest() {
        var solution = new Solution();
        var sample = fromList(List.of(1, 2, 3, 4, 5, 6, 7));
        var expected = fromList(List.of(1, 2, 3, 5, 6, 7));
        Assert.assertTrue(equals(expected, solution.deleteMiddle(sample)));
    }
}
