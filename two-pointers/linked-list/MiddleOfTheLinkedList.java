/** Return the mid node of linked list (if two then the second one) */
public class Solution { // leetcode 876
    // two-pointers: fast-slow
    public ListNode middleNode(ListNode head) { // T: O(N), S: O(1).
        // var
        ListNode fast = head;
        ListNode slow = head;
        // two pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // return
        return slow;
    }
}
