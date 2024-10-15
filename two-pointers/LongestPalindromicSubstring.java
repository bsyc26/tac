/** Return the longest palindromic substring of s
  * palindromic: s[i] == s[N-1-i] */
// leetcode 5
// two-pointers: left-right
// T: O(N2), S: O(1).
public class Solution {
    // states
    private String str;
    private int maxLen;
    private int startIdx; // res is str.substring(startIdx, maxLen)
    // main method
    public String longestPalindrome(String s) {
        // field
        str = s;
        maxLen = 0;
        startIdx = 0;
        // const
        int N = str.length();
        // edge case
        if (N == 1) return str;
        // loop && update states
        for (int i = 0; i < N; i++) { // every s[i] or (s[i], s[i+1]) are considered as mid point
            getPalindrome(i, i); // odd size 
            getPalindrome(i, i+1); // even size
        }
        // return
        return s.substring(startIdx, startIdx+maxLen); // [start, start+maxLen)
    }
    // support method
    private void getPalindrome(int left, int right) {
        // const
        int N = str.length();
        // two pointers: mid-left-right
        while (left >= 0 && right < N && str.charAt(left) == str.charAt(right)) {
            --left;
            ++right;
        }
        int curLen = right - (left+1); // palindrome range is [left+1, right)
        // update state
        if (curLen > maxLen) {
            maxLen = curLen;
            startIdx = left + 1;
        }
    }
}

// follow up: Manacher O(N)
