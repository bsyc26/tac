import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
/** Return all possible subsets of nums[] (may contain dups) int any order */
public class Solution { // leetcode 90
    // field
    private List<List<Integer>> subsets = new LinkedList<>();
    private List<Integer> track = new LinkedList<>();
    // backtrack + sort
    public List<List<Integer>> subsetsWithDup(int[] nums) { // T: O(N*N!), S: O(N).
        // const
        int N = nums.length;
        // var
        int[] arr = Arrays.copyOf(nums, N);
        Arrays.sort(arr); // sort to make dup near
        // backtrack
        backtrack(arr, 0);
        // return
        return subsets;
    }
    private void backtrack(int[] arr, int start) {
        // const
        int N = arr.length;
        // base case
        subsets.add(new LinkedList<Integer>(track)); // deep copy
        // backtrack
        for (int i = start; i < N; i++) {
            // jump dup
            if (i > start && arr[i] == arr[i-1]) // dup only cnts once with init order
                continue;
            // make decision
            track.add(arr[i]);
            // next level
            backtrack(arr, 1+i);
            // cancel decision
            track.remove(track.size()-1);
        }
    }
}
