/** Return the max len of strictly increasing sub seq (can be non-consecutive) of nums[] */
// leetcode 300
// binary-search: patience-sorting
// T: O(NlogN), S: O(N).
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // const
        int N = nums.length;
        // data struct
        int[] tops = new int[N];
        int piles = 0;
        // patience-sorting
        for (int i = 0; i < N; i++) {
            int poker = nums[i];
            int left = 0;
            int right = piles-1; // [left, right]
            // binary search left bound
            while (left <= right) {
                // calc mid
                int mid = left + (right-left)/2;
                // step next
                if (tops[mid] < poker)
                    left = mid+1;
                else
                    right = mid-1;
            }
            if (left == piles) // if no suitable piles
                ++piles; // create new piles to place
            tops[left] = poker; // place poker at tops, tops[0..piles] is always strictly increasing
        }
        // return
        return piles; // piles is the len of LIS
    }
}
