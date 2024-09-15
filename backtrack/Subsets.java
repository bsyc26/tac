import java.util.List;
import java.util.LinkedList;
/** Return all possible subsets of nums[] (all elems uniq) */
public class Solution { // leetcode 78
    // field
    List<List<Integer>> subsets = new LinkedList<>();
    List<Integer> track = new LinkedList<>();
    // backtrack
    public List<List<Integer>> subsets(int[] nums) { // T: O(N*2N), S: O(N).
        // const 
        int N = nums.length;
        // backtrack
        backtrack(nums, 0);
        // return
        return subsets;
    }
    private void backtrack(int[] arr, int start) {
        // const
        int N = arr.length;
        // pre-order
        subsets.add(new LinkedList<Integer>(track)); // deep copy
        // backtrack
        for (int i = start; i < N; i++) {
            // make decision
            track.add(arr[i]);
            // next level
            backtrack(arr, 1+i);
            // cancel decision
            track.remove(track.size()-1);
        }
    }
}
