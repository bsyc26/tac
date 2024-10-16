/** Return start and end idx of given target value in sorted non-decreasing nums[], else [-1, -1] */

// leetcode 34
// binary-search:low-high-bound
// T: O(logN)
// S: O(1).

public class Solution {
    // core method
    public int[] searchRange(int[] nums, int target) {
        // edge case
        if (nums.length == 0) return new int[]{ -1, -1 };
        // consts
        int N = nums.length;
        int[] arr = nums;
        target = target;
        // res
        int[] indices = new int[2]; // [start, end]
        indices[0] = lowBound(arr, target); 
        indices[1] = highBound(arr, target);
        // return res
        return indices;
    }

    // support methods
    private int lowBound(int[] arr, int target) {
        // const
        int N = arr.length;
        // vars
        int lo = 0;
        int hi = N-1; // [lo, hi]
        // binary-search:low-bound
        while (lo <= hi) {
            // calc mid && get arr[mid]
            int mid = lo + (hi-lo)/2;
            int cur = arr[mid];
            // step next
            if (cur < target)
                lo = mid+1;
            else if (cur > target)
                hi = mid-1;
            else
                hi = mid-1;
        }
        // return -1 if outside range with no target guarantee 
        if (lo < 0 || lo >= N) return -1;
        // return low-bound if its val equals target
        return (arr[lo] == target) ? lo : -1;
    }
    private int highBound(int[] arr, int target) {
        // const
        int N = arr.length;
        // vars
        int lo = 0;
        int hi = N-1; // [lo, hi]
        // binary-search:high-bound
        while (lo <= hi) {
            // calc mid && get arr[mid]
            int mid = lo + (hi-lo)/2;
            int cur = arr[mid];
            // step next
            if (cur < target)
                lo = mid+1;
            else if (cur > target)
                hi = mid-1;
            else
                lo = mid+1;
        }
        // return -1 if outside range with no target guarantee
        if (hi < 0 || hi >= N) return -1;
        // return right-bound if its val is TARGET
        return (arr[hi] == target) ? hi : -1;
    }
}
