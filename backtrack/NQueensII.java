import java.util.List;
import java.util.ArrayList;
/** Return the num of sols to n x n n-queens */
public class Solution { // leetcode 52
    // field
    private int numSolNQ = 0;
    // backtrack
    public int totalNQueens(int n) { // T: O(N!), S: O(N).
        // const
        int N = n;
        // data struct
        List<String> board = new ArrayList<>();
        for (int i = 0; i < N; i++)
            board.add(".".repeat(N));
        // backtrack
        backtrack(board, 0);
        // return
        return numSolNQ;
    }
    private void backtrack(List<String> board, int row) {
        // const
        int N = board.size();
        // base case
        if (row == N) { // find a new sol to NQ
            ++numSolNQ;
            return;
        }
        // backtrack
        for (int i = 0; i < N; i++) {
            // jump invalid
            if (!isValid(board, row, i))
                continue;
            // make decision
            char[] rowChars = board.get(row).toCharArray();
            rowChars[i] = 'Q';
            board.set(row, new String(rowChars));
            // next level
            backtrack(board, 1+row);
            // cancel decision
            rowChars[i] = '.';
            board.set(row, new String(rowChars));
        }
    }
    private boolean isValid(List<String> board, int row, int col) {
        // const
        int N = board.size();
        // is conflict in col
        for (int i = 0; i < row; i++)
            if (board.get(i).charAt(col) == 'Q')
                return false;
        // is conflict in upper left diag
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--)
            if (board.get(i).charAt(j) == 'Q')
                return false;
        // is conflict in upper right diag
        for (int i = row-1, j = col+1; i >= 0 && j < N; i--, j++)
            if (board.get(i).charAt(j) == 'Q')
                return false;
        // return fallback
        return true;
    }
}
