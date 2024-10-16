/** Return true if can partition the nums[] into two subsets with equal sum of elems */

// leetcode 416
// dp-table: knapsack
// T: O(MN)
// S: O(MN)

public class Solution {
    // core method
    public boolean canPartition(int[] nums) {
        // const
        int[] arr = nums;
        int N = arr.length;
        // var
        int sum = 0;
        for (int elem : arr)
            sum += elem;
        // edge case
        if (sum % 2 != 0) return false;
        // const
        int AMT = sum / 2;
        // DS
        boolean[][] dp = new boolean[N+1][AMT+1]; // dp[i][j] true if i items make j amt
        // base case
        for (int item = 0; item <= N; item++)
            dp[item][0] = true; // one item zero amount is true
        // state transfer
        for (int item = 1; item <= N; item++) { // traverse the items
            for (int amt = 1; amt <= AMT; amt++) { // traverse the bags
                int cur = arr[item-1]; // 0-index item
                if (amt - cur >= 0) // item can put in bag
                    dp[item][amt] = dp[item-1][amt] || dp[item-1][amt-cur];
                else
                    dp[item][amt] = dp[item-1][amt];
            }
        }
        // return res: N items to put into AMT bags
        return dp[N][AMT];
    }
}
