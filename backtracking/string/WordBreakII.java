import java.util.List;
import java.util.LinkedList;
/** Return all possible sentences by adding spaces to s to make words in wordDict (can be re-used) */
public class Solution { // leetcode 140
    // field
    private List<String> sents;
    private List<String> track;
    private List<String> words;
    private String STR_S;
    private int LEN_S;
    // backtrack
    public List<String> wordBreak(String s, List<String> wordDict) { // T: O(2N), S: O(N).
        // const
        STR_S = s;
        LEN_S = s.length(); 
        // data struct
        track = new LinkedList<>();
        // var
        sents = new LinkedList<>();
        words = new LinkedList<>(wordDict);
        // backtrack
        backtrack(0);
        // return
        return sents;
    }
    private void backtrack(int start) {
        // base case
        if (start == LEN_S) {
            sents.add(String.join(" ", track));
            return;
        }
        // backtrack
        for (String word : words) {
            int len = word.length();
            if (start+len > LEN_S)
                continue;
            String sub = STR_S.substring(start, start+len);
            if (sub.equals(word)) {
                // make decision
                track.add(word);
                // next level
                backtrack(start+len);
                // cancel decision
                track.remove(track.size()-1);
            }
        }
    }
}
