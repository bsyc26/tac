/** Reverse the linked-list, return the new head */
public class Solution { // leetcode 206
    // recursion
    public ListNode reverseList(ListNode head) { // T: O(N), S: O(N).
        // base case
        if (head == null || head.next == null)
            return head;
        // recur
        ListNode last = reverseList(head.next); // head -> (null <- ) head.next <- ... <- last
        // post-order
        head.next.next = head; // head -> <- head.next <- ... <- last
        head.next = null; // null <- head <- head.next <- .. <- last
        // return
        return last;
    }
}
