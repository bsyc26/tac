import java.util.Random;
/** Implement the function pickIndex() to randomly return an index with prob of w[i]/sum(w) */
// leetcode 528
// binary-search: left-bound + preSum
// T: O(logN), S: O(N).
public class Solution {
    // states
    private int[] preSum;
    private Random rand;
    private final int N;
    // constructor
    public Solution(int[] w) {
        // var
        rand = new Random();
        // const
        N = w.length;
        // data struct
        preSum = new int[N+1];
        preSum[0] = 0;
        for (int i = 1; i <= N; i++)
            preSum[i] = preSum[i-1] + w[i-1];
    }
    // main method
    public int pickIndex() {
        int N = preSum.length; 
        int target = rand.nextInt(preSum[N-1]) + 1; // [1, preSum[N-1]]
        return left_bound(preSum, target)-1;
    }
    // support method
    private int left_bound(int[] nums, int TARGET) {
        // const
        int N = nums.length;
        // var
        int left = 0;
        int right = N-1; // [left, right]
        // binary search
        while (left <= right) {
            // calc mid
            int mid = left + (right-left)/2;
            int cur = nums[mid];
            // step next
            if (cur > TARGET)
                right = mid-1;
            else if (cur < TARGET)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }
}
