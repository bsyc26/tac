/** Return all uniq combs in candidates[] sum up to target
  * each elem of candidates[] only use once in a comb */

// leetcode 40
// backtracking + sorting
// T: O(N*N!)
// S: O(N)

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    // states
    private List<List<Integer>> combs;
    // DS
    private LinkedList<Integer> track;
    private int trackSum;
    
    // core method
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // const
        int N = candidates.length;
        int[] arr = candidates;
        target = target;
        // fields
        this.combs = new LinkedList<>();
        this.track = new LinkedList<>();
        this.trackSum = 0;
        // var + sorting
        int[] sorted = Arrays.copyOf(arr, N);         
        Arrays.sort(sorted); // sort to make dup near
        // backtracking
        backtrack(sorted, 0, target);
        // return
        return combs;
    }

    // support method
    private void backtrack(int[] arr, int start, int target) {
        // const
        int N = arr.length;
        arr = arr;
        target = target;
        // base case
        if (this.trackSum > target)
            return;
        if (this.trackSum == target) {
            this.combs.add(new LinkedList<Integer>(this.track)); // constructor for deep copy
            return;
        }
        // backtracking
        for (int i = start; i < N; i++) {
            // jump dup
            if (i > start && arr[i] == arr[i-1]) // jump elems with dup vals
                continue;
            // make decision
            this.track.add(arr[i]);
            this.trackSum += arr[i];
            // next level
            backtrack(arr, 1+i, target);
            // cancel decision
            this.trackSum -= arr[i];
            this.track.remove();
        }
    }
}
