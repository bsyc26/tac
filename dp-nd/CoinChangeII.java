/** Return the num of combs of coins[] (can be re-used) make up the amount, else 0 */

// leetcode 518
// dp-table:knapsack
// T: O(MN)
// S: O(MN)

public class Solution {
    // core method
    public int change(int amount, int[] coins) {
        // const
        int N = coins.length;
        int AMT = amount;
        // DS
        int[][] dp = new int[N+1][AMT+1];
        // base case
        // dp[0][j] = 0; // zero item any bag is not a comb
        for (int i = 0; i <= N; i++)
            dp[i][0] = 1; // one item zero bag is a comb
        // state transfer
        for (int item = 1; item <= N; item++) { // traverse items
            for (int amt = 1; amt <= AMT; amt++) { // traverse bags
                int cur = coins[item-1]; // 0-index
                if (amt - cur >= 0) // bag can contain item
                    dp[item][amt] = dp[item-1][amt] + dp[item][amt-cur]; // can re-use
                else
                    dp[item][amt] = dp[item-1][amt];
            }
        }
        // return res
        return dp[N][AMT];
    }
}
