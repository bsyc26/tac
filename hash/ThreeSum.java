import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
/** Return all triplets of elems with diff idx sum to 0 with no-sort */
// leetcode 15
// hash + encode-string
// T: O(N2), S: O(N).
public class Solution {
    // states
    private HashMap<Integer, Integer> valIdx; // val: idx
    private HashSet<String> dup; // "val1val2val3" in non-decreasing order
    // main method
    public List<List<Integer>> threeSum(int[] nums) {
        // const
        int N = nums.length;
        // data struct
        valIdx = new HashMap<>();
        for (int i = 0; i < N; i++)
            valIdx.put(nums[i], i);
        dup = new HashSet<>();
        // res
        List<List<Integer>> triplets = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int val1 = nums[i];
            for (int j = i+1; j < N; j++) {
                int val2 = nums[j];
                int needVal = 0 - val1 - val2;
                if (valIdx.containsKey(needVal)) {
                    int needIdx = valIdx.get(needVal);
                    // jump re-use of val1 or val2
                    if (needIdx == i || needIdx == j) continue;
                    // encode triplet into string
                    int[] triplet = new int[]{ val1, val2, needVal };
                    Arrays.sort(triplet);
                    StringBuilder sb = new StringBuilder();
                    for (int val : triplet)
                        sb.append(val);
                    // jump dup
                    if (dup.contains(sb.toString())) continue;
                    // update res
                    triplets.add(Arrays.asList(val1, val2, needVal));
                    // update dup
                    dup.add(sb.toString());
                }
            }
        }
        // return res
        return triplets;
    }
}
