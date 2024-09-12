import java.util.HashMap;
/** Return the min substring of s to have all chars (duplicates including) of t, else "" */
public class Solution { // leetcode 76
    // sliding-window + hash-map
    public String minWindow(String s, String t) { // T: O(M+N), S: O(M+N).
        // edge case
        if (s.length() < t.length()) return "";
        // constants
        int N = s.length();
        // data structures
        HashMap<Character, Integer> mapT = new HashMap<>(); // char: occurrence
        for (char c : t.toCharArray())
            mapT.put(c, mapT.getOrDefault(c,0)+1);
        HashMap<Character, Integer> mapWin = new HashMap<>(); // char: occurrence
        // variables
        int left = 0;
        int right = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE; // substring [start, minLen)
        int numMatch = 0; // num of char-occurrence pairs matched of win to t
        // sliding window
        while (right < N) {
            // step right
            char charR = s.charAt(right);
            ++right;
            if (mapT.containsKey(charR)) {
                mapWin.put(charR, mapWin.getOrDefault(charR,0)+1); // update window
                if (mapWin.get(charR).equals(mapT.get(charR))) // update states
                    ++numMatch;
            }
            // step left
            while (numMatch == mapT.size()) { // valid window cond
                if (right-left < minLen) { // comp states
                    start = left;
                    minLen = right - left;
                }
                char charLeft = s.charAt(left);
                ++left;
                if (mapT.containsKey(charLeft)) {
                    if (mapWin.get(charLeft).equals(mapT.get(charLeft))) // update states
                        --numMatch;
                    mapWin.put(charLeft, mapWin.get(charLeft)-1); // update window
                }
            }
        }
        // return
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start+minLen);
    }
}
