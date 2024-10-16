/** Return the min largest sum of the split
  * split nums[] into k non-empty sub arr to get min of largest sum among sub arrs */

// leetcode 410
// binary-search:low-bound + map-func
// T: O(logN)
// S: O(1)

public class Solution {
    // state
    private int[] arr;

    // core method
    public int splitArray(int[] nums, int k) {
        // field
        this.arr = nums;
        // const
        int N = arr.length;
        int target = k;
        // var
        long lo = 0;
        long hi = 0; // [lo, hi]
        for (int i = 0; i < N; i++) {
            lo = Math.max(lo, arr[i]); // lo => max-f(x)
            hi += arr[i]; // hi => min-f(x)
        }
        // binary-search:low-bound
        while (lo <= hi) {
            // calc mid && get f(mid)
            long mid = lo + (hi-lo)/2;
            int cur = f(mid);
            // step next
            if (cur > target)
                lo = mid+1;
            else if (cur < target)
                hi = mid-1;
            else
                hi = mid-1;
        }
        // return low-bound
        return (int)lo;
    }

    // support method
    private int f(long x) { // x => f(x): min-largest-sum => k-groups
        // const
        int N = arr.length;
        // res
        int k = 0;
        // calc res
        for (int i = 0; i < N; ) {
            long curSum = x;
            while (i < N) { // make x deplete arr[i] as much as possible
                if (curSum < arr[i])
                    break;
                else
                    curSum -= arr[i];
                ++i;
            }
            ++k;
        }
        // return res
        return k;
    }
}
