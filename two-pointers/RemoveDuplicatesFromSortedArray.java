/** Remove the duplicates in-place and return the num of uniq elems in non-decreasing nums[]
  * relative order should be preserved, all uniq elems should in the first k (num of uniq) idx loc */
// leetcode 26
// two-pointers: fast-slow
// T: O(N), S: O(1).
public class Solution {
    public int removeDuplicates(int[] nums) {
        // const
        int N = nums.length;
        // edge case
        if (N == 0) return 0;
        // var
        int fast = 0;
        int slow = 0;
        // two pointers: fast-slow
        while (fast < N) {
            // step slow
            if (nums[slow] != nums[fast]) {
                ++slow; // nums[0] is preserved
                nums[slow] = nums[fast];
            }
            // step fast
            ++fast;
        }
        // return size of [0, slow]
        return slow+1;
    }
}
