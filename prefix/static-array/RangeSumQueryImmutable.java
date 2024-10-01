/** Implement the NumArray class
  * NumArray(int[] nums) inits the obj with nums[]
  * int sumRange(int left, int right) returns the sum of elems of nums[left, right] */
// prefix: presum
public class NumArray { // leetcode 303
    // field
    private int[] preSum;
    // constructors
    public NumArray(int[] nums) { // T: O(N), S: O(N).
        // const
        int N = nums.length;
        // data struct
        preSum = new int[N+1]; // preSum[i] is sum of nums[0..i-1] / nums[0..i)
        preSum[0] = 0;
        for (int i = 1; i <= N; i++)
            preSum[i] = preSum[i-1] + nums[i-1];
    }
    public int sumRange(int left, int right) { // T: O(1).
        return preSum[right+1]-preSum[left]; // sum of nums[0..right+1) - nums[0..left)
    }
}
