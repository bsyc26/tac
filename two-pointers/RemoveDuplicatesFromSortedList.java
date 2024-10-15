/** Delete all duplicates of a sorted linked list and return the head (list still sorted) */
// leetcode 83
// two-pointers: fast-slow
// T: O(N), S: O(1).
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // edge case
        if (head == null) return null;
        // var
        ListNode fast = head;
        ListNode slow = head;
        // two pointers: fast-slow
        while (fast != null) {
            // step slow
            if (slow.val != fast.val) {
                slow.next = fast; // head is always preserved
                slow = slow.next;
            }
            // step fast
            fast = fast.next;
        }
        // cut the dup part out
        slow.next = null;
        // return
        return head;
    }
}
