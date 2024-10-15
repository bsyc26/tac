/** Reverse the string (char[]) in-place with O(1) space */
// leetcode 344
// two-pointers: left-right
// T: O(N), S: O(1).
public class Solution {
    public void reverseString(char[] s) {
        // const
        int N = s.length;
        // var
        int left = 0;
        int right = N-1;
        // two pointers: left-right
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
