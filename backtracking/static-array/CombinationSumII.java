import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
/** Return all uniq combs in candidates[] sum up to target
  * each elem of candidates[] only use once in a comb */
public class Solution { // leetcode 40
    // field
    private List<List<Integer>> combs = new LinkedList<>();
    private List<Integer> track = new LinkedList<>();
    private int trackSum = 0;
    // backtrack + sort
    public List<List<Integer>> combinationSum2(int[] candidates, int target) { // T: O(N*N!), S: O(N).
        // const
        int N = candidates.length;
        int TGT = target; // required sum of comb
        // var
        int[] arr = Arrays.copyOf(candidates, N);         
        Arrays.sort(arr); // sort to make dup near
        // backtrack
        backtrack(arr, 0, TGT);
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
            combs.add(new LinkedList<Integer>(track));
            return;
        }
        // backtrack
        for (int i = start; i < N; i++) {
            // jump dup
            if (i > start && arr[i] == arr[i-1]) // dup only cnts once with init order
                continue;
            // make decision
            track.add(arr[i]);
            trackSum += arr[i];
            // next level
            backtrack(arr, 1+i, TGT);
            // cancel decision
            trackSum -= arr[i];
            track.remove(track.size()-1);
        }
    }
}
