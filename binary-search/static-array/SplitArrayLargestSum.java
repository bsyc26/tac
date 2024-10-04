/** Return the min largest sum of the split
  * split nums[] into k non-empty sub arr to get min of largest sum among sub arrs */
// leetcode 410
// binary-search: left-bound + map-func
// T: O(logN), S: O(1).
public class Solution {
    public int splitArray(int[] nums, int k) {
        // const
        int N = nums.length;
        int K = k;
        // var
        long left = 0;
        long right = 1; // [left, right)
        for (int i = 0; i < N; i++) {
            left = Math.max(left, nums[i]); // left ~ max of f(x)
            right += nums[i]; // right ~ min of f(x)
        }
        // binary search
        while (left < right) {
            // calc mid
            long mid = left + (right-left)/2;
            int curK = f(nums, mid);
            // step next
            if (curK > K)
                left = mid+1;
            else if (curK < K)
                right = mid;
            else
                right = mid;
        }
        // return
        return (int)left;
    }
    private int f(int[] nums, long x) { // f(x) ~ -x
        int N = nums.length; // const
        int k = 0; // res
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
        return k; // return res
    }
}
