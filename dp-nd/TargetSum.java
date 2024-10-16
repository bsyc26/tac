/** Return the num of epn can build eval to target from nums[] with '+' and '-' */

// leetcode 494
// dp-table:knapsack
// T: O(MN)
// S: O(MN)

public class Solution {
    // core method
    public int findTargetSumWays(int[] nums, int target) {
        // consts
        int[] arr = nums;
        int N = arr.length;
        target = target;
        // var
        int sum = 0;
        for (int elem : arr)
            sum += elem;
        // edge case
        if (sum < Math.abs(target) || (sum+target) % 2 != 0) return 0;
        // const
        int AMT = (sum+target) / 2;
        // data struct
        int[][] dp = new int[N+1][AMT+1];
        // base case
        dp[0][0] = 1; // no item no amount is 1 epn
        // state transfer
        for (int item = 1; item <= N; item++) {
            for (int amt = 0; amt <= AMT; amt++) {
                int cur = arr[item-1]; // 0-index item
                if (amt - cur >= 0)
                    dp[item][amt] = dp[item-1][amt] + dp[item-1][amt-cur];
                else
                    dp[item][amt] = dp[item-1][amt];
            }
        }
        // return res N items for AMT
        return dp[N][AMT];
    }
}

/*
+sum_a - sum_b = target
2sum_a = target + sum
sum_a = (sum + target) / 2

find subset make up (sum+target)/2
*/
