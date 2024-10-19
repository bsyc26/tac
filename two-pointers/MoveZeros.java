/** Move in-place all 0's to the end of arr while keep the relative order of non-zero elems */

// leetcode 283
// two-pointers:fast-slow
// T: O(N)
// S: O(1)

public class Solution {
    // core method
    public void moveZeroes(int[] nums) {
        // const
        int N = nums.length;
        // var
        int fast = 0;
        int slow = 0;
        // two pointers: fast-slow
        while (fast < N) {
            // step slow
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                ++slow;
            }
            // step fast;
            ++fast;
        }
        // fill-in 0's in remaining locs
        while (slow < N) {
            nums[slow] = 0;
            ++slow;
        }
    }
}
