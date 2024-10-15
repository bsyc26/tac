/** Return all possible subsets of nums[] (all elems uniq) */

// leetcode 78
// backtracking
// T: O(N*N!)
// S: O(N)

import java.util.List;
import java.util.LinkedList;

public class Solution {
    // states
    private List<List<Integer>> subsets;
    // DS
    private LinkedList<Integer> track;

    // core method
    public List<List<Integer>> subsets(int[] nums) {
        // consts
        int N = nums.length;
        int[] arr = nums;
        // fields
        this.subsets = new LinkedList<>(); 
        this.track = new LinkedList<>();
        // backtracking
        backtrack(arr, 0); // start from arr[0]
        // return res
        return this.subsets;
    }

    // support method
    private void backtrack(int[] arr, int start) {
        // const
        int N = arr.length;
        // update states
        this.subsets.add(new LinkedList<Integer>(this.track)); // constructor for deep copy
        // backtracking
        for (int i = start; i < N; i++) {
            // make decision
            this.track.add(arr[i]);
            // next level
            backtrack(arr, i+1);
            // cancel decision
            this.track.removeLast();
        }
    }
}
