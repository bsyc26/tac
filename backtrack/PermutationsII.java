import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
/** Return all possible uniq perms of nums[] (may contain dups) in any order */
public class Solution { // leetcode 47
    // field
    private List<List<Integer>> perms = new LinkedList<>();
    private List<Integer> track = new LinkedList<>();
    private boolean[] used;
    // backtrack + sort
    public List<List<Integer>> permuteUnique(int[] nums) { // T: O(N*N!), S: O(N).
        // const
        int N = nums.length;
        // var
        int[] arr = Arrays.copyOf(nums, N);
        Arrays.sort(arr); // sort to make dup near
        // data struct
        used = new boolean[N];
        // backtrack
        backtrack(arr);
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
            // jump dup
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]) // dup only cnts if former one is used
                continue;
            // make decision
            track.add(arr[i]);
            used[i] = true;
            // next level
            backtrack(arr);
            // cancel decision
            used[i] = false;
            track.remove(track.size()-1);
        }
    }
}
