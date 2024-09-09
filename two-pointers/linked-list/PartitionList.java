/** Partition the linked list: all nodes less than x come before nodes greater than or equal to x
  * preserve the original relative order in two partitions */
public class Solution { // leetcode 86
    // two-pointers: parallel
    public ListNode partition(ListNode head, int x) { // T: O(N), S: O(1).
        // variables
        ListNode lead0 = new ListNode(Integer.MIN_VALUE); // dummy head of nodes < x
        ListNode pt0 = lead0;
        ListNode lead1 = new ListNode(Integer.MIN_VALUE); // dummy head of nodes >= x
        ListNode pt1 = lead1;
        // two pointers
        for (ListNode walk = head; walk != null; walk = walk.next) { // for steps walk in cond
            if (walk.val < x) {
                pt0.next = walk;
                pt0 = pt0.next;
            } else { // walk.val >= x
                pt1.next = walk;
                pt1 = pt1.next;
            }
        }
        // link two partitions
        pt1.next = null;
        pt0.next = lead1.next; 
        // return
        return lead0.next;
    }
}
