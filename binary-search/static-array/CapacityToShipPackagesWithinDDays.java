/** Return the min capacity to send all pkgs within days
  * weights[i] is the weight of i-th pkg */
// leetcode 1011
// binary-search: left-bound
// T: O(logN), S: O(1).
public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // const
        int DAYS = days; // Target days
        // var
        int left = 0;
        int right = 1; // [left, right)
        for (int weight : weights) {
            left = Math.max(left, weight); // f(left) ~ max days
            right += weight; // f(right) ~ min days
        }
        // binary search
        while (left < right) {
            // calc mid
            int mid = left + (right-left)/2;
            int curDays = f(weights, mid);
            // step next
            if (curDays < DAYS)
                right = mid;
            else if (curDays > DAYS)
                left = mid+1;
            else
                right = mid;
        }
        // return
        return left;
    }
    private int f(int[] weights, int x) { // f(x) ~ -x
        int N = weights.length; // const
        int days = 0; // var
        for (int i = 0; i < N; ) {
            int cap = x;
            while (i < N) {
                int curWeight = weights[i];
                if (cap < curWeight)
                    break;
                else
                    cap -= curWeight;
                ++i;
            }
            ++days;
        }
        return days; // return
    }
}
