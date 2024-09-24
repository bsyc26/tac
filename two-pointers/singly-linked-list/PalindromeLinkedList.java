/** Return true if is a palindrome linked list, otherwise false */
public class Solution { // leetcode 234
    // two-pointers: fast-slow + parallel
    public boolean isPalindrome(ListNode head) { // T: O(N), S: O(1).
        // var
        ListNode fast = head;
        ListNode slow = head;
        ListNode preRev = new ListNode(Integer.MIN_VALUE); // to restore the rev part
        preRev.next = slow;
        // two pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            preRev = preRev.next;
        }
        if (fast != null) { // odd nodes in linked list
            slow = slow.next; // move slow one step further
            preRev = preRev.next;
        }
        // var
        ListNode left = head;
        ListNode right = reverse(slow);
        ListNode revHead = right;
        // two pointers
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        // restore rev
        preRev.next = reverse(revHead);
        // return fallback
        return true;
    }
    private ListNode reverse(ListNode head) {
        // base case
        if (head == null || head.next == null)
            return head;
        // var
        ListNode pred = null;
        ListNode cur = head;
        ListNode succ = head.next;
        // iter
        while (cur != null) {
            // rev
            cur.next = pred;
            // step
            pred = cur;
            cur = succ;
            succ = (succ == null) ? null : succ.next;
        }
        // return
        return pred;
    }
}
