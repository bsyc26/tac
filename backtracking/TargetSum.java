/** Return the num of epns to build of nums[] with '+' and '-' that equals target */

// leetcode 494
// backtracking
// T: O(2^N)
// S: O(N)

public class Solution {
    // state
    private int combs;

    // core method
    public int findTargetSumWays(int[] nums, int target) {
        // const
        target = target;
        int[] arr = nums;
        // field
        this.combs = 0;
        // backtracking
        backtrack(arr, 0, target); // to find target start from arr[0]
        // return res
        return this.combs;
    }

    // support method
    private void backtrack(int[] arr, int start, int target) {
        // const
        int N = arr.length;
        // base case
        if (start == N) {
            if (target == 0) // update state
                ++combs;
            return;
        }
        // make decision
        target -= arr[start]; // conn with '-'
        // next level
        backtrack(arr, start+1, target);
        // cancel decision
        target += arr[start];
        // make decision
        target += arr[start]; // conn with '+'
        // next level
        backtrack(arr, start+1, target);
        // cancel decision
        target -= arr[start];
    }
}
