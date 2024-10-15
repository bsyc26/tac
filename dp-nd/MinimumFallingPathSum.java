/** Return the min sum of falling path through n x n matrix
  * falling path: (row, col) will be (row+1, col) or (row+1, col-1) or (row+1, col+1) */
public class Solution { // leetcode 931
    // dp-table
    public int minFallingPathSum(int[][] matrix) { // T: O(N2), S: O(N2).
        // const
        int N = matrix.length;
        // var
        int minSum = Integer.MAX_VALUE;
        // data struct
        int[][] dp = new int[N][N]; // dp[i][j] is the min sum ended at (i, j)
        for (int j = 0; j < N; j++)
            dp[0][j] = matrix[0][j];
        // state transfer
        for (int row = 1; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (col == 0)
                    dp[row][col] = matrix[row][col] + Math.min(dp[row-1][col], dp[row-1][col+1]);
                else if (col == N-1)
                    dp[row][col] = matrix[row][col] + Math.min(dp[row-1][col], dp[row-1][col-1]);
                else // col: [1..N-2]
                    dp[row][col] = matrix[row][col]
                        + Math.min(Math.min(dp[row-1][col-1], dp[row-1][col+1]), dp[row-1][col]);
            }
        }
        // get min sum
        for (int j = 0; j < N; j++)
            minSum = Math.min(minSum, dp[N-1][j]);
        // return
        return minSum;
    }
}
