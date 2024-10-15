import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
/** Return the min num of turns to open the lock
  * lock init at "0000", need to be target, each turn can +1/-1 one digit of four
  * if meet deadends lock will freeze and unable to be turn any more */
public class Solution { // leetcode 752
    // bfs + hash-set
    public int openLock(String[] deadends, String target) { // T: O(2N), S: O(N).
        // const
        String TGT = target;
        // data struct
        HashSet<String> deads = new HashSet<>();
        for (String dead : deadends)
            deads.add(dead);
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        // var
        int step = 0;
        // bfs
        while (!q.isEmpty()) {
            // cnt level
            int sz = q.size();
            // loop level
            for (int i = 0; i < sz; i++) {
                // poll
                String cur = q.poll();
                // comp states
                if (deads.contains(cur))
                    continue;
                if (cur.equals(TGT))
                    return step;
                // offer
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String dn = minusOne(cur, j);
                    if (!visited.contains(dn)) {
                        q.offer(dn);
                        visited.add(dn);
                    }
                }
            }
            // step level
            ++step;
        }
        // return fallback
        return -1;
    }
    private String plusOne(String str, int idx) {
        char[] chars = str.toCharArray();
        chars[idx] = (chars[idx] == '9') ? '0' : (char)(1+chars[idx]);
        return new String(chars);
    }
    private String minusOne(String str, int idx) {
        char[] chars = str.toCharArray();
        chars[idx] = (chars[idx] == '0') ? '9' : (char)(chars[idx]-1);
        return new String(chars);
    }
}
