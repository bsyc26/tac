/** Return arr after applying all the updates
  * updates[i] = [start, end, incre] */

// leetcode 370
// prefix:pre-diff
// T: O(N)
// S: O(N)

public class Solution {
    // nested class 
    private class PreDiff {
        // state
        private int[] diff;
        // constructor
        public PreDiff(int[] nums) {
            int N = nums.length; // const
            diff = new int[N]; // data struct
            diff[0] = 0;
            for (int i = 1; i < N; i++)
                diff[i] = nums[i] - nums[i-1];
        }
        // update method
        public void update(int start, int end, int val) {
            preDiff[start] += val;
            if (end+1 < preDiff.length) // [start, end]
                preDiff[end+1] -= val;
        }
        // access method
        public int[] result() {
            int N = preDiff.length; // const
            int[] res = new int[N]; // res
            res[0] = preDiff[0];
            for (int i = 1; i < N; i++)
                res[i] = res[i-1] + preDiff[i];
            return res; // return res
        }
    }

    // main method
    public int[] getModifiedArray(int length, int[][] updates) {
        // const
        int N = length;
        // var
        int[] nums = new int[N];
        // DS
        PreDiff pd = new PreDiff(nums);
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];
            pd.update(start, end, val); // val update [start, end]
        }
        // return
        return pd.result();
    }
}
