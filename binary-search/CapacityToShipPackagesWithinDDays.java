/** Return the min capacity to send all pkgs within days
  * weights[i] is the weight of i-th pkg */

// leetcode 1011
// binary-search:low-bound + map-func
// T: O(logN)
// S: O(1).

public class Solution {
    // state
    private int[] wts;

    // core method
    public int shipWithinDays(int[] weights, int days) {
        // field
        this.wts = weights;
        // const
        int target = days;
        // vars
        int lo = 0;
        int hi = 0; // [lo, hi]: cap range
        for (int wt : this.wts) {
            lo = Math.max(lo, wt); // f(lo) => max-days
            hi += wt; // f(hi) => min-days
        }
        // binary-search:low-bound
        while (lo <= hi) {
            // calc mid && get func(mid)
            int mid = lo + (hi-lo)/2;
            int cur = f(mid);
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
    private int f(int x) { // x => f(x): ship-cap => days
        // const
        int N = wts.length;
        // res
        int days = 0;
        for (int i = 0; i < N; ) {
            int cap = x;
            while (i < N) { // load as much wts[i] as possible under cap
                int curWt = wts[i];
                if (cap < curWt)
                    break;
                else
                    cap -= curWt;
                ++i;
            }
            // step res
            ++days;
        }
        // return res
        return days;
    }
}
