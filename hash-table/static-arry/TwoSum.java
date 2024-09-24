import java.util.HashMap;
/** Return idxs of two elems sum to target in any order
  * only one sol, same elem cannot be use twice */
public class Solution { // leetcode 1
    // hash-table: hash-map
    public int[] twoSum(int[] nums, int target) { // T: O(N), S: O(N)
        // const
        int N = nums.length;
        int TGT = target;
        // data struct
        HashMap<Integer, Integer> valToIdx = new HashMap<>(); // val: idx
        // iter
        for (int i = 0; i < N; i++) {
            // seek need val and idx
            int curVal = nums[i];
            int needVal = TGT - curVal;
            if (valToIdx.containsKey(needVal)) {
                int needIdx = valToIdx.get(needVal);
                return new int[]{ i, needIdx };
            }
            // update map
            valToIdx.put(curVal, i);
        }
        // return fallback
        return new int[]{ -1, -1 };
    }
}
