/** Return the min int k to eat all bananas within h hours
  * piles[i] is the num of bananas of pile, k is eating number per hour */
// leetcode: 875
// binary-search: left-bound + map-func
// T: O(logN), S: O(1).
public class Solution {
    // state
    private int[] piles;
    // main method
    public int minEatingSpeed(int[] piles, int h) {
        // const
        int TARGET = h;
        this.piles = piles;
        // var
        int left = 1;
        int right = 1_000_000_000; // h: [1..1_000_000_000]
        // binary search
        while (left <= right) {
            // calc mid
            int mid = left + (right-left)/2;
            long cur = f(mid);
            // step next
            if (cur < TARGET)
                right = mid-1;
            else if (cur > TARGET)
                left = mid+1;
            else
                right = mid-1;
        }
        // return left-bound
        return left;
    }
    // support method
    private long f(int x) { // f(x) ~ -x
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i]/x;
            if (piles[i]%x > 0)
                ++hours;
        }
        return hours;
    }
}
