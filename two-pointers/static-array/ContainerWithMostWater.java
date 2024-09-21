/** Return the max area of container can be formed
  * height[i] is the height of i-th vertical line */
public class Solution { // leetcode 11
    // two-pointers: left-right
    public int maxArea(int[] height) { // T: O(N), S: O(1).
        // const
        int N = height.length;
        // var
        int left = 0;
        int right = N-1;
        int maxArea = 0;
        // two pointers
        while (left < right) {
            // comp state
            int curH = Math.min(height[left], height[right]);
            int curArea = curH * (right-left);
            maxArea = Math.max(maxArea, curArea);
            // step left or right
            if (height[left] < height[right]) // move lo side to seek for a possible hi H
                ++left;
            else
                --right;
        }
        // return
        return maxArea;
    }
}
