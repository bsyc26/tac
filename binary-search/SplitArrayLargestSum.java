/** Return the min largest sum of the split
  * split nums[] into k non-empty sub arr to get min of largest sum among sub arrs */
// leetcode 410
// binary-search: left-bound + map-func
// T: O(logN), S: O(1).
public class Solution {
    // state
    private int[] nums;
    // main method
    public int splitArray(int[] nums, int k) {
        // const
        this.nums = nums;
        int N = nums.length;
        int K = k;
        // var
        long left = 0;
        long right = 0; // [left, right]
        for (int i = 0; i < N; i++) {
            left = Math.max(left, nums[i]); // left ~ max of f(x)
            right += nums[i]; // right ~ min of f(x)
        }
        // binary search left bound
        while (left <= right) {
            // calc mid
            long mid = left + (right-left)/2;
            int curK = f(mid);
            // step next
            if (curK > K)
                left = mid+1;
            else if (curK < K)
                right = mid-1;
            else
                right = mid-1;
        }
        // return
        return (int)left;
    }
    // support method
    private int f(long x) { // f(x) ~ -x
        // const
        int N = nums.length;
        // res
        int k = 0;
        // calc res
        for (int i = 0; i < N; ) {
            long curSum = x;
            while (i < N) {
                if (curSum < nums[i])
                    break;
                else
                    curSum -= nums[i];
                ++i;
            }
            ++k;
        }
        // return res
        return k;
    }
}
