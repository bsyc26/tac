/** Give n, generate n x n matrix with elems from 1 to n^2 in spiral order */
// leetcode 59
// matrix:iter
// T: O(N2)
// S: O(1).

public class Solution {
    // core method
    public int[][] generateMatrix(int n) {
        // const
        int N = n;
        // res
        int[][] mat = new int[N][N];
        // var
        int up = 0;
        int dn = N-1;
        int lf = 0;
        int rt = N-1;
        int num = 1; // num to fill in mat
        // spiral order
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
        // return res
        return mat;
    }
}
