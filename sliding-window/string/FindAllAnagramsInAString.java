import java.util.List;
import java.util.ArrayList;
/** Return an array of all the start idx of p's anagrams in s in any order
  * anagram: re-arranging words using all the original letters exactly once */
public class Solution { // leetcode 438
    // sliding-window + hashMap
    public List<Integer> findAnagrams(String s, String p) { // T: O(M+N), S: O(M+N).
        // edge case
        if (p.length() > s.length()) return new LinkedList<>();
        // constants
        int N = s.length();
        int LEN = p.length(); // required LEN of window
        // data structures
        HashMap<Character, Integer> mapP = new HashMap<>();
        for (char c : p.toCharArray())
            mapP.put(c, mapP.getOrDefault(c,0)+1);
        HashMap<Character, Integer> mapWin = new HashMap<>();
        // variables
        List<Integer> anagStarts = new LinkedList<>();
        int left = 0;
        int right = 0;
        int numMatch = 0; // num of char-occurrence pairs matched of window to p
        // sliding window
        while (right < N) {
            // step right
            char charR = s.charAt(right);
            ++right;
            if (mapP.containsKey(charR)) { // update states
                mapWin.put(charR, mapWin.getOrDefault(charR,0)+1);
                if (mapWin.get(charR).equals(mapP.get(charR)))
                    ++numMatch;
            }
            // step left
            while (right-left == LEN) { // valid window cond
                if (numMatch == mapP.size()) // comp states
                    anagStarts.add(left);
                char charL = s.charAt(left);
                ++left;
                if (mapP.containsKey(charL)) { // update states
                    if (mapWin.get(charL).equals(mapP.get(charL)))
                        --numMatch;
                    mapWin.put(charL, mapWin.get(charL)-1);
                }
            }
        }
        // return
        return anagStarts;
    }
}
