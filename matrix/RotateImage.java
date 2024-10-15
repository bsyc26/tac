/** Rotate the n x n matrix by 90 degrees clockwise */
// leetcode 48
// matrix
// T: O(N2), S: O(N1).
public class Solution {
    // main method
    public void rotate(int[][] matrix) { // rotate == diag mirror + reverse row
        transpose(matrix);
        for (int[] row : matrix)
            reverse(row);
    }

    // support methods
    private void transpose(int[][] mat) { // diag (top-lf to bot-rt) mirror
        // const
        int N = mat.length;
        // traverse matrix
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                // swap
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
    }
    private void reverse(int[] nums) { // reverse the order of nums[]
        // const
        int N = nums.length;
        // var
        int left = 0;
        int right = N-1;
        // two pointers: left-right
        while (left < right) {
            // swap
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            // step next
            ++left;
            --right;
        }
    }
}
