/** Merge two sorted ascending lists into one sorted list and return the head of merged linked list */
public class Solution { // leetcode 21
    // two-pointers: parallel
    public ListNode mergeTwoLists(ListNode List1, ListNode List2) { // T: O(M+N), S: O(1).
        // var
        ListNode pt1 = List1;
        ListNode pt2 = List2;
        ListNode lead = new ListNode(Integer.MIN_VALUE); // dummy head node
        ListNode walk = lead;
        // two pointers
        while (pt1 != null && pt2 != null) { // while steps walk at last
            if (pt1.val < pt2.val) {
                walk.next = pt1;
                pt1 = pt1.next;
            } else { // pt1.val >= pt2.val
                walk.next = pt2;
                pt2 = pt2.next;
            }
            // step walk
            walk = walk.next;
        }
        // link remain nodes of List1 or List2
        if (pt1 != null)
            walk.next = pt1;
        if (pt2 != null)
            walk.next = pt2;
        // return
        return lead.next;
    }
}
