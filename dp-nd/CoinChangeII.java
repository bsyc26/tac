/** Return the num of combs of coins[] (can be re-used) make up the amount, else 0 */
public class Solution { // leetcode 518
    // dp-table: knapsack
    public int change(int amount, int[] coins) { // T: O(MN), S: O(MN).
        // const
        int N = coins.length;
        int SUM = amount;
        // data struct
        int[][] dp = new int[1+N][1+SUM]; // int: combs of coins[0..i] to make j
        // base case
        for (int i = 0; i <= N; i++)
            dp[i][0] = 1; // dp[0][j] = 0
        // state transfer
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= SUM; j++) {
                int coin = coins[i-1];
                if (j - coin >= 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin]; // coin can be re-used
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        // return
        return dp[N][SUM];
    }
}
