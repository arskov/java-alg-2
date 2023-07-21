package algo.java;

import java.util.List;

public final class ListNodeUtils {
    private ListNodeUtils() {
    }

    public static class ListNode {
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

    public static boolean listEquals(ListNode a, ListNode b) {
        while (a != null) {
            if (b == null || b.val != a.val)
                return false;
            a = a.next;
            b = b.next;
        }
        return true;
    }

    public static ListNode listNodeFromList(List<Integer> list) {
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

}
