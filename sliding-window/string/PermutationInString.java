import java.util.HashMap;
/** Return true if s2 contains a perm of s1, else false */
public class Solution { // leetcode 567
    // sliding-window + hash-map
    public boolean checkInclusion(String s1, String s2) { // T: O(M+N), S: O(M+N).
        // edge case
        if (s2.length() < s1.length()) return false;
        // const
        int N = s2.length();
        // data struct
        HashMap<Character, Integer> mapS1 = new HashMap<>();
        for (char c : s1.toCharArray())
            mapS1.put(c, mapS1.getOrDefault(c,0)+1);
        HashMap<Character, Integer> mapWin = new HashMap<>();
        // var
        int left = 0;
        int right = 0;
        int numMatch = 0; // num of char-occurrence pairs matched of window to s1
        // sliding window
        while (right < N) {
            // step right
            char charR = s2.charAt(right);
            ++right;
            if (mapS1.containsKey(charR)) {
                mapWin.put(charR, mapWin.getOrDefault(charR,0)+1); // update window
                if (mapWin.get(charR).equals(mapS1.get(charR))) // update states
                    ++numMatch;
            } 
            // step left
            while (right-left == s1.length()) { // valid window cond
                if (numMatch == mapS1.size()) // comp states
                    return true;
                char charL= s2.charAt(left);
                ++left;
                if (mapS1.containsKey(charL)) {
                    if (mapWin.get(charL).equals(mapS1.get(charL))) // update states
                        --numMatch;
                    mapWin.put(charL, mapWin.get(charL)-1); // update window
                }
            }
        }
        // return fallback
        return false;
    }
}
