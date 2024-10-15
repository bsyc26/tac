/** Return the idx of elem whose val equals to target in sorted ascending nums[], else -1 */
// leetocde 704
// binary-search
// T: O(logN), S: O(1).
public class Solution {
    public int search(int[] nums, int target) {
        // const
        int N = nums.length;
        int TARGET = target;
        // var
        int left = 0;
        int right = N-1; // [left, right]
        // binary search 
        while (left <= right) {
            // calc mid
            int mid = left + (right-left)/2;
            int cur = nums[mid];
            // step next
            if (cur > TARGET)
                right = mid-1;
            else if (cur < TARGET)
                left = mid+1;
            else
                return mid;
        }
        // return fallback
        return -1;
    }
}
