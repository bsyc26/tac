/** Return true if s2 contains a perm of s1, else false */

// leetcode 567
// sliding-window + hash
// T: O(M+N)
// S: O(M+N)

import java.util.HashMap;

public class Solution {
    // core method
    public boolean checkInclusion(String s1, String s2) {
        // edge case
        if (s2.length() < s1.length()) return false;
        // const
        int N = s2.length();
        // data struct
        HashMap<Character, Integer> s1CharToCnt = new HashMap<>(); // char: count of String s1
        for (char c : s1.toCharArray())
            s1CharToCnt.put(c, s1CharToCnt.getOrDefault(c,0)+1);
        HashMap<Character, Integer> winCharToCnt = new HashMap<>(); // char: count of window
        // var
        int left = 0;
        int right = 0;
        int numMatch = 0;
        // sliding window
        while (right < N) {
            // step right
            char charRight = s2.charAt(right);
            ++right;
            // update states
            if (s1CharToCnt.containsKey(charRight)) {
                winCharToCnt.put(charRight, winCharToCnt.getOrDefault(charRight,0)+1); // update window
                if (winCharToCnt.get(charRight).equals(s1CharToCnt.get(charRight)) // update numMatch
                    ++numMatch;
            } 
            // step left
            while (right-left == s1.length()) {
                if (numMatch == s1CharToCnt.size()) // find required case
                    return true;
                char charLeft= s2.charAt(left);
                ++left;
                if (s1CharToCnt.containsKey(charLeft)) {
                    if (winCharToCnt.get(charLeft).equals(s1CharToCnt.get(charLeft))) // update numMatch
                        --numMatch;
                    winCharToCnt.put(charLeft, winCharToCnt.get(charLeft)-1); // update window
                }
            }
        }
        // return fallback
        return false;
    }
}
