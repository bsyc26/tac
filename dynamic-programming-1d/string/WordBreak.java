import java.util.HashSet;
import java.util.Arrays;
/** Return true if s can be seg into comb of wordDict elems (can be re-used) */
public class Solution { // leetcode 139
    // field
    private HashSet<String> setWord;
    private int[] memo;
    private String STR_S;
    private int LEN_S;
    // dp-memo + hash-set
    public boolean wordBreak(String s, List<String> wordDict) { // T: O(N3), S: O(N).
        // const 
        STR_S = s;
        LEN_S = s.length();
        // data struct
        setWord = new HashSet<>(wordDict);
        memo = new int[LEN_S]; // memo[i] is 1 means s[i..] can be composed from wordDict, 0 means not
        Arrays.fill(memo, -1);
        // return
        return dp(0);
    }
    private boolean dp(int start) { // is s[idx..] able to be composed from wordDict
        // base case
        if (start == LEN_S)
            return true;
        // jump memo
        if (memo[start] != -1)
            return (memo[start] == 0) ? false : true;
        // state transfer
        for (int len = 1; start+len <= LEN_S; len++) {
            String sub = STR_S.substring(start, start+len);
            if (setWord.contains(sub)) { // [start, start+len) matches wordDict
                if (dp(start+len) == true) { // plus [start+len..] also matches wordDict (is true)
                    memo[start] = 1; // [start..] can be composed by wordDict
                    return true;
                }
            }
        }
        // update memo fallback
        memo[start] = 0;
        // return fallback
        return false;
    }
}
