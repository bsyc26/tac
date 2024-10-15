/** Return all possible uniq perms of nums[] (may contain dups) in any order */

// leetcode 47
// backtracking + sorting
// T: O(N*N!)
// S: O(N)

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    // states
    private List<List<Integer>> perms;
    // DS
    private LinkedList<Integer> track;
    private boolean[] used;

    // core method
    public List<List<Integer>> permuteUnique(int[] nums) {
        // const
        int N = nums.length;
        // fields
        this.perms = new LinkedList<>();
        this.track = new LinkedList<>();
        this.used = new boolean[N];
        // var + sorting
        int[] sorted = Arrays.copyOf(nums, N);
        Arrays.sort(sorted); // sort to make dup elems adj
        // backtrack
        backtrack(sorted);
        // return res
        return perms;
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
            // jump used elems
            if (this.used[i]) continue;
            // jump dup elems
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;
            // make decision
            this.track.add(arr[i]);
            this.used[i] = true;
            // next level
            backtrack(arr);
            // cancel decision
            this.used[i] = false;
            this.track.removeLast();
        }
    }
}
