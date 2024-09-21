/** Return the n-th ugly number
  * ugly number: divisble by a, b or c */
public class Solution { // leetcode 1201
    // binary search
    public int nthUglyNumber(int n, int a, int b, int c) { // 
        // const
        int N = n;
        // var
        int lo = 1;
        int hi = (int)2e9;
        // binary search
        while (lo <= hi) { // [1..2e9]
            // calc mid
            int mid = lo + (hi-lo)/2;
            // step left or right
            if (getFactors(mid, a, b, c) < N)
                lo = mid+1;
            else
                hi = mid-1;
        }
        // return
        return lo;
    }
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
