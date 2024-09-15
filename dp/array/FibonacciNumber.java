/** Calc F(n) based on Fibonacci sequence
  * F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2) */
public class Solution { // leetcode 509
    // dp-table + bot2top
    public int fib(int n) { // T: O(N), S: O(N).
        // edge case
        if (n == 0 || n == 1) return n;
        // const
        int N = n;
        // data struct
        int[] dp = new int[N+1]; // [0..N]
        // base case
        dp[0] = 0;
        dp[1] = 1;
        // state transfer
        for (int i = 2; i <= N; i++)
            dp[i] = dp[i-1] + dp[i-2];
        // return
        return dp[N];
    }
}


/** Calc F(n) based on Fibonacci sequence
  * F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2) */
public class Solution { // leetcode 509
    // fields
    private int[] memo;
    // dp-memo + top2bot + recur
    public int fib(int n) { // T: O(N), S: O(N).
        // const
        int N = n;
        // data struct
        memo = new int[N+1]; // [0..N]
        // return
        return dp(N);
    }
    private int dp(int num) {
        // base case
        if (num == 0 || num == 1)
            return num;
        // jump memo
        if (memo[num] != 0)
            return memo[num];
        // state transfer
        memo[num] = dp(num-1) + dp(num-2);
        // return
        return memo[num];
    }
}
