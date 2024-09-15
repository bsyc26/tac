/** Return true if n is ugly num
  * ugly num: pos int whose prime factors are limited to 2, 3, 5 */
public class Solution { // leetcode 263
    // math: factor
    public boolean isUgly(int n) { // T: O(N), S: O(1).
        // edge case
        if (n <= 0) return false;
        // const
        int N = n;
        // var
        int num = N;
        // divide n into 2, 3, 5
        while (num % 2 == 0)
            num /= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;
        // return
        return num == 1;
    }
}
