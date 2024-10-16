/** Return the n-th ugly number
  * ugly number: divisble by a, b or c */

// leetcode 1201
// binary-serach:low-bound + gcd + map-func
// T: O(logN)
// S: O(1)

public class Solution {
    // core method
    public int nthUglyNumber(int n, int a, int b, int c) {
        // const
        int target = n;
        // var
        int lo = 1;
        int hi = (int)2e9; // [lo..hi]
        // binary-search:low-bound
        while (lo <= hi) {
            // calc mid && get cur
            int mid = lo + (hi-lo)/2;
            long cur = getFactors(mid, a, b, c);
            // step left or right
            if (cur < target)
                lo = mid+1;
            else if (cur > target)
                hi = mid-1;
            else
                hi = mid-1;
        }
        // return low-bound
        return lo;
    }

    // support methods
    private long getFactors(int num, int a, int b, int c) { // get num div by a/b/c of [1..num]
        long divA = num / a;
        long divB = num / b;
        long divC = num / c;
        long divAB = num / lcm(a, b);
        long divBC = num / lcm(b, c);
        long divAC = num / lcm(a, c);
        long divABC = num / lcm(lcm(a, b), c);
        return divA + divB + divC - divAB - divBC - divAC + divABC;
    }
    private long lcm(long x, long y) { // least common multiple
        return x * y / gcd(x, y);
    }
    private long gcd(long x, long y) { // greatest common divisor
        if (x < y)
            return gcd(y, x); 
        if (y == 0)
            return x;
        return gcd(y, x%y);
    }
}
