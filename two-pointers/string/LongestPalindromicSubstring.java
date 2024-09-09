/** Return the longest palindromic substring of s
  * palindromic: s[i] == s[N-1-i] */
public class Solution { // leetcode 5
    // fields
    private int maxLen = 0; // max len of palindrome substring
    private int start = 0; // start idx of the palindrome substring of max len
    // two-pointers: left-right
    public String longestPalindrome(String s) { // T: O(N2), S: O(1).
        // constants
        int N = s.length();
        // edge case
        if (N == 1) return s;
        // scan compare
        for (int i = 0; i < N; i++) {
            getPalindrome(s, i, i); // odd size 
            getPalindrome(s, i, i+1); // even size
        }
        // return
        return s.substring(start, start+maxLen); // [start, start+maxLen)
    }
    private void getPalindrome(String str, int left, int right) {
        // constants
        int N = str.length();
        // two pointers
        while (left >= 0 && right < N && str.charAt(left) == str.charAt(right)) {
            --left;
            ++right;
        }
        // compare maxLen
        int curLen = right - left - 1; // [left+1, right) size 
        if (curLen > maxLen) {
            maxLen = curLen;
            start = left + 1;
        }
    }
}

// follow up: Manacher O(N)
