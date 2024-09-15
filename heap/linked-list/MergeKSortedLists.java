import java.util.PriorityQueue;
/** Merge all lists into sorted one and return its head
  * lists[] is k linked lists sorted in ascending order */
public class Solution { // leetcode 23
    // priority-queue
    public ListNode mergeKLists(ListNode[] lists) { // T: O(NlogK), S: O(K).
        // const
        int K = lists.length; // k linked-lists to merge
        // edge case
        if (K < 1) return null;
        // data struct
        PriorityQueue<ListNode> pq = new PriorityQueue<>(K, (a, b)->{return a.val - b.val;}); // K > 0
        for (int i = 0; i < K; i++)
            if (lists[i] != null)
                pq.offer(lists[i]);
        // var
        ListNode lead = new ListNode(Integer.MIN_VALUE); // dummy head of merged linked list
        ListNode walk = lead;
        // min heap
        while (!pq.isEmpty()) {
            // poll
            ListNode minNode = pq.poll();
            // update state
            walk.next = minNode;
            walk = walk.next;
            // offer
            if (minNode.next != null)
                pq.offer(minNode.next);
        }
        // return
        return lead.next;
    }
}
