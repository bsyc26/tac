/** Return the num of epns to build of nums[] with '+' and '-' that equals target */
public class Solution { // leetcode 494
    // field
    private int combs = 0;
    private int[] arr;
    private int N;
    // backtrack
    public int findTargetSumWays(int[] nums, int target) { // T: O(2N), S: O(N).
        // const
        N = nums.length;
        // var
        arr = nums;
        // backtrack
        backtrack(0, target);
        // return
        return combs;
    }
    private void backtrack(int idx, int target) {
        // base case
        if (idx == N) {
            if (target == 0) 
                ++combs;
            return;
        }
        // make decision
        target -= arr[idx];
        // next level
        backtrack(1+idx, target);
        // cancel decision
        target += arr[idx];
        // make decision
        target += arr[idx];
        // next level
        backtrack(1+idx, target);
        // cancel decision
        target -= arr[idx];
    }
}
