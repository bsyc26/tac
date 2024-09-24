import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
/** Return all triplets of elems with diff idx sum to 0
  * no-sort */
public class Solution { // leetcode 15
    // hash-table: hash-map + hash-set
    public List<List<Integer>> threeSum(int[] nums) { // T: O(N2), S: O(N).
        // const
        int N = nums.length;
        // data struct
        HashMap<Integer, Integer> valToIdx = new HashMap<>(); // val: idx of nums[]
        for (int i = 0; i < N; i++)
            valToIdx.put(nums[i], i);
        HashSet<String> dup = new HashSet<>(); // "val1val2val3" in non-decreasing order
        // res
        List<List<Integer>> triplets = new LinkedList<>();
        // iter
        for (int i = 0; i < N; i++) {
            int val1 = nums[i];
            for (int j = i+1; j < N; j++) {
                int val2 = nums[j];
                int needVal = 0 - val1 - val2;
                if (valToIdx.containsKey(needVal)) {
                    int needIdx = valToIdx.get(needVal);
                    // jump re-use
                    if (needIdx == i || needIdx == j) continue;
                    // make "val1val2val3"
                    int[] triplet = new int[]{ val1, val2, needVal };
                    Arrays.sort(triplet);
                    StringBuilder builder = new StringBuilder();
                    for (int val : triplet)
                        builder.append(val);
                    // jump dup
                    if (dup.contains(builder.toString())) continue;
                    // update res
                    triplets.add(Arrays.asList(val1, val2, needVal));
                    // update dup
                    dup.add(builder.toString());
                }
            }
        }
        // return res
        return triplets;
    }
}
