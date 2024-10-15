import java.util.HashMap;
/** Return the max len of substring without repeating chars of s */
// leetcode 3
// sliding-window + hash
// T: O(N), S: O(N).
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // edge case
        if (s.length() == 0) return 0;
        // const
        int N = s.length();
        // data struct
        HashMap<Character, Integer> winCharCnt = new HashMap<>(); // char: count
        // var
        int left = 0;
        int right = 0;
        // res
        int maxLen = 0;
        // sliding window
        while (right < N) {
            // step right
            char chRt = s.charAt(right);
            ++right;
            // update state
            winCharCnt.put(chRt, winCharCnt.getOrDefault(chRt,0)+1);
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
