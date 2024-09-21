import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Arrays;
/** Return all possible sentences by adding spaces to s to make words in wordDict (can be re-used) */
public class Solution { // leetcode 140
    // field
    private HashSet<String> setWord;
    private List<String>[] memo;
    private String STR_S;
    private int LEN_S;
    // dp-memo
    public List<String> wordBreak(String s, List<String> wordDict) { // T: O(N3), S: O(N2).
        // const
        STR_S = s;
        LEN_S = s.length();
        // data strcut
        setWord = new HashSet<>(wordDict);
        memo = new List[LEN_S];
        // return
        return dp(0);
    }
    private List<String> dp(int start) {
        // var
        List<String> sents = new LinkedList<>();
        // base case
        if (start == LEN_S) {
            sents.add("");
            return sents;
        }
        // jump memo
        if (memo[start] != null)
            return memo[start];
        // state transfer
        for (int len = 1; start+len <= LEN_S; len++) {
            String sub = STR_S.substring(start, start+len); // [start, start+len)
            if (setWord.contains(sub)) { // 
                List<String> subSents = dp(start+len); // get sents of [start+len..]
                for (String subSent : subSents) {
                    if (subSent.isEmpty())
                        sents.add(sub); // prevent extra space
                    else
                        sents.add(sub + " " + subSent); // add sub word to sent
                }
            }
        }
        // update memo
        memo[start] = sents;
        // return
        return sents;
    }
}
