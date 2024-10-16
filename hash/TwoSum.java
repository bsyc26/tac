/** Return idxs of two elems whose sum equals to target in any order, one sol, no re-use of elem */

// leetcode 1
// hash
// T: O(N), S: O(N).

import java.util.HashMap;

public class Solution {
    // state
    private HashMap<Integer, Integer> valToIdx; // val: idx

    // core method
    public int[] twoSum(int[] nums, int target) {
        // const
        int N = nums.length;
        int target = target;
        // data struct
        valIdx = new HashMap<>();
        for (int i = 0; i < N; i++) { // one pass hash
            int curVal = nums[i];
            int needVal = target - curVal;
            if (valIdx.containsKey(needVal)) { // find paired val
                int needIdx = valIdx.get(needVal);
                return new int[]{ i, needIdx };
            }
            // update valIdx
            valIdx.put(curVal, i);
        }
        // return fallback
        return new int[]{ -1, -1 };
    }
}
