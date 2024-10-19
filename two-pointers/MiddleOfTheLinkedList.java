/** Return the mid node of linked list (if two then the second one) */

// leetcode 876
// two-pointers:fast-slow
// T: O(N)
// S: O(1)

public class Solution {
    // core method
    public ListNode middleNode(ListNode head) {
        // var
        ListNode fast = head;
        ListNode slow = head;
        // two pointers: fast slow
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // return
        return slow;
    }
}
