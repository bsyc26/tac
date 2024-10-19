/** Merge all lists into sorted one and return its head
  * lists[] is k linked lists sorted in ascending order */

// leetcode 23
// priority-queue 
// T: O(NlogK)
// S: O(K)

import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // const
        int K = lists.length; // k linked-lists to merge
        // edge case
        if (K < 1) return null;
        // data struct
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                K, (a, b)->{return a.val - b.val;}
        ); // min-heap
        for (int i = 0; i < K; i++)
            if (lists[i] != null)
                pq.offer(lists[i]);
        // var
        ListNode dummy = new ListNode(Integer.MIN_VALUE); // dummy head due to possible null linked-list
        ListNode walker = dummy;
        // priority queue
        while (!pq.isEmpty()) {
            // poll
            ListNode minNode = pq.poll();
            // update state
            walker.next = minNode;
            walker = walker.next;
            // offer
            if (minNode.next != null)
                pq.offer(minNode.next);
        }
        // return
        return dummy.next;
    }
}
