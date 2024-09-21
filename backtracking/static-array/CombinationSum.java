import java.util.List;
import java.util.LinkedList;
/** Return combs from candidates[] sum up to target
  * each elem of candidates[] can be unlimited time
  * all elem of candidates[] is uniq */
public class Solution { // leetcode 39
    // field
    private List<List<Integer>> combs = new LinkedList<>();
    private List<Integer> track = new LinkedList<>();
    private int trackSum = 0;
    // backtrack
    public List<List<Integer>> combinationSum(int[] candidates, int target) { // T: O(N*N!), S: O(N).
        // const
        int TGT = target; // required sum of comb
        // backtrack
        backtrack(candidates, 0, TGT);
        // return
        return combs;
    }
    private void backtrack(int[] arr, int start, int TGT) {
        // const
        int N = arr.length;
        // base case
        if (trackSum > TGT)
            return;
        if (trackSum == TGT) {
            combs.add(new LinkedList<Integer>(track)); // deep copy
            return;
        }
        // backtrack
        for (int i = start; i < N; i++) {
            // make decision
            track.add(arr[i]);
            trackSum += arr[i];
            // next level
            backtrack(arr, i, TGT); // arr[start] can be dup
            // cancel decision
            trackSum -= arr[i];
            track.remove(track.size()-1);
        }
    }
}
