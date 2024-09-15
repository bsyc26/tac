/** Remove the n-th node from the end of list and return the original linked-list's head */
public class Solution { // leetcode 19
    // two-pointers: fast-slow
    public ListNode removeNthFromEnd(ListNode head, int n) { // T: O(N), S: O(1).
        // var
        ListNode lead = new ListNode(Integer.MIN_VALUE); // dummy head node -> head
        lead.next = head;
        ListNode slow = lead;
        ListNode fast = lead;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        // two pointers
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // remove rev n-th node
        slow.next = slow.next.next;
        // return
        return lead.next;
    }
}
