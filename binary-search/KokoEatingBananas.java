/** Return the min int k to eat all bananas within h hours
  * piles[i] is the num of bananas of pile, k is eating number per hour */

// leetcode: 875
// binary-search:lo-bound + map-func
// T: O(logN)
// S: O(1).

public class Solution {
    // state
    private int[] piles;

    // core method
    public int minEatingSpeed(int[] piles, int h) {
        // field
        this.piles = piles;
        // const
        int target = h;
        // var
        int lo = 1;
        int hi = 1_000_000_000; // h: [1..1_000_000_000]
        // binary-search:low-bound
        while (lo <= hi) {
            // calc mid && get f(mid)
            int mid = lo + (hi-lo)/2;
            long cur = f(mid);
            // step next
            if (cur < target)
                hi = mid-1;
            else if (cur > target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        // return low-bound
        return lo;
    }

    // support method
    private long f(int x) { // x => f(x): eat-num => hours
        // res
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) // an extra hour if reminder
                hours++;
        }
        // return res
        return hours;
    }
}
