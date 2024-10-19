/** Return true if is a palindrome linked list, otherwise false */

// leetcode 234
// two-potiners:fast-slow+parallel
// T: O(N)
// S: O(1)

public class Solution {
    // core method
    public boolean isPalindrome(ListNode head) {
        // var
        ListNode fast = head;
        ListNode slow = head;
        ListNode preRev = new ListNode(Integer.MIN_VALUE); // to restore the rev part
        preRev.next = slow;
        // two pointers: fast-slow to find the mid node
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            preRev = preRev.next;
        }
        if (fast != null) { // case: odd nodes in linked list
            slow = slow.next;
            preRev = preRev.next;
        }
        // var
        ListNode left = head;
        ListNode right = reverse(slow); // rev the second half nodes
        ListNode revHead = right;
        // two pointers: parallel to check if palindorme
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        // restore rev
        preRev.next = reverse(revHead);
        // return fallback
        return true;
    }

    // support method
    private ListNode reverse(ListNode head) {
        // base case
        if (head == null || head.next == null)
            return head;
        // var
        ListNode pred = null;
        ListNode cur = head;
        ListNode succ = head.next;
        // iter
        while (cur != null) {
            // rev
            cur.next = pred;
            // step
            pred = cur;
            cur = succ;
            succ = (succ == null) ? null : succ.next;
        }
        // return
        return pred;
    }
}

// linked-list to array
// T: O(N), S: O(N).
public class Solution {
    public boolean isPalindrome(ListNode head) {
        // var
        ListNode walker = head;
        int[] nums = new int[100000]; // num of nodes range [1, 100000]
        int size = 0;
        // loop linked-list
        while (walker != null) {
            nums[size] = walker.val;
            walker = walker.next;
            ++size;
        }
        // var
        int left = 0;
        int right = size-1;
        // two-pointers: left-right
        while (left < right) {
            if (nums[left] != nums[right]) // case not palindorme
                return false;
            ++left;
            --right;
        }
        // is palindorme
        return true;
    }
}
