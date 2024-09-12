/** Return start and end idx of given target value in sorted non-decreasing nums[], else [-1, -1]
  * T: O(logN) */
public class Solution { // leetcode 34
    // binary-search: left-right-bound
    public int[] searchRange(int[] nums, int target) { // T: O(logN), S: O(1).
        // edge case
        if (nums.length == 0) return new int[]{ -1, -1 };
        // constants
        int N = nums.length;
        int TGT = target;
        // variables
        int lo = 0;
        int hi = N;
        int[] idxs = new int[2]; // [start, end]
        // binary search bound
        idxs[0] = leftBound(nums, TGT); 
        idxs[1] = rightBound(nums, TGT);
        // return
        return idxs;
    }
    private int leftBound(int[] arr, int TGT) { // binary-search: left-bound
        int lo = 0;
        int hi = arr.length-1;
        while (lo <= hi) { // [lo, hi]
            int mid = lo + (hi-lo)/2;
            if (arr[mid] < TGT)
                lo = mid+1;
            else // arr[mid] >= TGT
                hi = mid-1;
        }
        if (lo < 0 || lo > arr.length-1) return -1;
        return (arr[lo] == TGT) ? lo : -1;
    }
    private int rightBound(int[] arr, int TGT) { // binary-search: right-bound
        int lo = 0;
        int hi = arr.length-1;
        while (lo <= hi) { // [lo, hi]
            int mid = lo + (hi-lo)/2;
            if (arr[mid] > TGT)
                hi = mid-1;
            else // arr[mid] <= TGT
                lo = mid+1;
        }
        if (hi < 0 || hi > arr.length-1) return -1;
        return (arr[hi] == TGT) ? hi : -1;
    }
}
