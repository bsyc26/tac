/** Rotate the list to the right by k places */

// leetcode 61
// iteration
// T: O(N)
// S: O(1)

public class Solution {
    // core method
    public ListNode rotateRight(ListNode head, int k) {
        // edge case
        if (head == null || head.next == null || k == 0) return head;
        // const
        int K = k;
        // vars
        int size; // the num of nodes in linked list
        ListNode walker = head;
        // iter: build circle
        for (size = 1; walker.next != null; size++) // size inits from 1 as walker = head
            walker = walker.next;
        walker.next = head;
        // iter: break circle
        walker = head;
        for (int i = 0; i < size-(K%size)-1; i++) // reach node before new head
            walker = walker.next; 
        ListNode newHead = walker.next;
        walker.next = null;
        // return new Head
        return newHead;
    }
}
