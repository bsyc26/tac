/** Rotate the matrix by 90 degrees clockwise */
public class Solution { // leetcode 48
    // iteration
    public void rotate(int[][] matrix) { // T: O(N2), S: O(1).
        // const
        int N = matrix.length;
        // diag mirror
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                // swap matrix[i][j], matrix[j][i]
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // row rev
        for (int[] row : matrix)
            reverse(row);
    }
    private void reverse(int[] arr) {
        // const
        int N = arr.length;
        // var
        int left = 0;
        int right = N-1;
        // two pointers
        while (left < right) {
            // swap elem
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            // step ptr
            ++left;
            --right;
        }
    }
}
