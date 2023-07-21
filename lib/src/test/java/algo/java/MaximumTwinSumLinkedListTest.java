package algo.java;

import java.util.ArrayDeque;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static algo.java.ListNodeUtils.ListNode;
import static algo.java.ListNodeUtils.listNodeFromList;

public class MaximumTwinSumLinkedListTest {
    static class Solution {
        public int pairSum(ListNode head) {
            if (head == null)
                return 0;
            if (head.next == null)
                return head.val;
            var stack = new ArrayDeque<Integer>();
            var slow = head;
            var fast = head;
            while (fast != null) {
                stack.push(slow.val);
                slow = slow.next;
                fast = fast.next.next;
            }
            int maxSum = Integer.MIN_VALUE;
            while (slow != null) {
                int tmp = slow.val + stack.pop();
                maxSum = Math.max(maxSum, tmp);
                slow = slow.next;
            }
            return maxSum;
        }
    }

    @Test
    public void oddEvenLinkedListTest() {
        var solution = new Solution();
        var sample = listNodeFromList(List.of(1, 2, 3, 5, 5, 6, 7, 8));
        Assert.assertEquals(10, solution.pairSum(sample));
    }

}
