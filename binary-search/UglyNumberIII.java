/** Return the n-th ugly number
  * ugly number: divisble by a, b or c */
// leetcode 1201
// binary serach: left bound + gcd
// T: O(logN), S: O(1).
public class Solution {
    // main method
    public int nthUglyNumber(int n, int a, int b, int c) {
        // const
        int N = n;
        // var
        int left = 1;
        int right = (int)2e9;
        // binary search
        while (left <= right) { // [1..2e9]
            // calc mid
            int mid = left + (right-left)/2;
            int cur = getFactors(mid, a, b, c);
            // step left or right
            if (cur < N)
                left = mid+1;
            else if (cur > N)
                right = mid-1;
            else
                right = mid-1;
        }
        // return left bound
        return left;
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
            return y;
        return gcd(y, x%y);
    }
}
