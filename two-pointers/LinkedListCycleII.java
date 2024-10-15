/** Return the node begins the cycle or null if no cycle */
// leetcode 142
// two-pointers: fast-slow
// T: O(N), S: O(1).
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // var
        ListNode fast = head;
        ListNode slow = head;
        // two pointers: fast-slow
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) // if is circle
                break;
        }
        // case: no cycle
        if (fast == null || fast.next == null)
            return null;
        // case: is cycle
        slow = head;
        while (slow != fast) { // slow and fast will meet at the start of circle
            fast = fast.next;
            slow = slow.next;
        }
        // return the start of circle
        return slow;
    }
}
