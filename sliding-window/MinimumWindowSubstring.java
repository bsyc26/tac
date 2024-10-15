import java.util.HashMap;
/** Return the min substring of s to have all chars (duplicates including) of t, else "" */
// leetcode 76
// sliding-window + hash
// T: O(M+N), S: O(M+N).
public class Solution {
    public String minWindow(String s, String t) {
        // edge case
        if (s.length() < t.length()) return "";
        // const
        int N = s.length();
        // data struct
        HashMap<Character, Integer> tCharCnt = new HashMap<>(); // char: count of String t
        for (char c : t.toCharArray())
            tCharCnt.put(c, tCharCnt.getOrDefault(c,0)+1);
        HashMap<Character, Integer> winCharCnt = new HashMap<>(); // char: count of window
        // var
        int left = 0;
        int right = 0;
        int start = 0;
        int numMatch = 0; // num of char-occurrence pairs matched of win to t
        // res
        int minLen = Integer.MAX_VALUE; // substring [start, minLen)
        // sliding window
        while (right < N) {
            // step right
            char chRt = s.charAt(right);
            ++right;
            // update states
            if (tCharCnt.containsKey(chRt)) {
                winCharCnt.put(chRt, winCharCnt.getOrDefault(chRt,0)+1); // update window
                if (winCharCnt.get(chRt).equals(tCharCnt.get(chRt)))
                    ++numMatch; // update state
            }
            // step left
            while (numMatch == tCharCnt.size()) {
                if (right-left < minLen) {
                    start = left;
                    minLen = right - left; // update res
                }
                char chLf = s.charAt(left);
                ++left;
                if (tCharCnt.containsKey(chLf)) {
                    if (winCharCnt.get(chLf).equals(tCharCnt.get(chLf)))
                        --numMatch;
                    winCharCnt.put(chLf, winCharCnt.get(chLf)-1); // update window
                }
            }
        }
        // return
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start+minLen);
    }
}
