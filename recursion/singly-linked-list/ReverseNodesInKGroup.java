/** Reverse every k nodes of the list per group and return the rev head */
public class Solution { // leetcoee 25
    // recursion
    public ListNode reverseKGroup(ListNode head, int k) { // T: O
        // const
        int K = k; // num of nodes in a rev group
        // edge case
        if (head == null) return null;
        // var
        ListNode start = head;
        ListNode end = head; // [start, end)
        for (int i = 0; i < K; i++) {
            if (end == null)
                return head;
            end = end.next;
        }
        // rev k nodes
        ListNode revHead = reverseN(start, K);
        // recur
        start.next = reverseKGroup(end, K);
        // return
        return revHead;
    }
    private ListNode reverseN(ListNode head, int K) {
        // base case
        if (head == null || head.next == null)
            return head;
        // var
        ListNode pred = null;
        ListNode cur = head;
        ListNode succ = head.next;
        int steps = K;
        // iter
        while (steps > 0) {
            // rev conn
            cur.next = pred;
            // step ptrs
            pred = cur;
            cur = succ;
            succ = (succ == null) ? null : succ.next;
            // minus step
            --steps;
        }
        // conn tail and postRev
        head.next = cur;
        // return
        return pred;
    }
}
