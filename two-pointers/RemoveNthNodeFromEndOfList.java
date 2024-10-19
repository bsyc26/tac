/** Remove the n-th node from the end of list and return the original linked-list's head */

// leetcode 19
// two-pointers:fast-slow
// T: O(N)
// S: O(1)

public class Solution {
    // core method
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // var
        ListNode dummy = new ListNode(Integer.MIN_VALUE); // might remove head
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) // move fast n firstly
            fast = fast.next;
        // two pointers: fast-slow
        while (fast != null && fast.next != null) { // fast to the end, slow to the (size-n-1)
            fast = fast.next;
            slow = slow.next;
        }
        // remove rev n-th node
        slow.next = slow.next.next; // slow.next is the node to remove
        // return the next node of dummy
        return dummy.next;
    }
}
