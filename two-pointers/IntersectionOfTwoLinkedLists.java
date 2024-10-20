/** Return the node intersect of two lists (no cycle), null if no intersection */

// leetcode 160
// two-pointers:parallel
// T: O(M+N)
// S: O(1)

public class Solution {
    // core method
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // var
        ListNode ptA = headA;
        ListNode ptB = headB;
        // two-pointers:parallel
        while (ptA != ptB) {
            ptA = (ptA == null) ? headB : ptA.next;
            ptB = (ptB == null) ? headA : ptB.next;
        }
        // return any pt
        return ptA;
    }
}
