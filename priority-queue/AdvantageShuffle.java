import java.util.PriorityQueue;
import java.util.Arrays;
/** Return any perm of nums1[] max its advantage over nums2[]
  * advantage: num of elem where nums1[i] greater than nums2[i] */
// leetcode 870
// priority-queue + sort + two-pointers
// T: O(NlogN), S: O(N).
public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // const
        int N = nums1.length;
        // data struct
        PriorityQueue<int[]> pq = new PriorityQueue<>( // decreasing order
            (int[] pair1, int[] pair2) -> { return pair2[1] - pair1[1]; }
        );
        for (int i = 0; i < N; i++)
            pq.offer(new int[]{ i, nums2[i] });
        // var
        nums1 = Arrays.copyOf(nums1, N);
        int left = 0;
        int right = N-1;
        // sort
        Arrays.sort(nums1); // increasing order
        // res
        int[] res = new int[N];
        // priority queue
        while (!pq.isEmpty()) {
            // poll
            int[] curPair = pq.poll();
            int idx = curPair[0];
            int valMax = curPair[1];
            // update states
            if (valMax < nums1[right]) { // max of nums1 > cur max of nums2
                res[idx] = nums1[right];
                --right;
            } else { // use min of nums1 to counter
                res[idx] = nums1[left]; 
                ++left;
            }
        }
        // return res
        return res;
    }
}
