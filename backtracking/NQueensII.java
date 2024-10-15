/** Return the num of sols to n x n n-queens */

// leetcode 52
// backtracking
// T: O(N!)
// S: O(N^2)

import java.util.List;
import java.util.ArrayList;

public class Solution {
    // states
    private char[][] board;
    private int numSoln;

    // core method
    public int totalNQueens(int n) {
        // const
        int N = n;
        // fields
        this.numSoln = 0;
        this.board = new char[N][N];
        for (int row = 0; row < N; row++)
            for (int col = 0; col < N; col++)
                this.board[row][col] = '.';
        // backtracking
        backtrack(0); // starts from row == 0
        // return
        return this.numSoln;
    }

    // support methods
    private void backtrack(int row) {
        // const
        int N = this.board.length;
        // base case
        if (row == N) {
            this.numSoln++;
            return;
        }
        // backtracking
        for (int col = 0; col < N; col++) {
            // jump invalid
            if (!isValid(row, col)) continue;
            // make decision
            this.board[row][col] = 'Q';
            // next level
            backtrack(row+1);
            // cancel decision
            this.board[row][col] = '.';
        }
    }
    private boolean isValid(int row, int col) { // given 'Q' at board[row][col]
        // const
        int N = this.board.length;
        // is conflict in the same col
        for (int i = 0; i < row; i++)
            if (this.board[i][col] == 'Q')
                return false;
        // is conflict along upper-left diag
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--)
            if (this.board[i][j] == 'Q')
                return false;
        // is conflict along upper-right diag
        for (int i = row-1, j = col+1; i >= 0 && j < N; i--, j++)
            if (this.board[i][j] == 'Q')
                return false;
        // return true if pass all tests
        return true;
    }
}
