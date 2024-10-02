/** Return true if capacity not exceed during trips
  * trips[i] = [numPassengers, from, to] */
// T: O(N), S: O(N).
public class Solution { // leetcode 1094
    // nested class
    public class PreDiff {
        // field
        private int[] diff;
        // constructor
        public PreDiff(int[] nums) {
            int N = nums.length; // const
            diff = new int[N]; // data struct
            diff[0] = nums[0];
            for (int i = 1; i < N; i++)
                diff[i] = diff[i-1] - nums[i];
        }
        // method
        public void update(int start, int end, int val) {
            diff[start] += val;
            if (end+1 < diff.length)
                diff[end+1] -= val;
        }
        public int[] result() {
            int N = diff.length; // const
            int[] res = new int[N]; // res
            res[0] = diff[0];
            for (int i = 1; i < N; i++)
                res[i] = res[i-1] + diff[i];
            return res;
        }
    }
    // prefix: pre-diff
    public boolean carPooling(int[][] trips, int capacity) {
        // const
        int N = 1001; // from, to range within [0, 1000]
        //var
        int[] nums = new int[N];
        // data struct
        PreDiff pd = new PreDiff(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            int start = trip[1];
            int end = trip[2]-1; // val update [start, end)
            pd.update(start, end, val);
        }
        // res
        int[] res = pd.result();
        for (int i = 0; i < N; i++)
            if (res[i] > capacity)
                return false;
        // return fallback
        return true;
    }
}
