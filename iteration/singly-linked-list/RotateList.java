/** Rotate the list to the right by k places */
public class Solution { // leetcode 61
    // iteration
    public ListNode rotateRight(ListNode head, int k) { // T: O(N), S: O(1).
        // edge case
        if (head == null || head.next == null || k == 0) return head;
        // const
        int K = k;
        // var
        int size; // the num of nodes in linked list
        ListNode walk = head;
        // iter: build circle
        for (size = 1; walk.next != null; size++) // size inits from 1 as walk = head
            walk = walk.next;
        walk.next = head;
        // iter: break circle
        walk = head;
        for (int i = 0; i < size-(K%size)-1; i++) // reach node before new head
            walk = walk.next; 
        ListNode newHead = walk.next;
        walk.next = null;
        // return
        return newHead
    }
}
