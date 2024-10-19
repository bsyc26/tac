/** Return an arr of all uniq four tuple sum up to target */

// leetcode 18
// two-pointers:left-right
// T: O(N^3)
// S: O(N)

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    // state
    private int[] nums;

    // core method
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // const
        int N = nums.length;
        // var
        nums = Arrays.copyOf(nums, N);
        Arrays.sort(nums);
        // field
        this.nums = nums;
        // return res
        return nSumTarget(4, 0, target); // k == 4, start == 0
    }

    // support methods
    private List<List<Integer>> nSumTarget(int k, int start, long target) {
        // const
        int N = nums.length;
        // res
        List<List<Integer>> res = new ArrayList<>();
        // edge case
        if (k < 2 || k > N) return res; // at least two sum
        // exec twoSumTarget or degrade to k-1
        if (k == 2) { // exec twoSum
            return twoSumTarget(start, target);
        } else {
            for (int i = start; i < N; i++) {
                // recur
                List<List<Integer>> subRes = nSumTarget(k-1, i+1, target-nums[i]);
                // update states
                for (List<Integer> sub: subRes) {
                    sub.add(nums[i]); // append cur elem into sub res
                    res.add(sub);
                }
                // jump dub
                while (i < N-1 && nums[i] == nums[i+1])
                    ++i;
            }
        }
        // return res
        return res;
    }
    private List<List<Integer>> twoSumTarget(int start, long target) {
        // const
        int N = nums.length;
        // var
        int left = start;
        int right = N-1;
        // res
        List<List<Integer>> res = new LinkedList<>();
        // two-pointers:left-right
        while (left < right) { // no re-use of elem
            // calc cur
            int valLf = nums[left];
            int valRt = nums[right];
            int curSum = valLf + valRt;
            // step next
            if (curSum > target)
                --right;
            else if (curSum < target)
                ++left;
            else { // find sum == target
                // update res
                res.add(new LinkedList<>(Arrays.asList(valLf, valRt))); 
                // jump dup
                while (left < right && nums[left] == valLf)
                    ++left;
                while (left < right && nums[right] == valRt)
                    --right;
            }
        }
        // return
        return res;
    }
}
