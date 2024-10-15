/** Return the num of epn can build eval to target from nums[] with '+' and '-' */
public class Solution { // leetcode 494
    // dp-table: knapsack
    public int findTargetSumWays(int[] nums, int target) { // T: O(MN), S: O(MN).
        // const
        int N = nums.length;
        // var
        int sum = 0;
        for (int num : nums)
            sum += num;
        // edge case
        if (sum < Math.abs(target) || (sum+target)%2 != 0) return 0;
        // const
        int SUM = (sum+target) / 2;
        // data struct
        int[][] dp = new int[1+N][1+SUM];
        // base case
        dp[0][0] = 1; // dp[0][1..] = 0, dp[i][0] = 0
        // state transfer
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= SUM; j++) {
                int num = nums[i-1];
                if (j-num >= 0)
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-num];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        // return
        return dp[N][SUM];
    }
}

/*
   + sum_a - sum_b = target
    2sum_a = target + sum
    sum_a = (sum + target) / 2

    find subset make up (sum+target)/2
*/
