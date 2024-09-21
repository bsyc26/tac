import java.util.List;
import java.util.LinkedList;
/** Return all possible perms of nums[] in any order */
public class Solution { // leetcode 46
    // field
    private List<List<Integer>> perms = new LinkedList<>();
    private List<Integer> track = new LinkedList<>();
    private boolean[] used;
    // backtrack
    public List<List<Integer>> permute(int[] nums) { // T: O(N*N!), S: O(N)
        // const
        int N = nums.length;
        // data struct
        used = new boolean[N];
        // backtrack
        backtrack(nums);
        // return
        return perms;
    }
    private void backtrack(int[] arr) {
        // const
        int N = arr.length;
        // base case
        if (track.size() == N) {
            perms.add(new LinkedList<Integer>(track)); // deep copy
            return;
        }
        // backtrack
        for (int i = 0; i < N; i++) {
            // jump used
            if (used[i])
                continue;
            // make decision
            track.add(arr[i]);
            used[i] = true;
            // next level
            backtrack(arr);
            // cancel decision
            track.remove(track.size()-1);
            used[i] = false;
        }
    }
}
