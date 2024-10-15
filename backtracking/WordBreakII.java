/** Return all possible sentences by adding spaces to s to make all words in wordDict (allow re-used) */

// leetcode 140
// backtracking
// T: O(2^N)
// S: O(N)

import java.util.List;
import java.util.LinkedList;

public class Solution {
    // states
    private List<String> sents;
    private List<String> wordDict;
    // DS
    private List<String> track;

    // core method
    public List<String> wordBreak(String s, List<String> wordDict) {
        // const
        String str = s;
        // fields
        this.track = new LinkedList<>();
        this.sents = new LinkedList<>();
        this.wordDict = wordDict; // cdeep copy
        // backtracking
        backtrack(str, 0); // start from str[0]
        // return res
        return sents;
    }

    // support method
    private void backtrack(String str, int start) {
        // const
        int N = str.length();
        // base case
        if (start == N) {
            this.sents.add(String.join(" ", track));
            return;
        }
        // backtracking
        for (String word : this.wordDict) {
            int len = word.length();
            // jump if over size
            if (start+len > N) continue;
            String sub = str.substring(start, start+len);
            // cond sub
            if (sub.equals(word)) {
                // make decision
                this.track.add(word);
                // next level
                backtrack(str, start+len);
                // cancel decision
                this.track.removeLast();
            }
        }
    }
}
