/** Return all possible sentences by adding spaces to s to make words in wordDict (can be re-used) */

// leetcode 140
// dp-memo
// T: O(N^3)
// S: O(N^2)

import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {
    // states
    private HashSet<String> words;
    // DS
    private List<String>[] memo;

    // core method
    public List<String> wordBreak(String s, List<String> wordDict) {
        // consts
        String str = s;
        int N = str.length();
        // fields
        this.words = new HashSet<String>(wordDict);
        this.memo = new LinkedList[N];
        // return dp starts from index 0
        return dp(str, 0);
    }

    // support method
    private List<String> dp(String str, int start) {
        // const
        int N = str.length();
        // res
        List<String> sents = new LinkedList<>();
        // base case
        if (start == N) {
            sents.add("");
            return sents;
        }
        // jump memo
        if (memo[start] != null) return memo[start];
        // state transfer
        for (int len = 1; start+len <= N; len++) { // [start, start+len)
            String sub = str.substring(start, start+len);
            if (words.contains(sub)) { // cur sub str matches
                List<String> subSents = dp(str, start+len); // get all sub sents
                for (String subSent : subSents) {
                    if (subSent.isEmpty())
                        sents.add(sub);
                    else
                        sents.add(sub + " " + subSent);
                }
            }
        }
        // update memo
        memo[start] = sents;
        // return
        return sents;
    }
}
