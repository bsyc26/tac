/** Reverse every k nodes of the list per group and return the rev head */

// leetcode 25
// linked-list:recur
// T: O(N)
// S: O(1)

public class Solution {
    // core method
    public ListNode reverseKGroup(ListNode head, int k) {
        // const
        int K = k; // num of nodes of a rev group
        // edge case
        if (head == null) return null;
        // vars
        ListNode start = head;
        ListNode end = head; // [start, end)
        for (int i = 0; i < K; i++) {
            if (end == null) return head; // edge case
            end = end.next;
        }
        // rev k nodes
        ListNode revHead = reverseN(start, K);
        // recur
        start.next = reverseKGroup(end, K);
        // return revHead
        return revHead;
    }

    // support method
    private ListNode reverseN(ListNode head, int K) {
        // base case
        if (head == null || head.next == null)
            return head;
        // var
        ListNode pred = null;
        ListNode cur = head;
        ListNode succ = head.next;
        int steps = K;
        // iter with steps
        while (steps > 0) {
            cur.next = pred;
            pred = cur;
            cur = succ;
            succ = (succ == null) ? null : succ.next;
            --steps;
        }
        head.next = cur; // head is now tail, cur is the head of un-rev
        // return pred
        return pred;
    }
}
