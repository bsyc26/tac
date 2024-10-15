/** Return all possible subsets of nums[] (may contain dups) int any order */

// leetcode 90
// backtracking + sorting
// T: O(N*N!)
// S: O(N)

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    // states
    private List<List<Integer>> subsets;
    // DS
    private LinkedList<Integer> track;

    // core method
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // consts
        int N = nums.length;
        int[] arr = nums;
        // fields
        this.subsets = new LinkedList<>();
        this.track = new LinkedList<>();
        // var + sort
        int[] sorted = Arrays.copyOf(arr, N);
        Arrays.sort(sorted); // sort to make dup near
        // backtracking
        backtrack(sorted, 0); // start from sorted[0]
        // return
        return this.subsets;
    }

    // support method
    private void backtrack(int[] arr, int start) {
        // const
        int N = arr.length;
        // base case
        this.subsets.add(new LinkedList<Integer>(this.track)); // constructor for deep copy
        // backtracking
        for (int i = start; i < N; i++) {
            // jump dup elems
            if (i > start && arr[i] == arr[i-1]) continue;
            // make decision
            this.track.add(arr[i]);
            // next level
            backtrack(arr, i+1);
            // cancel decision
            this.track.removeLast();
        }
    }
}
