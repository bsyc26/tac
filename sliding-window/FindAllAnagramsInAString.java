import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
/** Return an array of all the start idx of p's anagrams in s in any order
  * anagram: re-arranging words using all the original letters exactly once */
// leetcode 438
// sliding-window + hash
// T: O(M+N), S: O(M+N).
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // edge case
        if (p.length() > s.length()) return new LinkedList<>();
        // const
        int N = s.length();
        int LEN_P = p.length(); // required LEN of window
        // data struct
        HashMap<Character, Integer> pCharCnt = new HashMap<>(); // of String p
        for (char c : p.toCharArray())
            pCharCnt.put(c, pCharCnt.getOrDefault(c,0)+1);
        HashMap<Character, Integer> winCharCnt = new HashMap<>(); // char: freq of window
        // res
        List<Integer> anagStarts = new LinkedList<>();
        // var
        int left = 0;
        int right = 0;
        int numMatch = 0; // num of char-occurrence pairs matched of window to p
        // sliding window
        while (right < N) {
            // step right
            char chRt = s.charAt(right);
            ++right;
            // update state
            if (pCharCnt.containsKey(chRt)) {
                winCharCnt.put(chRt, winCharCnt.getOrDefault(chRt,0)+1);
                if (winCharCnt.get(chRt).equals(pCharCnt.get(chRt)))
                    ++numMatch;
            }
            // step left
            while (right-left == LEN_P) {
                if (numMatch == pCharCnt.size()) // update res
                    anagStarts.add(left);
                char chLf = s.charAt(left);
                ++left;
                if (pCharCnt.containsKey(chLf)) {
                    if (winCharCnt.get(chLf).equals(pCharCnt.get(cLf)))
                        --numMatch;
                    winCharCnt.put(chLf, winCharCnt.get(cLf)-1);
                }
            }
        }
        // return res
        return anagStarts;
    }
}
