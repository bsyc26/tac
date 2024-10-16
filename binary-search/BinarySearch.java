/** Return the idx of elem whose val equals to target in sorted ascending nums[], else -1 */

// leetocde 704
// binary-search
// T: O(logN)
// S: O(1).

public class Solution {
    // core method
    public int search(int[] nums, int target) {
        // const
        int N = nums.length;
        target = target;
        int[] arr = nums;
        // var
        int lo = 0;
        int hi = N-1; // [lo, hi]
        // binary-search 
        while (lo <= hi) {
            // calc mid && get nums
            int mid = lo + (hi-lo)/2;
            int cur = arr[mid];
            // step next
            if (cur > target)
                hi = mid-1;
            else if (cur < target)
                lo = mid+1;
            else
                return mid;
        }
        // return fallback -1 if not find target
        return -1;
    }
}
