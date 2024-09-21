/** Return the max vol of water possible to contain
  * height[i] = height of i-th bar, every bar's width is 1 */
public class Solution { // leetcode 42
    // two-pointers: left-right
    public int trap(int[] height) { // T: O(N), S: O(1).
        // const
        int N = height.length;
        // var
        int left = 0;
        int right = N-1;
        int maxLeft = 0;
        int maxRight = 0;
        int totArea = 0;
        // two pointers
        while (left < right) {
            // update state
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            // step left or right
            if (maxLeft < maxRight) {
                totArea += maxLeft - height[left];
                ++left;
            } else {
                totArea += maxRight - height[right];
                --right;
            }
        }
        // return
        return totArea;
    }
}
