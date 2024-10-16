/** Return the max vol of water possible to contain
  * height[i] = height of i-th bar, every bar's width is 1 */

// leetcode 42
// monotonic-array
// T: O(N)
// S: O(N)

public class Solution {
    // core method
    public int trap(int[] height) {
        // const
        int N = height.length;
        // data struct
        int[] maxLeft = new int[N]; // maxLeft[i] is the max of val ranging [0..i]
        int[] maxRight = new int[N]; // maxRight[i] is the max of val ranging [i..N-1]
        maxLeft[0] = height[0];
        maxRight[N-1] = height[N-1];
        for (int i = 1; i < N; i++)
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        for (int i = N-2; i >= 0; i--)
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        // res
        int totArea = 0;
        // one pointer && update res
        for (int i = 1; i < N-1; i++) { // [i, N-2]
            int curMaxH = Math.min(maxLeft[i], maxRight[i]);
            totArea += curMaxH - height[i]; // width is 1
        }
        // return res
        return totArea;
    }
}

// leetcode 42 follow-up
// monotonic-state + two-pointers:left-right
// T: O(N)
// S: O(1)

public class Solution {
    // core method
    public int trap(int[] height) {
        // const
        int N = height.length;
        // var
        int left = 0;
        int right = N-1; // [left, right]
        int maxLeft = 0;
        int maxRight = 0;
        int totArea = 0;
        // two-pointers:left-right
        while (left < right) {
            int valLeft = height[left];
            int valRight = height[right];
            // update states
            maxLeft = Math.max(maxLeft, valLeft);
            maxRight = Math.max(maxRight, valRight);
            // step next && update res
            if (maxLeft > maxRight) {
                totArea += maxRight - valRight;
                --right;
            } else {
                totArea += maxLeft - valLeft;
                ++left;
            }
        }
        // return res
        return totArea;
    }
}
