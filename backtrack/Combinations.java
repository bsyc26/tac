import java.util.List;
import java.util.LinkedList;
/** Return all possible comb of k nums from [1..n] in any order */
public class Solution { // leetcode 77
    // field
    private List<List<Integer>> combs = new LinkedList<>();
    private List<Integer> track = new LinkedList<>();
    // backtrack
    public List<List<Integer>> combine(int n, int k) { // T: O(C(N/K)), S: O(K).
        // const
        int N = n;
        int K = k; // num of members in comb
        // backtrack
        backtrack(N, K, 1);
        // return
        return combs;
    }
    private void backtrack(int N, int K, int start) {
        // base case
        if (track.size() == K) {
            combs.add(new LinkedList<Integer>(track)); // deep copy
            return;
        }
        // backtrack
        for (int i = start; i <= N; i++) {
            // make decision
            track.add(i);
            // next level
            backtrack(N, K, 1+i);
            // cancel decision
            track.remove(track.size()-1);
        }
    }
}
