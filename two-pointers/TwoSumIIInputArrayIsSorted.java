/** Return the indices of [idx1, idx2] of elems in sorted numbers[] sum up to target */

// leetcode 167
// two-pointers:left-right
// T: O(N)
// S: O(1)

public class Solution {
    // core method
    public int[] twoSum(int[] numbers, int target) {
        // const
        int N = numbers.length;
        // var
        int left = 0;
        int right = N-1;
        // two-pointers:left-right
        while (left < right) {
            // calc cur
            int curSum = numbers[left] + numbers[right];
            // step next
            if (curSum > target)
                --right;
            else if (curSum < target)
                ++left;
            else // find two vals sum equal to target
                return new int[]{ left+1, right+1 }; // 1-index
        }
        // return fallback
        return new int[]{ -1, -1 };
    }
}
