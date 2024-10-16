/** Return the max len of strictly increasing sub seq (can be non-consecutive) of nums[] */

// leetcode 300
// binary-search:patience-sorting
// T: O(NlogN)
// S: O(N).

public class Solution {
    public int lengthOfLIS(int[] nums) { // choose elem and place it into tops[]
        // consts
        int[] arr = nums;
        int N = arr.length;
        // DS
        int[] tops = new int[N];
        // res
        int piles = 0;
        // patience-sorting
        for (int i = 0; i < N; i++) {
            int poker = arr[i];
            int lo = 0;
            int hi = piles-1; // [lo, hi]
            // binary-search:low-bound
            while (lo <= hi) {
                // calc mid && get tops[mid]
                int mid = lo + (hi-lo)/2;
                int cur = tops[mid]; // given taregt to search its index in arr[]
                // step next
                if (cur < poker)
                    lo = mid+1;
                else if (cur > poker)
                    hi = mid-1;
                else
                    hi = mid-1;
            }
            // create new pile if no suitable one
            if (lo == piles)
                ++piles;
            // place poker at tops[]
            tops[lo] = poker; // tops[0..piles] is always strictly increasing
        }
        // return res
        return piles; // num of piles is the len of LIS
    }
}
