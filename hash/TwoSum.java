/** Return idxs of two elems whose sum equals to target in any order, one sol, no re-use of elem */

// leetcode 1
// hash
// T: O(N)
// S: O(N)

import java.util.HashMap;

public class Solution {
    // state
    private HashMap<Integer, Integer> valToIdx; // val: idx of nums[]

    // core method
    public int[] twoSum(int[] nums, int target) {
        // consts
        int N = nums.length;
        target = target;
        // field
        this.valToIdx = new HashMap<>();
        for (int curIdx = 0; curIdx < N; curIdx++) { // one pass hash
            int curVal = nums[i];
            int needVal = target - curVal;
            // look up hash-map
            if (this.valToIdx.containsKey(needVal)) { // find paired val
                int needIdx = this.valToIdx.get(needVal);
                return new int[]{ curIdx, needIdx };
            }
            // update valToIdx
            this.valToIdx.put(curVal, i);
        }
        // return fallback
        return new int[]{ -1, -1 };
    }
}
