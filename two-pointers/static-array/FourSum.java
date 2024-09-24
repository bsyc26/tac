import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/** Return an arr of all uniq four tuple sum up to target */
public class Solution { // leetcode 18
    // two-pointers: left-right
    public List<List<Integer>> fourSum(int[] nums, int target) { // T: O(N3), S: O(N).
        // const
        int N = nums.length;
        // var
        nums = Arrays.copyOf(nums, N);
        Arrays.sort(nums);
        // return res
        return nSumTarget(nums, 4, 0, target);
    }
    private List<List<Integer>> nSumTarget(int[] nums, int K, int start, long target) {
        // const
        int N = nums.length;
        // res
        List<List<Integer>> res = new ArrayList<>();
        // edge case
        if (K < 2 || N < K) return res; // at least two sum
        // cond: degrade or exec twoSum
        if (K == 2) { // exec twoSum
            int left = start;
            int right = N-1;
            // two pointers
            while (left < right) {
                int valLeft = nums[left];
                int valRight = nums[right];
                int sum = valLeft + valRight;
                // binary search
                if (sum < target)
                    ++left;
                else if (sum > target)
                    --right;
                else { // sum == target
                    // update res
                    res.add(new ArrayList<>(Arrays.asList(valLeft, valRight)));
                    // jump dup
                    while (left < right && nums[left] == valLeft)
                        ++left;
                    while (left < right && nums[right] == valRight)
                        --right;
                }
            }
        } else { // K > 2, degrade to (K-1)Sum
            for (int i = start; i < N; i++) {
                List<List<Integer>> subRes = nSumTarget(nums, K-1, i+1, target-nums[i]);
                for (List<Integer> arr: subRes) {
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < N-1 && nums[i] == nums[i+1])
                    ++i;
            }
        }
        // return res
        return res;
    }
}
