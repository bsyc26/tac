/** Merge two sorted ascending lists into one sorted list and return the head of merged linked list */
// leetcode 21
// two-pointers: parallel
// T: O(M+N), S: O(1).
public class Solution {
    public ListNode mergeTwoLists(ListNode List1, ListNode List2) {
        // var
        ListNode pt1 = List1;
        ListNode pt2 = List2;
        ListNode dummy = new ListNode(Integer.MIN_VALUE); // dummy head node
        ListNode builder = dummy;
        // two pointers: parallel 
        while (pt1 != null && pt2 != null) { // while steps walk at last
            if (pt1.val < pt2.val) {
                builder.next = pt1;
                pt1 = pt1.next;
            } else {
                builder.next = pt2;
                pt2 = pt2.next;
            }
            // step builder
            builder = builder.next;
        }
        // conn remain nodes of List1 or List2
        if (pt1 != null)
            builder.next = pt1;
        if (pt2 != null)
            builder.next = pt2;
        // return the next of dummy head
        return dummy.next;
    }
}
