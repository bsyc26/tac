/** Reverse the string (char[]) in-place
  * S: O(1) */
public class Solution { // leetcode 344
    // two-pointers: left-right
    public void reverseString(char[] s) { // T: O(N), S: O(1).
        // const
        int N = s.length;
        // var
        int left = 0;
        int right = N-1;
        // two pointers
        while (left < right) {
            // swap
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            // step 
            ++left;
            --right;
        }
    }
}
