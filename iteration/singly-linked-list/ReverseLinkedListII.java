/** Reverse the nodes from pos left to right (1-index) and return the head */
public class Solution { // leetcode 92
    // iteration
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // const
        int N = right-left+1; // [left, right]
        // edge case
        if (left == 1) return reverseN(head, N);
        // var
        ListNode preRev = head;
        for (int i = 0; i < left-2; i++)
            preRev = preRev.next;
        ListNode revHead = preRev.next;
        // conn rev
        preRev.next = reverseN(revHead, N);
        // return
        return head;
    }
    private ListNode reverseN(ListNode head, int N) {
        // edge case
        if (head == null || head.next == null) return head;
        // var
        ListNode pred = null;
        ListNode cur = head;
        ListNode succ = head.next;
        int steps = N;
        // iter
        while (steps > 0) {
            // exec rev
            cur.next = pred;
            pred = cur;
            cur = succ;
            succ = (succ == null) ? null : succ.next;
            // step less
            --steps;
        }
        // conn rev
        head.next = cur; // head is tail of rev, cur is head of unrev
        // return
        return pred;
    }
}
