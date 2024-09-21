/** Return the max len of strictly increasing sub seq (can be non-consecutive) of nums[] */
public class Solution { // leetcode 300
    // binary-search: patience-sorting
    public int lengthOfLIS(int[] nums) {
        // const
        int N = nums.length;
        // data struct
        int[] tops = new int[N];
        int piles = 0;
        // one pointer
        for (int i = 0; i < N; i++) {
            int poker = nums[i];
            // binary search: left bound
            int lo = 0;
            int hi = piles;
            while (lo < hi) {
                // calc mid
                int mid = lo + (hi-lo)/2;
                // cond step
                if (tops[mid] < poker)
                    lo = mid+1;
                else
                    hi = mid;
            }
            if (lo == piles) // if no suitable piles
                ++piles;
            tops[lo] = poker; // place poker at tops, tops[0..piles] is always strictly increasing
        }
        // return
        return piles; // piles is the len of LIS
    }
}
