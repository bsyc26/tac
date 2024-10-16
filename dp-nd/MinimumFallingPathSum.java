/** Return the min sum of falling path through n x n matrix
  * falling path: (row, col) will be (row+1, col) or (row+1, col-1) or (row+1, col+1) */

// leetcode 931
// dp-table
// T: O(N^2)
// S: O(N^2)

public class Solution {
    // core method
    public int minFallingPathSum(int[][] matrix) {
        // const
        int N = matrix.length;
        int MAX = Integer.MAX_VALUE;
        // res
        int minSum = MAX;
        // DS
        int[][] dp = new int[N][N]; // dp[i][j] is the min sum ended at (i, j)
        // base case
        for (int col = 0; col < N; col++)
            dp[0][col] = matrix[0][col]; // dp[0][col] is at least elem of matrix[0][col]
        // state transfer
        for (int row = 1; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int cur = matrix[row][col];
                int up = dp[row-1][col];
                int lfup = (col >= 1) ? dp[row-1][col-1] : MAX;
                int rtup = (col < N-1) ? dp[row-1][col+1] : MAX;
                dp[row][col] = cur + Math.min(up, Math.min(lfup, rtup));
            }
        }
        // get res
        for (int col = 0; col < N; col++) // traverse last row
            minSum = Math.min(minSum, dp[N-1][col]);
        // return res
        return minSum;
    }
}
