/** Reverse the nodes from pos left to right (1-index) and return the head */

// leetcode 92
// linked-list:iter
// T: O(N)
// S: O(1)

public class Solution {
    // core method
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // const
        int N = right-left+1; // len of [left, right]
        // edge case
        if (left == 1) return reverseN(head, N);
        // vars
        ListNode preRev = head;
        for (int i = 0; i < left-2; i++)
            preRev = preRev.next;
        ListNode revHead = preRev.next;
        // conn un-rev with rev
        preRev.next = reverseN(revHead, N);
        // return orig head
        return head;
    }

    // support method
    private ListNode reverseN(ListNode head, int N) {
        // edge case
        if (head == null || head.next == null) return head;
        // vars
        ListNode pred = null;
        ListNode cur = head;
        ListNode succ = head.next;
        int steps = N;
        // iter with steps
        while (steps > 0) {
            cur.next = pred;
            pred = cur;
            cur = succ;
            succ = (succ == null) ? null : succ.next;
            --steps;
        }
        // conn tail to the un-rev
        head.next = cur; // head is now tail, cur is the head of un-rev
        // return rev head
        return pred;
    }
}

// linked-list:recur
// T: O(N)
// S: O(1)
public class Solution {
    // state
    private ListNode postRev;

    // core method
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // const
        int N = right-left+1; // [left, right]
        // base case
        if (left == 1) return reverseN(head, N);
        // var
        ListNode preRev = head;
        for (int i = 0; i < left-2; i++)
            preRev = preRev.next;
        ListNode revHead = preRev.next;
        // conn preRev and revHead
        preRev.next = reverseN(revHead, N);
        // return orig head
        return head;
    }

    // support method
    private ListNode reverseN(ListNode head, int N) {
        // base case
        if (N == 1) {
            postRev = head.next; // record postRev
            return head;
        }
        // recur
        ListNode last = reverseN(head.next, N-1);
        head.next.next = head;
        head.next = postRev; // head is now tail, conn to the un-rev
        return last;
    }
}
