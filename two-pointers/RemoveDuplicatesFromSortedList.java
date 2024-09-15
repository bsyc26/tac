/** Delete all duplicates of a sorted linked list and return the head (list still sorted) */
public class Solution { // leetcode 83
    // two-pointers: fast-slow
    public ListNode deleteDuplicates(ListNode head) { // T: O(N), S: O(1).
        // edge case
        if (head == null) return null;
        // var
        ListNode fast = head;
        ListNode slow = head;
        // two pointers
        while (fast != null) {
            // cond step slow
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            // step fast
            fast = fast.next;
        }
        // end slow
        slow.next = null;
        // return
        return head;
    }
}
