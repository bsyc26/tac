/** Return answer[n] where answer[i] is the tot num of seats reserved for flight i
  * bookings[i] = [first, last, seats], seats will be reserved for [first, last] */
// leetcode 1109
// prefix: pre-diff
// T: O(N), S: O(N).
public class Solution {
    // nested class
    private class PreDiff {
        // state
        private int[] diff;
        // constructor
        public PreDiff(int[] nums) {
            int N = nums.length;
            diff = new int[N];
            diff[0] = nums[0];
            for (int i = 1; i < N; i++)
                diff[i] = nums[i] - nums[i-1];
        }
        // methods
        public void update(int start, int end, int val) {
            diff[start] += val;
            if (end+1 < diff.length) // [start, end]
                diff[end+1] -= val;
        }
        public int[] result() {
            int N = diff.length;
            int[] res = new int[N];
            res[0] = diff[0];
            for (int i = 1; i < N; i++)
                res[i] = res[i-1] + diff[i];
            return res;
        }
    }
    // main method
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // const
        int N = n;
        // var
        int[] nums = new int[n];
        // data struct
        PreDiff pd = new PreDiff(nums);
        for (int[] booking : bookings) { // 1-index
            int start = booking[0]-1;
            int end = booking[1]-1;
            int val = booking[2];
            pd.update(start, end, val);
        }
        // return
        return pd.result();
    }
}
