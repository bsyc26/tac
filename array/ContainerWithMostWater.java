/** Return the max area of container can be formed
  * height[i] is the height of i-th vertical line */

// leetcode 11
// monotonic-state
// T: O(N)
// S: O(1)

public class Solution {
    public int maxArea(int[] height) {
        // const
        int N = height.length;
        // var
        int left = 0;
        int right = N-1; // [left, right]
        // res
        int maxArea = 0;
        // two-pointers:left-right
        while (left < right) {
            // calc cur
            int curH = Math.min(height[left], height[right]); // area is determined by the lower height
            int curW = right - left;
            int curArea = curH * curW;
            // update res
            maxArea = Math.max(maxArea, curArea);
            // step next
            if (height[left] < height[right]) // change lower height might lead to a bigger area
                ++left;
            else
                --right;
        }
        // return res
        return maxArea;
    }
}
