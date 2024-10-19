/** Return the min substring of s to have all chars (duplicates including) of t, else "" */

// leetcode 76
// sliding-window + hash
// T: O(M+N)
// S: O(M+N)

import java.util.HashMap;

public class Solution {
    // core method
    public String minWindow(String s, String t) {
        // edge case
        if (s.length() < t.length()) return "";
        // const
        int N = s.length();
        // DS
        HashMap<Character, Integer> tCharToCnt = new HashMap<>(); // char: count of String t
        for (char c : t.toCharArray())
            tCharToCnt.put(c, tCharToCnt.getOrDefault(c,0)+1);
        HashMap<Character, Integer> winCharToCnt = new HashMap<>(); // char: count of window
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
            char charRight = s.charAt(right);
            ++right;
            // update states
            if (tCharToCnt.containsKey(charRight)) {
                winCharToCnt.put(charRight, winCharToCnt.getOrDefault(charRight,0)+1); // update window
                if (winCharToCnt.get(charRight).equals(tCharToCnt.get(charRight)))
                    ++numMatch; // update state
            }
            // step left
            while (numMatch == tCharToCnt.size()) {
                if (right-left < minLen) {
                    start = left;
                    minLen = right - left; // update res
                }
                char charLeft = s.charAt(left);
                ++left;
                if (tCharToCnt.containsKey(charLeft)) {
                    if (winCharToCnt.get(charLeft).equals(tCharToCnt.get(charLeft)))
                        --numMatch;
                    winCharToCnt.put(charLeft, winCharToCnt.get(charLeft)-1); // update window
                }
            }
        }
        // return res or fallback
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start+minLen);
    }
}
