/** Return combs from candidates[] sum up to target
  * each elem of candidates[] can be unlimited time
  * all elem of candidates[] is uniq */

// leetcode 39
// backtracking
// T: O(N*N!)
// S: O(N)

import java.util.List;
import java.util.LinkedList;

public class Solution {
    // states
    private List<List<Integer>> combs;
    // DS
    private LinkedList<Integer> track;
    private int trackSum;

    // core method
    public List<List<Integer>> combinationSum(int[] candidates, int target) { // T: O(N*N!), S: O(N).
        // fields
        this.combs = new LinkedList<>();
        this.track = new LinkedList<>();
        this.trackSum = 0;
        // backtracking
        backtrack(candidates, 0, target);
        // return
        return combs;
    }

    // support method
    private void backtrack(int[] arr, int start, int target) {
        // const
        int N = arr.length;
        // base case
        if (this.trackSum > target)
            return;
        if (this.trackSum == target) {
            this.combs.add(new LinkedList<Integer>(this.track)); // constructor for deep copy
            return;
        }
        // backtracking
        for (int i = start; i < N; i++) {
            // make decision
            this.track.add(arr[i]);
            this.trackSum += arr[i];
            // next level
            backtrack(arr, i, target); // arr[start] can be dup
            // cancel decision
            this.trackSum -= arr[i];
            this.track.removeLast();
        }
    }
}
