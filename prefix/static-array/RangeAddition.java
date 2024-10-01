/** Return arr after applying all the updates
  * updates[i] = [start, end, incre] */
public class Solution { // leetcode 370
    // nested class 
    private class DF {
        // field
        private int[] preDiff;
        // constructor
        public DF(int[] nums) {
            // const
            int N = nums.length;
            // data struct
            preDiff = new int[N];
            preDiff[0] = 0;
            for (int i = 1; i < N; i++)
                preDiff[i] = nums[i] - nums[i-1];
        }
        // method
        public void update(int start, int end, int val) { // [start, end]
            preDiff[start] += val;
            if (end+1 < preDiff.length)
                preDiff[end+1] -= val;
        }
        public int[] result() {
            int N = preDiff.length; // const
            int[] res = new int[N]; // res
            res[0] = preDiff[0];
            for (int i = 1; i < N; i++)
                res[i] = res[i-1] + preDiff[i];
            return res;
        }
    }
    // prefix: preDiff
    public int[] getModifiedArray(int length, int[][] updates) { // T: O(N+U), S: O(N).
        // const
        int N = length;
        // var
        int[] nums = new int[N];
        // data struct
        DF df = new DF(nums);
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];
            df.update(start, end, val);
        }
        // return
        return df.result();
    }
}
