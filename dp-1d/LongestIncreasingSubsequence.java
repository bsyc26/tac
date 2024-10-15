/** Return the max len of strictly increasing sub seq (can be non-consecutive) of nums[] */
public class Solution { // leetcode 300
    // dp-table
    public int lengthOfLIS(int[] nums) { // T: O(N2), S: O(N).
        // const
        int N = nums.length;
        // data struct
        int[] dp = new int[N]; // dp[i] is the max len of seq ended at nums[i]
        for (int i = 0; i < N; i++)
            dp[i] = 1; // dp[i] is at least 1
        // var
        int maxLen = 1;
        // state transfer
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        // return
        return maxLen; 
    }
}
