/** Return start and end idx of given target value in sorted non-decreasing nums[], else [-1, -1] */
// leetcode 34
// binary-search: left-right-bound
// T: O(logN), S: O(1).
public class Solution {
    // main method
    public int[] searchRange(int[] nums, int target) {
        // edge case
        if (nums.length == 0) return new int[]{ -1, -1 };
        // const
        int N = nums.length;
        int TARGET = target;
        // var
        int left = 0;
        int right = N;
        // res
        int[] res = new int[2]; // [start, end]
        res[0] = leftBound(nums, TARGET); 
        res[1] = rightBound(nums, TARGET);
        // return res
        return res;
    }
    // support methods
    private int leftBound(int[] nums, int TARGET) {
        // const
        int N = nums.length;
        // var
        int left = 0;
        int right = N-1; // [left, right]
        // binary search
        while (left <= right) {
            // calc mid
            int mid = left + (right-left)/2;
            int cur = nums[mid];
            // step next
            if (cur < TARGET)
                left = mid+1;
            else if (cur > TARGET)
                right = mid-1;
            else
                right = mid-1;
        }
        // return -1 if outside range
        if (left < 0 || left >= N) return -1;
        // return left-bound if its val is TARGET
        return (nums[left] == TARGET) ? left : -1;
    }
    private int rightBound(int[] nums, int TARGET) {
        // const
        int N = nums.length;
        // var
        int left = 0;
        int right = N-1; // [left, right]
        // binary search
        while (left <= right) {
            // calc mid
            int mid = left + (right-left)/2;
            int cur = nums[mid];
            // step next
            if (cur < TARGET)
                left = mid+1;
            else if (cur > TARGET)
                right = mid-1;
            else
                left = mid+1;
        }
        // return -1 if outside range
        if (right < 0 || right >= N) return -1;
        // return right-bound if its val is TARGET
        return (nums[right] == TARGET) ? right : -1;
    }
}
