/** Reverse the linked-list and return the reversed head */
public class Solution { // leetcode 206
    // iteration
    public ListNode reverseList(ListNode head) { // T: O(N), S: O(1).
        // edge case
        if (head == null || head.next == null) return head;
        // var
        ListNode pred = null;
        ListNode cur = head;
        ListNode succ = head.next;
        // iter
        while (cur != null) {
            cur.next = pred;
            pred = cur;
            cur = succ;
            succ = (succ == null) ? null : succ.next;
        }
        // return
        return pred;
    }
}
