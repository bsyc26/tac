/** Return the node begins the cycle or null if no cycle */
public class Solution { // leetcode 142
    // two-pointers: fast-slow
    public ListNode detectCycle(ListNode head) { // T: O(N), S: O(1).
        // variables
        ListNode fast = head;
        ListNode slow = head;
        // two-pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) // cond has cycle
                break;
        }
        // cond no cycle
        if (fast == null || fast.next == null)
            return null;
        // cond has cycle
        slow = head;
        while (slow != fast) { // slow == fast is the beginning of cycle
            fast = fast.next;
            slow = slow.next;
        }
        // return
        return slow;
    }
}
