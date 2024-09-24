import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/** Return all triplets of elems sum up to 0 with no dup */
public class Solution { // leetcode 15
    // two-pointers: left-right
    public List<List<Integer>> threeSum(int[] nums) { // T: O(N2), S: O(N).
        // const
        int N = nums.length;
        // var
        nums = Arrays.copyOf(nums, N);
        Arrays.sort(nums); // non-decreasing order
        // res
        List<List<Integer>> triplets = new ArrayList<>();
        // iter val1
        for (int i = 0; i < N; i++) {
            int val1 = nums[i];
            int target = 0 - val1;
            // degrade to twoSum
            List<List<Integer>> pairs = twoSumTarget(nums, i+1, target);
            for (List<Integer> pair : pairs) {
                int val2 = pair.get(0);
                int val3 = pair.get(1);
                // update res
                triplets.add(Arrays.asList(val1, val2, val3));
            }
            // jump dup val1
            while (i < N-1 && nums[i] == nums[i+1])
                ++i;
        }
        // return res
        return triplets;
    }
    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        // const
        int N = nums.length;
        // var
        int left = start;
        int right = N-1;
        // res
        List<List<Integer>> pairs = new ArrayList<>();
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
            else {
                // update res
                pairs.add(Arrays.asList(valLeft, valRight));
                // jump dup
                while (left < right && nums[left] == valLeft)
                    ++left;
                while (left < right && nums[right] == valRight)
                    --right;
            }
        }
        // return
        return pairs;
    }
}
