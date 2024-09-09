/** Remove all occur of val in-place and return the num of elems not equal to val
  * the elems not equal to val must be the first k (num of non-equal-val elems) elems of nums[]*/
public class Solution { // leetcode 27
    // two-pointers: fast-slow
    public int removeElement(int[] nums, int val) { // T: O(N), S: O(1).
        // constants
        int N = nums.length;
        // edge case
        if (N == 0) return 0;
        if (N == 1 && nums[0] == val) {
            nums[0] = -1;
            return 0;
        }
        // variables
        int fast = 0;
        int slow = 0;
        // two pointers
        while (fast < N) {
            // cond step slow
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                ++slow;
            }
            // step fast
            ++fast;
        }
        // return
        return slow; // slow points to next loc therefore == size
    }
}
