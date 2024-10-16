/** Calc F(n) based on Fibonacci sequence
  * F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2) */

// leetcode 509
// dp-table
// T: O(N)
// S: O(N)

public class Solution {
    // core method
    public int fib(int n) {
        // edge case
        if (n == 0 || n == 1) return n;
        // const
        int N = n;
        // DS
        int[] dp = new int[N+1]; // [0, 1..N]
        // base case
        dp[0] = 0;
        dp[1] = 1;
        // state transfer
        for (int i = 2; i <= N; i++)
            dp[i] = dp[i-1] + dp[i-2];
        // return dp[N]
        return dp[N];
    }
}
