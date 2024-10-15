/** Implement the NumMatrix class
  * NumMatrix(int[][] matrix): inits the obj with matrix[][]
  * int sumRegion(int row1, int col1, int row2, int col2): returns the sum of region */
// leetcode 304
// prefix: pre-sum
// T: O(MN), S: O(MN).
public class NumMatrix {
    // state
    private int[][] preSum; // preSum[i][j] is sum of elems from matrix[0][0] to matrix[i-1][j-1]
    // constructor
    public NumMatrix(int[][] matrix) {
        int M = matrix.length; // const
        int N = matrix[0].length; // const
        preSum = new int[M+1][N+1]; // data struct
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++)
                preSum[i][j] = preSum[i-1][j]+ preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1];
        }
    }
    // method
    public int sumRegion(int row1, int col1, int row2, int col2) { // T: O(1).
        return preSum[row2+1][col2+1]
                - preSum[row2+1][col1]
                - preSum[row1][col2+1]
                + preSum[row1][col1];
    }
}
