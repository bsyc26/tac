/** Return the indices of [idx1, idx2] of elems in numbers[] sum up to target */
public class Solution { // leetcode 167
    // two-pointers: left-right
    public int[] twoSum(int[] numbers, int target) { // T: O(N), S: O(1).
        // const
        int N = numbers.length;
        int TGT = target; // required sum of two elems
        // var
        int left = 0;
        int right = N-1;
        // two pointers
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            // binary search
            if (sum > TGT)
                --right;
            else if (sum < TGT)
                ++left;
            else 
                return new int[]{ left+1, right+1 }; // 1-index
        }
        // return fallback
        return new int[]{ -1, -1 };
    }
}
