/** Return the max len of substring without repeating chars of s */

// leetcode 3
// sliding-window + hash-map
// T: O(N)
// S: O(N)

import java.util.HashMap;

public class Solution {
    // core method
    public int lengthOfLongestSubstring(String s) {
        // edge case
        if (s.length() == 0) return 0;
        // const
        int N = s.length();
        // DS
        HashMap<Character, Integer> charToCnt = new HashMap<>(); // char: count
        // var
        int left = 0;
        int right = 0;
        // res
        int maxLen = 0;
        // sliding-window
        while (right < N) {
            // step right
            char charRight = s.charAt(right);
            ++right;
            // update charToCnt hash-map
            charToCnt.put(charRight, winCharCnt.getOrDefault(charRight,0)+1);
            // step left
            while (winCharCnt.get(chRt) > 1) {
                char chLf = s.charAt(left);
                ++left;
                winCharCnt.put(chLf, winCharCnt.get(chLf)-1);
            }
            // update res
            maxLen = Math.max(maxLen, right-left);
        }
        // return res
        return maxLen;
    }
}
