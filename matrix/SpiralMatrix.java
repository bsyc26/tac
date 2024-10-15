import java.util.List;
import java.util.LinkedList;
/** Return all elem of matrix in a sprial order */
// leetcode 54
// matrix
// T: O(MN), S: O(1).
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // const
        int M = matrix.length;
        int N = matrix[0].length;
        // var
        int up = 0;
        int dn = M-1;
        int lf = 0;
        int rt = N-1;
        // res
        List<Integer> spiralOrder = new LinkedList<>();
        // spiral order
        while (spiralOrder.size() < M*N) {
            // uppermost, from left to right
            if (up <= dn) {
                for (int col = lf; col <= rt; col++)
                    spiralOrder.add(matrix[up][col]);
                ++up;
            }
            // rightmost, from up to down 
            if (lf <= rt) {
                for (int row = up; row <= dn; row++)
                    spiralOrder.add(matrix[row][rt]);
                --rt;
            }
            // lowermost, from right to left
            if (up <= dn) {
                for (int col = rt; col >= lf; col--)
                    spiralOrder.add(matrix[dn][col]);
                --dn;
            }
            // leftmost, from down to up
            if (lf <= rt) {
                for (int row = dn; row >= up; row--)
                    spiralOrder.add(matrix[row][lf]);
                ++lf;
            }
        }
        // return res
        return spiralOrder;
    }
}
