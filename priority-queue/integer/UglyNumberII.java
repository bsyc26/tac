/** Return the n-th ugly num
  * ugly num: pos int whose prime factors are limited to 2, 3, 5 */
public class Solution { // leetcode 264
    // priority-queue: state
    public int nthUglyNumber(int n) { // T: O(N), S: O(N).
        // const
        int N = n;
        // data struct
        int pt2 = 1;
        int pt3 = 1;
        int pt5 = 1;
        int prod2 = 1; // state div by 2: {1, 2, 4, 8, ...}
        int prod3 = 1; // state div by 3: {1, 3, 6, 9, ...}
        int prod5 = 1; // state div by 5: {1, 5, 10, 15, ...}
        // var
        int[] ugly = new int[N+1]; // [0, 1..N]
        int idx = 1;
        // priority queue
        while (idx <= N) {
            // poll
            int min = Math.min(Math.min(prod2, prod3), prod5);
            // update state
            ugly[idx] = min;
            ++idx;
            // offer
            if (min == prod2) {
                prod2 = 2 * ugly[pt2];
                ++pt2;
            }
            if (min == prod3) {
                prod3 = 3 * ugly[pt3];
                ++pt3;
            }
            if (min == prod5) {
                prod5 = 5 * ugly[pt5];
                ++pt5;
            }
        }
        // return
        return ugly[N];
    }
}
