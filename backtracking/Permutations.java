/** Return all possible perms of nums[] in any order */

// leetcode 46
// backtracking
// T: O(N*N!)
// S: O(N)

import java.util.List;
import java.util.LinkedList;

public class Solution {
    // states
    private List<List<Integer>> perms;
    // DS
    private LinkedList<Integer> track;
    private boolean[] used;

    // core method
    public List<List<Integer>> permute(int[] nums) {
        // consts
        int N = nums.length;
        int[] arr = nums;
        // fields
        this.perms = new LinkedList<>();
        this.track = new LinkedList<>();
        this.used = new boolean[N];
        // backtracking
        backtrack(arr);
        // return res
        return this.perms;
    }

    // support method
    private void backtrack(int[] arr) {
        // const
        int N = arr.length;
        // base case
        if (this.track.size() == N) {
            this.perms.add(new LinkedList<Integer>(this.track)); // constructor for deep copy
            return;
        }
        // backtracking
        for (int i = 0; i < N; i++) {
            // jump used
            if (this.used[i]) continue;
            // make decision
            this.track.add(arr[i]);
            this.used[i] = true;
            // next level
            backtrack(arr);
            // cancel decision
            this.track.removeLast();
            this.used[i] = false;
        }
    }
}
