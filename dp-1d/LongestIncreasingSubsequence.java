/** Return the max len of strictly increasing sub seq (can be non-consecutive) of nums[] */

// leetcode 300
// dp-table
// T: O(N^2)
// S: O(N)

public class Solution {
    // core method
    public int lengthOfLIS(int[] nums) {
        // const
        int[] arr = nums;
        int N = arr.length;
        // res
        int maxLen = 1; // at least 1
        // DS
        int[] dp = new int[N];
        // base case
        for (int i = 0; i < N; i++)
            dp[i] = 1; // dp[i] is at least 1
        // state transfer
        for (int i = 0; i < N; i++) { // i: [0..N)
            for (int j = 0; j < i; j++) { // j: [0..i)
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    maxLen = Math.max(maxLen, dp[i]); // update res
                }
            }
        }
        // return res
        return maxLen; 
    }
}
