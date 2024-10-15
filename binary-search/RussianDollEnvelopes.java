import java.util.Arrays;
/** Return the max num of envelopes can do Russsian Doll
  * envelops[i] = [w, h] is the width and height of an envelope
  * Russian Doll can be done only if the outer one has both greater width and height */
// leetcode 354
// binary-search: patience-sorting
// T: O(NLogN), S: O(N).
public class Solution {
    // main method
    public int maxEnvelopes(int[][] envelopes) {
        // const
        int N = envelopes.length;
        // var
        int[][] mat = new int[N][2]; // mat[i][0] is width, mat[i][1] is height
        for (int i = 0; i < N; i++)
            mat[i] = Arrays.copyOf(envelopes[i], 2);
        Arrays.sort(mat, (int[] a, int[] b) -> { // 1st increasing width, 2nd decreasing width
            return (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0];
        });
        // res
        int[] heights = new int[N];
        for (int i = 0; i < N; i++)
            heights[i] = mat[i][1];
        // return res
        return patienceSort(heights);
    }
    // support method
    private int patienceSort(int[] nums) { // return len of longest increasing subsequence (LIS)
        // const
        int N = nums.length;
        // data struct
        int[] tops = new int[N];
        int piles = 0;
        // one pointer
        for (int i = 0; i < N; i++) {
            int poker = nums[i];
            int left = 0;
            int right = piles-1;
            // binary search: left-bound
            while (left <= right) {
                // calc mid
                int mid = left + (right-left)/2;
                int cur = tops[mid];
                // step next
                if (cur < poker)
                    left = mid+1;
                else if (cur > poker)
                    right = mid-1;
                else
                    right = mid-1;
            }
            if (left == piles) // need new piles
                ++piles;
            tops[left] = poker; // place poker
        }
        // return
        return piles;
    }
}
