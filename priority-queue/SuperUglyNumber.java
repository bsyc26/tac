/** Return the n-th super ugly number
  * super ugly number: pos int with factors of primes[] */

// leetcode 313
// priority-queue
// T: O(NlogK)
// S: O(N+K)

import java.util.PriorityQueue;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // const
        int N = n;
        // DS
        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> { return (int)(a[0] - b[0]); }
        ); // min-heap
        for (int prime : primes)
            pq.offer(new long[]{ 1, prime, 1 }); // long[]{ prod, prime, pt }
        // res
        long[] ugly = new long[N+1]; // [0, 1..N]
        // var
        int idx = 1;
        // priority queue
        while (idx <= N) {
            // poll
            long[] cur = pq.poll();
            long prod = cur[0];
            long prime = cur[1];
            long ptr = cur[2];
            // update state
            if (prod != ugly[idx-1]) { // avoid dup
                ugly[idx] = prod;
                ++idx;
            }
            // offer
            long[] succ = new long[]{ ugly[(int)ptr]*prime, prime, 1+ptr };
            pq.offer(succ);
        }
        // return res
        return (int)ugly[N];
    }
}
