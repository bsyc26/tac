/** Return the min num of coins to make up amount else -1
  * coins[i] is the choice of coin, can use infinite num of each kind */

// leetcode 322
// dp-table
// T: O(N)
// S: O(N)

import java.util.Arrays;

public class Solution {
    // core method
    public int coinChange(int[] coins, int amount) {
        // const
        int N = amount; // required sum
        int DF_VAL = amount+1; // default value
        // DS
        int[] dp = new int[N+1]; // [0, 1..N]
        Arrays.fill(dp, DF_VAL);
        // base case
        dp[0] = 0;
        // state transfer
        for (int i = 0; i <= N; i++) {
            for (int coin : coins) {
                if (i < coin)
                    continue;
                else
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }
        // return dp[N] if not DF_VAL
        return (dp[N] == DF_VAL) ? -1 : dp[N];
    }
}
