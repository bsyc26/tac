/** Return the max vol of water possible to contain
  * height[i] = height of i-th bar, every bar's width is 1 */
public class Solution { // leetcode 42
    // one-pointer: monotonic-array
    public int trap(int[] height) { // T: O(N), S: O(N).
        // const
        int N = height.length;
        // data struct
        int[] maxLeft = new int[N];
        int[] maxRight = new int[N];
        maxLeft[0] = height[0];
        maxRight[N-1] = height[N-1];
        for (int i = 1; i < N; i++)
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        for (int i = N-2; i >= 0; i--)
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        // var
        int totArea = 0;
        // one-pointer
        for (int i = 1; i < N-1; i++) {
            int curH = Math.min(maxLeft[i], maxRight[i]);
            totArea += curH - height[i];
        }
        // return
        return totArea;
    }
}
