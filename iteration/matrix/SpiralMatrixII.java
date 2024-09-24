/** Give n, generate n x n matrix with elems from 1 to n^2 in spiral order */
public class Solution { // leetcode 59
    // iteration
    public int[][] generateMatrix(int n) { // T: O(N2), S: O(1).
        // const
        int N = n;
        // var
        int[][] mat = new int[N][N];
        int up = 0;
        int dn = N-1;
        int lf = 0;
        int rt = N-1;
        int num = 1; // num to fill in mat
        // iter
        while (num <= N*N) {
            // uppermost, from left to right
            if (up <= dn) {
                for (int col = lf; col <= rt; col++) {
                    mat[up][col] = num;
                    ++num;
                }
                ++up;
            }
            // rightmost, from up to down
            if (lf <= rt) {
                for (int row = up; row <= dn; row++) {
                    mat[row][rt] = num;
                    ++num;
                }
                --rt;
            }
            // lowermost, from right to left
            if (up <= dn) {
                for (int col = rt; col >= lf; col--) {
                    mat[dn][col] = num;
                    ++num;
                }
                --dn;
            }
            // leftmost, from down to up
            if (lf <= rt) {
                for (int row = dn; row >= up; row--) {
                    mat[row][lf] = num;
                    ++num;
                }
                ++lf;
            }
        }
        // return
        return mat;
    }
}
