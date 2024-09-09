/** Remove the duplicates in-place and return the num of uniq elems in non-decreasing nums[]
  * relative order should be preserved, all uniq elems should in the first k (num of uniq) idx loc */
public class Solution { // leetcode 26
    // two-pointers: fast-slow
    public int removeDuplicates(int[] nums) { // T: O(N), S: O(1).
        // constants
        int N = nums.length;
        // edge case
        if (N == 0) return 0;
        // variables
        int fast = 0;
        int slow = 0;
        // two pointers
        while (fast < N) {
            // cond step slow
            if (nums[slow] != nums[fast]) {
                ++slow; // nums[0] must be preserved, maintain [0..slow] is uniq
                nums[slow] = nums[fast];
            }
            // step fast
            ++fast;
        }
        // return
        return slow+1; // 0-index convert to size
    }
}
