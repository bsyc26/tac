import java.util.Arrays;
/** Return the max num of envelopes can do Russsian Doll
  * envelops[i] = [w, h] is the width and height of an envelope
  * Russian Doll can be done only if the outer one has both greater width and height */
public class Solution { // leetcode 354
    // binary-search: patience-sorting + sort
    public int maxEnvelopes(int[][] envelopes) { // T: O(NlogN), S: O(N).
        // const
        int N = envelopes.length;
        // var
        int[][] mat = new int[N][2]; // mat[i][0] is width, mat[i][1] is height
        for (int i = 0; i < N; i++)
            mat[i] = Arrays.copyOf(envelopes[i], 2);
        Arrays.sort(mat, (int[] aa, int[] bb) -> { // 1st increasing width, 2nd decreasing width
            return (aa[0] == bb[0]) ? bb[1] - aa[1] : aa[0] - bb[0];
        });
        // var
        int[] heights = new int[N];
        for (int i = 0; i < N; i++)
            heights[i] = mat[i][1];
        // return
        return maxLenLIS(heights);
    }
    private int maxLenLIS(int[] arr) {
        // const
        int N = arr.length;
        // data struct
        int[] tops = new int[N];
        int piles = 0;
        // one pointer
        for (int i = 0; i < N; i++) {
            int poker = arr[i];
            // binary search: left-bound
            int lo = 0;
            int hi = piles;
            while (lo < hi) {
                // calc mid
                int mid = lo + (hi-lo)/2;
                // cond step
                if (tops[mid] < poker)
                    lo = mid+1;
                else
                    hi = mid;
            }
            // place poker
            if (lo == piles)
                ++piles;
            tops[lo] = poker;
        }
        // return
        return piles;
    }
}
