/** Return all triplets of elems sum up to 0 with no dup */

// leetcode 15
// two-pointers:left-right + sort
// T: O(N2)
// S: O(N)

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    // state
    private int[] nums;

    // core method
    public List<List<Integer>> threeSum(int[] nums) {
        // const
        int N = nums.length;
        // var
        nums = Arrays.copyOf(nums, N); // copy nums
        Arrays.sort(nums); // sort non-decreasing order
        // res
        List<List<Integer>> res = new LinkedList<>();
        // loop && fix val1
        for (int i = 0; i < N; i++) {
            int val1 = nums[i];
            int subTarget = 0 - val1;
            // degrade to twoSum
            List<List<Integer>> subRes = twoSumTarget(nums, i+1, subTarget);
            for (List<Integer> sub : subRes) {
                int val2 = sub.get(0);
                int val3 = sub.get(1);
                // update res
                res.add(Arrays.asList(val1, val2, val3));
            }
            // jump dup val1
            while (i < N-1 && nums[i] == nums[i+1])
                ++i;
        }
        // return res
        return res;
    }

    // support method
    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        // const
        int N = nums.length;
        // var
        int left = start;
        int right = N-1;
        // res
        List<List<Integer>> res = new LinkedList<>();
        // two pointers
        while (left < right) {
            // calc sum
            int valLf = nums[left];
            int valRt = nums[right];
            int curSum = valLf + valRt;
            // binary search
            if (curSum < target)
                ++left;
            else if (curSum > target)
                --right;
            else {
                // update res
                res.add(Arrays.asList(valLf, valRt));
                // jump dups of valLf, valRt
                while (left < right && nums[left] == valLf)
                    ++left;
                while (left < right && nums[right] == valRt)
                    --right;
            }
        }
        // return res
        return res;
    }
}
