import java.util.Arrays;
/** Return the min num of coins to make up amount else -1
  * coins[i] is the choice of coin, can use infinite num of each kind */
public class Solution { // leetcode 322
    // dp-table + bot2top + iter
    public int coinChange(int[] coins, int amount) { // T: O(N), S: O(N).
        // const
        int N = amount; // required sum
        int DF = amount+1;
        // data struct
        int[] dp = new int[N+1]; // [0..N]
        Arrays.fill(dp, DF);
        // base case
        dp[0] = 0;
        // state transfer
        for (int i = 0; i <= N; i++) { // i is idx && is cur sum of coins
            for (int coin : coins) {
                if (i < coin)
                    continue;
                else
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]); // dp[i] is the num of coins sum to i
            }
        }
        // return
        return (dp[N] == DF) ? -1 : dp[N];
    }
}


import java.util.Arrays;
/** Return the min num of coins to make up amount else -1
  * coins[i] is the choice of coin, can use infinite num of each kind */
public class Solution { // leetcode 322
    // field
    private int[] memo;
    private int DF; // default value of memo[]
    // dp-memo + top2bot + recur
    public int coinChange(int[] coins, int amount) { // T: O(N), S: O(N).
        // edge case
        if (amount == 0) return 0;
        // constants
        int N = amount;
        DF = amount+1;
        // data struct
        memo = new int[N+1];
        Arrays.fill(memo, DF);
        // return
        return dp(N, coins);
    }
    private int dp(int num, int[] arr) {
        // base case
        if (num == 0)
            return 0;
        if (num < 0)
            return -1;
        // jump memo
        if (memo[num] != DF)
            return memo[num];
        // state transfer
        int cur = DF; // cur to reduce comp between mem-stack and mem-heap
        for (int elem : arr) {
            int sub = dp(num-elem, arr);
            if (sub == -1)
                continue;
            cur = Math.min(cur, 1+sub);
        }
        // update memo
        memo[num] = (cur == DF) ? -1 : cur;
        // return
        return memo[num];
    }
}
