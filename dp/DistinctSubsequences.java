import java.util.Arrays;
/** Return the num of distinct sub seq (can be non-consecutive) of s equals to t */
public class Solution { // leetcode 115
    // field
    private int[][] memo;
    String STR_S;
    String STR_T;
    int LEN_S;
    int LEN_T;
    // dp-memo
    public int numDistinct(String s, String t) { // T: O(MN), S: O(MN).
        // edge case
        if (s.length() < t.length()) return 0;
        // const
        LEN_S = s.length();
        LEN_T = t.length();
        STR_S = s;
        STR_T = t;
        // data struct
        memo = new int[LEN_S][LEN_T]; // memo[i][j] is num of occurrence of t[j..] in s[i..]
        for (int[] row : memo)
            Arrays.fill(row, -1);
        // return
        return dp(0, 0);
    }
    private int dp(int idxS, int idxT) { // calc the num of seq of s[idxS..] equals to t[idxT..]
        // base case
        if (idxT == LEN_T)
            return 1;
        if (LEN_S - idxS < LEN_T - idxT)
            return 0;
        // jump memo
        if (memo[idxS][idxT] != -1)
            return memo[idxS][idxT];
        // var
        int cnt = 0;
        // state transfer
        if (STR_S.charAt(idxS) == STR_T.charAt(idxT))
            cnt = dp(1+idxS, 1+idxT) + dp(1+idxS, idxT); // 1st char match then plus 2nd char match
        else
            cnt = dp(1+idxS, idxT); // 1st char not match then step char in s
        // update memo
        memo[idxS][idxT] = cnt;
        // return
        return cnt;
    }
}
