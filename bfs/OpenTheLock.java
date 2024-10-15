/** Return the min num of turns to open the lock
  * lock init at "0000", need to be target, each turn can +1/-1 one digit of four
  * if meet deadends lock will freeze and unable to be turn any more */

// leetcode 752
// bfs + hash-set
// T: O(2^N)
// S: O(N)

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class Solution {
    // core method
    public int openLock(String[] deadends, String target) {
        // const
        target = target;
        // var
        HashSet<String> deads = new HashSet<>(); // deadends to hash-set for de-dup
        for (String dead : deadends) deads.add(dead);
        // DS
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        // res
        int step = 0;
        // bfs
        while (!q.isEmpty()) {
            // count level size
            int sz = q.size();
            // traverse level elems
            for (int i = 0; i < sz; i++) {
                // poll
                String cur = q.poll();
                // jump deads
                if (deads.contains(cur)) continue;
                // return step if find target
                if (cur.equals(target))
                    return step;
                // offer
                for (int digit = 0; digit < 4; digit++) {
                    String up = plusOne(cur, digit);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String dn = minusOne(cur, digit);
                    if (!visited.contains(dn)) {
                        q.offer(dn);
                        visited.add(dn);
                    }
                }
            }
            // step level
            ++step;
        }
        // return fallback -1 if not match target
        return -1;
    }

    // support methods
    private String plusOne(String str, int idx) { // returns the String plus by one at idx
        char[] chars = str.toCharArray();
        chars[idx] = (chars[idx] == '9') ? '0' : (char)(chars[idx]+1);
        return String.valueOf(chars);
    }
    private String minusOne(String str, int idx) { // returns the String minus by one at idx
        char[] chars = str.toCharArray();
        chars[idx] = (chars[idx] == '0') ? '9' : (char)(chars[idx]-1);
        return String.valueOf(chars);
    }
}
