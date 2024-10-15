/** Reverse the linked-list and return the reversed head */
// leetcode 206
// iteration
// T: O(N), S: O(N).
public class Solution {
    public ListNode reverseList(ListNode head) {
        // edge case
        if (head == null || head.next == null) return head;
        // var
        ListNode pred = null;
        ListNode cur = head;
        ListNode succ = head.next;
        // iter
        while (cur != null) { // ... -> pred  cur -> succ -> ...
            cur.next = pred; // ... -> pred <- cur  succ -> ...
            pred = cur; // ... -> () -> pred  succ -> ...
            cur = succ; // ... -> () -> pred  cur -> ...
            succ = (succ == null) ? null : succ.next; // ... -> () -> pred  cur -> succ? -> ...
        }
        // return
        return pred;
    }
}

// recursion
// T: O(N), S: O(1).
public class Solution {
    public ListNode reverseList(ListNode head) {
        // base case
        if (head == null || head.next == null)
            return head;
        // recur
        ListNode last = reverseList(head.next); // head -> (null <-) head.next <- ... <- last
        head.next.next = head; // head -> <- head.next <- ... <- last
        head.next = null; // null <- head <- head.next <- ... <- last
        // return rev head
        return last;
    }
}
