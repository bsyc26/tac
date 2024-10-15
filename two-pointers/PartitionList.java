/** Partition the linked list: all nodes less than x come before nodes greater than or equal to x
  * preserve the original relative order in two partitions */
// leetcode 86
// two-pointers: parallel
// T: O(N), S: O(1).
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // var
        ListNode dummyLt = new ListNode(Integer.MIN_VALUE); // partition of less than x 
        ListNode ptLt = dummyLt;
        ListNode dummyGe = new ListNode(Integer.MIN_VALUE); // partition of greater than or equal to x
        ListNode ptGe = dummyGe;
        ListNode walker = head;
        // two pointers: parallel
        while (walker != null) {
            // build two partitions
            if (walker.val < x) {
                ptLt.next = walker;
                ptLt = ptLt.next;
            } else {
                ptGe.next = walker;
                ptGe = ptGe.next;
            }
            // step next
            walker = walker.next;
        }
        // conn two partitions
        ptGe.next = null; // must, pt1 might still be mid of linked-list
        ptLt.next = dummyGe.next; 
        // return Lt partition's dummy.next
        return dummyLt.next;
    }
}
