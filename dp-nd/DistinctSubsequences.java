/** Return the num of distinct sub seq (can be non-consecutive) of s equals to t */

// leetcode 115
// dp-memo
// T: O(MN)
// S: O(MN)

import java.util.Arrays;

public class Solution {
    // states
    private final int DF_VAL = -1; // default value
    // DS
    private int[][] memo;

    // core method
    public int numDistinct(String s, String t) {
        // edge case
        if (s.length() < t.length()) return 0;
        // const
        int LEN_S = s.length();
        int LEN_T = t.length();
        // field
        this.memo = new int[LEN_S][LEN_T]; // i, j is start idx of String s and t
        for (int[] row : this.memo)
            Arrays.fill(row, DF_VAL);
        // return res
        return dp(s, t, 0, 0); // String s and t start from 0
    }

    // support method
    private int dp(String s, String t, int startS, int startT) {
        // const 
        int LEN_S = s.length();
        int LEN_T = t.length();
        // base case
        if (startT == LEN_T)
            return 1;
        if (LEN_S - startS < LEN_T - startT) // no more sub possible to match
            return 0;
        // jump memo
        if (memo[startS][startT] != DF_VAL) return memo[startS][startT];
        // res
        int cnt = 0;
        // state transfer
        if (s.charAt(startS) == t.charAt(startT)) // if start char matches
            cnt = dp(s, t, startS+1, startT+1) + dp(s, t, startS+1, startT);
        else
            cnt = dp(s, t, startS+1, startT);
        // update memo
        memo[startS][startT] = cnt;
        // return
        return cnt;
    }
}
