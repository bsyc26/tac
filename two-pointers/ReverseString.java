/** Reverse the string (char[]) in-place with O(1) space */

// leetcode 344
// two-pointers:left-right
// T: O(N)
// S: O(1)

public class Solution {
    // core method
    public void reverseString(char[] s) {
        // const
        int N = s.length;
        // var
        int left = 0;
        int right = N-1;
        // two-pointers:left-right
        while (left < right) {
            // swap elems
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            // step next
            ++left;
            --right;
        }
    }
}
