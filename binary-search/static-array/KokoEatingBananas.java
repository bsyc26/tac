/** Return the min int k to eat all bananas within h hours
  * piles[i] is the num of bananas of pile, k is eating number per hour */
// leetcode: 875
// binary-search: left-bound + relation-func
// T: O(logN), S: O(1).
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // const
        int TGT = h;
        // var
        int left = 1;
        int right = 1_000_000_000 + 1; // h: [1..1_000_000_000+1)
        // binary search
        while (left < right) {
            int mid = left + (right-left)/2;
            if (f(piles, mid) < TGT)
                right = mid;
            else if (f(piles, mid) > TGT)
                left = mid+1;
            else // f(piles, mid) == TGT
                right = mid; // find left bound
        }
        // return
        return left;
    }
    private long f(int[] piles, int x) { // f(x) ~ -x
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i]/x;
            if (piles[i]%x > 0)
                ++hours;
        }
        return hours;
    }
}
