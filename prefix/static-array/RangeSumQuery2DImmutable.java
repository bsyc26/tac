/** Implement the NumMatrix class
  * NumMatrix(int[][] matrix): inits the obj with matrix[][]
  * int sumRegion(int row1, int col1, int row2, int col2): returns the sum of region */
public class NumMatrix { // leetcode 304
    // field
    private int[][] preSum;
    // constructor
    public NumMatrix(int[][] matrix) { // T: O(MN), S: O(MN).
        // const
        int M = matrix.length;
        int N = matrix[0].length;
        // data struct
        preSum = new int[M+1][N+1]; // preSum[0][..] and preSum[..][0] is 0
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++)
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1];
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) { // T: O(1).
        return preSum[row2+1][col2+1]
                - preSum[row2+1][col1]
                - preSum[row1][col2+1]
                + preSum[row1][col1];
    }
}
