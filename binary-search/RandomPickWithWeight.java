/** Implement the function pickIndex() to randomly return an index with prob of w[i]/sum(w) */

// leetcode 528
// binary-search:low-bound + preSum
// T: O(logN)
// S: O(N).

import java.util.Random;

public class Solution {
    // states
    private int[] preSum;
    private Random rand;

    // constructor
    public Solution(int[] w) {
        // field
        this.rand = new Random();
        // const
        int N = w.length;
        // DS
        this.preSum = new int[N+1];
        this.preSum[0] = 0;
        for (int i = 1; i <= N; i++)
            this.preSum[i] = this.preSum[i-1] + w[i-1];
    }

    // core method
    public int pickIndex() {
        // consts
        int N = this.preSum.length; 
        int target = rand.nextInt(preSum[N-1]) + 1; // [1, preSum[N-1]]
        // return lowBound()
        return lowBound(preSum, target) - 1; // [0..i]
    }

    // support method
    private int lowBound(int[] arr, int target) {
        // const
        int N = arr.length;
        target = target;
        // vars
        int lo = 0;
        int hi = N-1; // [left, right]
        // binary-search:low-bound
        while (lo <= hi) {
            // calc mid && get arr[mid]
            int mid = lo + (hi-lo)/2;
            int cur = arr[mid];
            // step next
            if (cur > target)
                hi = mid-1;
            else if (cur < target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        return lo;
    }
}
