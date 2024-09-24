/** Reverse the nodes from pos left to right (1-index) and return the head */
public class Solution { // leetcode 92
    // field
    ListNode postRev;
    // recursion
    public ListNode reverseBetween(ListNode head, int left, int right) { // T: O(N), S: O(1).
        // const
        int N = right-left+1;
        // base case
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
        // base case
        if (N == 1) {
            postRev = head.next; // conn tail to postRev
            return head;
        }
        // recur
        ListNode last = reverseN(head.next, N-1);
        // post-order
        head.next.next = head;
        head.next = postRev;  // head being the tail of rev part
        // return
        return last;
    }
}
