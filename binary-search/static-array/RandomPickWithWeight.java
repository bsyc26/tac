import java.util.Random;
/** Implement the function pickIndex() to randomly return an index with prob of w[i]/sum(w) */
// leetcode 528
// binary-search: left-bound + preSum
// T: O(logN), S: O(N).
public class Solution {
    // field
    private int[] preSum;
    private Random rand = new Random();
    private final int N;
    // constructor
    public Solution(int[] w) {
        // const
        N = w.length;
        // data struct
        preSum = new int[N+1];
        preSum[0] = 0;
        for (int i = 1; i <= N; i++)
            preSum[i] = preSum[i-1] + w[i-1];
    }
    public int pickIndex() {
        int N = preSum.length; // const
        int target = rand.nextInt(preSum[N-1]) + 1; // [1, preSum[N-1]]
        return left_bound(preSum, target)-1;
    }
    private int left_bound(int[] nums, int TARGET) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right-left)/2;
            int cur = nums[mid];
            if (cur > TARGET)
                right = mid;
            else if (cur < TARGET)
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }
}
