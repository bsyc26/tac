import java.util.List;
import java.util.ArrayList;
/** Return all sols of n-queens on n x n board in any order
  * 'Q' indicates a queen and '.' is an empty space */
public class Solution { // leetcode 51
    // field
    private List<List<String>> solsNQ = new ArrayList<>();
    // backtrack
    public List<List<String>> solveNQueens(int n) { // T: O(N!), S: O(N).
        // const
        int N = n;
        // data struct
        List<String> board = new ArrayList<>();
        for (int i = 0; i < N; i++)
            board.add(".".repeat(N));
        // backtrack
        backtrack(board, 0);
        // return
        return solsNQ;
    }
    private void backtrack(List<String> board, int row) {
        // const
        int N = board.size();
        // base case
        if (row == N) {
            solsNQ.add(new ArrayList<>(board)); // deep copy to make values immutable
            return;
        }
        // backtrack
        for (int col = 0; col < N; col++) {
            // jump invalid
            if (!isValid(board, row, col))
                continue;
            // make decision
            char[] rowChars = board.get(row).toCharArray();
            rowChars[col] = 'Q';
            board.set(row, new String(rowChars));
            // next level
            backtrack(board, 1+row);
            // cancel decision
            rowChars[col] = '.';
            board.set(row, new String(rowChars));
        }
    }
    private boolean isValid(List<String> board, int row, int col) { // is conflict of 'Q' at [row, col]
        // const
        int N = board.size();
        // is conflict in col
        for (int i = 0; i < row; i++)
            if (board.get(i).charAt(col) == 'Q')
                return false;
        // is conflict in top left diag
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--)
            if (board.get(i).charAt(j) == 'Q')
                return false;
        // is conflict in top right diag
        for (int i = row-1, j = col+1; i >= 0 && j < N; i--, j++)
            if (board.get(i).charAt(j) == 'Q')
                return false;
        // return fallback
        return true;
    }
}
