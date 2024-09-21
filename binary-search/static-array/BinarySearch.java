/** Return the idx of elem val equals target in sorted ascending nums[], else -1
  * T: O(logN) */
public class Solution { // leetcode 704
    // binary-search
    public int search(int[] nums, int target) { // T: O(logN), S: O(1).
        // const
        int N = nums.length;
        int TGT = target;
        // var
        int lo = 0;
        int hi = N-1;
        // binary search
        while (lo <= hi) { // [lo, hi]
            int mid = lo + (hi-lo)/2;
            int cur = nums[mid];
            if (cur < TGT)
                lo = mid+1;
            else if (cur > TGT)
                hi = mid-1;
            else // cur == TGT
                return mid;
        }
        // return fallback
        return -1;
    }
}
