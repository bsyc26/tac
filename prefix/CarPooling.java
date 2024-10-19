/** Return true if capacity not exceed during trips
  * trips[i] = [numPassengers, from, to] */

// leetcode 1094
// prefix:pre-diff
// T: O(N)
// S: O(N)

public class Solution {
    // nested class
    public class PreDiff {
        // state
        private int[] diff; // diff[i] = nums[i-1] - nums[i]
        // constructor
        public PreDiff(int[] nums) {
            int N = nums.length; // const
            this.diff = new int[N]; // data struct
            this.diff[0] = nums[0];
            for (int i = 1; i < N; i++)
                this.diff[i] = this.diff[i-1] - nums[i];
        }
        // update method
        public void update(int start, int end, int val) {
            diff[start] += val;
            if (end+1 < diff.length) // [start, end]
                diff[end+1] -= val;
        }
        // access method
        public int[] result() {
            int N = diff.length;
            int[] res = new int[N];
            res[0] = diff[0];
            for (int i = 1; i < N; i++)
                res[i] = res[i-1] + diff[i];
            return res;
        }
    }

    // core method
    public boolean carPooling(int[][] trips, int capacity) {
        // const
        int N = 1001; // from, to range within [0, 1000]
        //var
        int[] nums = new int[N];
        // DS
        PreDiff pd = new PreDiff(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            int start = trip[1];
            int end = trip[2]-1; // val updates [start, end)
            pd.update(start, end, val);
        }
        // res
        int[] res = pd.result();
        for (int i = 0; i < N; i++)
            if (res[i] > capacity)
                return false;
        // return true if pass all case
        return true;
    }
}
