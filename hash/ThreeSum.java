/** Return all triplets of elems with diff idx sum to 0 with no-sort */

// leetcode 15
// hash + encode-string
// T: O(N^2)
// S: O(N)

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {
    // states
    private HashMap<Integer, Integer> valToIdx; // val: idx of nums[]
    private HashSet<String> dups; // stores "val1val2val3" in non-decreasing order

    // core method
    public List<List<Integer>> threeSum(int[] nums) {
        // consts
        int[] arr = nums;
        int N = arr.length;
        // fields
        this.valToIdx = new HashMap<>();
        for (int i = 0; i < N; i++)
            this.valToIdx.put(arr[i], i);
        this.dups = new HashSet<>();
        // res
        List<List<Integer>> triplets = new LinkedList<>();
        for (int idx1 = 0; idx1 < N; idx1++) {
            int val1 = arr[idx1];
            for (int idx2 = idx1+1; idx2 < N; idx2++) {
                int val2 = arr[idx2];
                int needVal = 0 - val1 - val2;
                // look up hash-map
                if (this.valToIdx.containsKey(needVal)) {
                    int needIdx = this.valToIdx.get(needVal);
                    // jump re-use of val1 or val2
                    if (needIdx == idx1 || needIdx == idx2) continue;
                    // encode triplet into string
                    int[] triplet = new int[]{ val1, val2, needVal };
                    Arrays.sort(triplet);
                    StringBuilder sb = new StringBuilder();
                    for (int val : triplet)
                        sb.append(val);
                    // jump dup
                    if (this.dups.contains(sb.toString())) continue;
                    // update res
                    triplets.add(Arrays.asList(val1, val2, needVal));
                    // update dup
                    this.dups.add(sb.toString());
                }
            }
        }
        // return res
        return triplets;
    }
}
