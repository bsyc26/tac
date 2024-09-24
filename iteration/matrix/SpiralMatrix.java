import java.util.List;
import java.util.LinkedList;
/** Return all elem of matrix in a sprial order */
public class Solution { // leetcode 54
    // iteration
    public List<Integer> spiralOrder(int[][] matrix) { // T: O(MN), S: O(1).
        // const
        int M = matrix.length;
        int N = matrix[0].length;
        int up = 0;
        int dn = M-1;
        int lf = 0;
        int rt = N-1;
        // var
        List<Integer> spiralOrder = new LinkedList<>();
        // iter
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
        // return
        return spiralOrder;
    }
}
