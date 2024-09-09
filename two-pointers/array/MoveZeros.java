/** Move in-place all 0's to the end of arr while keep the relative order of non-zero elems */
public class Solution { // leetcode 283
    // two-pointers: fast-slow
    public void moveZeroes(int[] nums) { // T: O(N), S: O(1).
        // constants
        int N = nums.length;
        // variables
        int fast = 0;
        int slow = 0;
        // two pointers
        while (fast < N) {
            // cond step slow
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
