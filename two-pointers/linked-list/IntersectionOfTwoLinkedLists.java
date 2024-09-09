/** Return the node intersect of two lists (no cycle), null if no intersection */
public class Solution { // leetcode 160
    // two-pointers: parallel
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) { // T: O(M+N), S: O(1).
        // variables
        ListNode ptA = headA;
        ListNode ptB = headB;
        // two pointers
        while (ptA != ptB) { // ptA == ptB == null also apply cond
            ptA = (ptA == null) ? headB : ptA.next;
            ptB = (ptB == null) ? headA : ptB.next;
        } // both pt loop the same length of (ListA + ListB)
        // return
        return ptA; // either intersection node or null
    }
}
