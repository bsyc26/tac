/** Implement the NumArray class
  * NumArray(int[] nums) inits the obj with nums[]
  * int sumRange(int left, int right) returns the sum of elems of nums[left, right] */
// leetcode 303
// prefix: pre-sum
// T: O(N), S: O(N).
public class NumArray {
    // state
    private int[] preSum; // preSum[i] is the sum of nums[0..i-1]
    // constructors
    public NumArray(int[] nums) {
        // const
        int N = nums.length;
        // data struct
        preSum = new int[N+1];
        preSum[0] = 0;
        for (int i = 1; i <= N; i++)
            preSum[i] = preSum[i-1] + nums[i-1];
    }
    // method
    public int sumRange(int left, int right) { // T: O(1)
        return preSum[right+1] - preSum[left];
    }
}
