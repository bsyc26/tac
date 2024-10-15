/** Return all possible comb of k nums from [1..n] in any order */

// leetcode 77
// backtracking
// T: O(K*N!/K!(N-K)!) // k * (n choose k)
// S: O(K)

import java.util.List;
import java.util.LinkedList;

public class Solution {
    // states
    private List<List<Integer>> combs;
    // DS
    private LinkedList<Integer> track;

    // core method
    public List<List<Integer>> combine(int n, int k) {
        // fields
        this.combs = new LinkedList<>();
        this.track = new LinkedList<>();
        // backtracking
        backtrack(n, k, 1); // [1..n] gen all combs of k nums
        // return
        return this.combs;
    }

    // support method
    private void backtrack(int num, int k, int start) {
        // base case
        if (track.size() == k) {
            this.combs.add(new LinkedList<Integer>(this.track)); // constructor for deep copy
            return;
        }
        // backtracking
        for (int i = start; i <= num; i++) {
            // make decision
            this.track.add(i);
            // next level
            backtrack(num, k, 1+i);
            // cancel decision
            this.track.remove();
        }
    }
}
