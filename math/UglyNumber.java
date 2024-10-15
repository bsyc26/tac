/** Return true if n is ugly num
  * ugly num: pos int whose prime factors are limited to 2, 3, 5 */
// leetcode 263
// math: factor
// T: O(N), S: O(1).
public class Solution {
    public boolean isUgly(int n) {
        // const
        int N = n;
        // edge case
        if (N <= 0) return false;
        // res
        int num = N;
        // divide n into 2, 3, 5
        while (num % 2 == 0)
            num /= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;
        // return res
        return num == 1;
    }
}
