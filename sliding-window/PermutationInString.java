import java.util.HashMap;
/** Return true if s2 contains a perm of s1, else false */
// leetcode 567
// sliding-window + hash
// T: O(M+N), S: O(M+N).
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // edge case
        if (s2.length() < s1.length()) return false;
        // const
        int N = s2.length();
        // data struct
        HashMap<Character, Integer> s1CharCnt = new HashMap<>(); // char: count of String s1
        for (char c : s1.toCharArray())
            s1CharCnt.put(c, s1CharCnt.getOrDefault(c,0)+1);
        HashMap<Character, Integer> winCharCnt = new HashMap<>(); // char: count of window
        // var
        int left = 0;
        int right = 0;
        int numMatch = 0;
        // sliding window
        while (right < N) {
            // step right
            char chRt = s2.charAt(right);
            ++right;
            // update states
            if (s1CharCnt.containsKey(chRt)) {
                winCharCnt.put(chRt, winCharCnt.getOrDefault(chRt,0)+1); // update window
                if (winCharCnt.get(chRt).equals(s1CharCnt.get(chRt))) // update numMatch
                    ++numMatch;
            } 
            // step left
            while (right-left == s1.length()) {
                if (numMatch == s1CharCnt.size()) // find required case
                    return true;
                char chLf= s2.charAt(left);
                ++left;
                if (s1CharCnt.containsKey(chLf)) {
                    if (winCharCnt.get(chLf).equals(s1CharCnt.get(chLf))) // update numMatch
                        --numMatch;
                    winCharCnt.put(chLf, winCharCnt.get(chLf)-1); // update window
                }
            }
        }
        // return fallback
        return false;
    }
}
