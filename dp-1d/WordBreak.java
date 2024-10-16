/** Return true if s can be seg into comb of wordDict elems (can be re-used) */

// leetcode 139
// dp-memo
// T: O(N^3)
// S: O(N)

import java.util.HashSet;
import java.util.Arrays;

public class Solution {
    // states
    private final int DF_VAL = -1;
    private final int FAIL = 0;
    private final int SUCC = 1;
    // DS
    private HashSet<String> words;
    private int[] memo;

    // core method
    public boolean wordBreak(String s, List<String> wordDict) {
        // const 
        String str = s;
        int N = str.length();
        int DF_VAL = -1; // default value
        // fields
        this.words = new HashSet<>(wordDict);
        this.memo = new int[N];
        Arrays.fill(memo, DF_VAL); 
        // return dp from index 0
        return dp(str, 0);
    }

    // support method
    private boolean dp(String str, int start) {
        // const
        int N = str.length();
        // base case
        if (start == N)
            return true;
        // jump memo
        if (this.memo[start] != DF_VAL)
            return (this.memo[start] == FAIL) ? false : true;
        // state transfer
        for (int len = 1; start+len <= N; len++) {
            String sub = str.substring(start, start+len); // sub: str[start, start+len)
            if (this.words.contains(sub)) {
                if (dp(str, start+len) == true) {
                    this.memo[start] = SUCC; // update memo with SUCC
                    return true;
                }
            }
        }
        // update memo with FAIL
        this.memo[start] = 0;
        // return fallback false
        return false;
    }
}
