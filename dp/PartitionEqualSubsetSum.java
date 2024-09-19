/** Return true if can partition the nums[] into two subsets with equal sum of elems */
public class Solution { // leetcode 416
    // dp-table: knapsack
    public boolean canPartition(int[] nums) { // T: O(MN), S: O(MN).
        // const
        int N = nums.length;
        // var
        int sum = 0;
        for (int num : nums)
            sum += num;
        // edge case
        if (sum % 2 != 0) return false;
        // const
        int HALF_SUM = sum / 2;
        // data struct
        boolean[][] dp = new boolean[1+N][1+HALF_SUM]; // true: num[0..i] can make j
        // base case
        for (int i = 0; i <= N; i++)
            dp[i][0] = true; // dp[0][j] is false
        // state transfer
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= HALF_SUM; j++) {
                int num = nums[i-1];
                if (j - num >= 0)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-num];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        // return
        return dp[N][HALF_SUM]; // whether 1..N can form HALF_SUM
    }
}
