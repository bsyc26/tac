import java.util.HashMap;
/** Return the max len of substring without repeating chars of s */
public class Solution { // leetcode 3
    // sliding-window + hash-map
    public int lengthOfLongestSubstring(String s) { // T: O(N), S: O(N).
        // edge case
        if (s.length() == 0) return 0;
        // const
        int N = s.length();
        // data struct
        HashMap<Character, Integer> mapWin = new HashMap<>();
        // var
        int left = 0;
        int right = 0;
        int maxLen = 0;
        // sliding window
        while (right < N) {
            // step right
            char charR = s.charAt(right);
            ++right;
            mapWin.put(charR, mapWin.getOrDefault(charR,0)+1); // update window
            // step left
            while (mapWin.get(charR) > 1) { // invalid window cond
                char charL = s.charAt(left);
                ++left;
                mapWin.put(charL, mapWin.get(charL)-1); // update window
            }
            // valid window cond
            maxLen = Math.max(maxLen, right-left); // update states
        }
        // return
        return maxLen;
    }
}
